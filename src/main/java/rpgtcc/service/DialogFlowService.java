package rpgtcc.service;

import com.google.cloud.dialogflow.v2.*;
import com.google.cloud.dialogflow.v2.TextInput.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import rpgtcc.dto.DialogInputDTO;
import rpgtcc.dto.DialogOutputDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rpgtcc.model.Item;
import rpgtcc.model.Product;
import rpgtcc.model.Sheet;
import java.util.Collections;
import java.util.List;

@Service
public class DialogFlowService {

    @Value("${project-id}")
    private String projectId;
    @Value("${language-code}")
    private String languageCode;
    @Autowired
    private MatchService matchService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SheetService sheetService;

    public DialogOutputDTO getResponse(
        /**
         * Returns the result of detect intent with texts as inputs.
         *
         * Using the same `session_id` between requests allows continuation of the conversation.
         *
         * @param projectId    Project/Agent Id.
         * @param texts        The text intents to be detected based on what a user says.
         * @param sessionId    Identifier of the DetectIntent session.
         * @param languageCode Language code of the query.
         * @return The QueryResult for each input text.
         */
        DialogInputDTO dialogInputDTO) throws Exception {

        Long id = dialogInputDTO.getSheetId();

        if(id != 0L) {
            if (!this.matchService.isChatAvailable(id)) {
                return new DialogOutputDTO("",
                        (List<Intent.Message>) Collections.singletonList(
                        Intent.Message
                                .newBuilder()
                                .setText(Intent.Message.Text
                                        .newBuilder()
                                        .addText("O estalajadeiro não está por perto!")
                                        .build())
                                .build()));
            }
        }

        String sessionId = "session" + id.toString();

        // Instantiates a client
        try (SessionsClient sessionsClient = SessionsClient.create()) {
            // Set the session name using the sessionId (UUID) and projectID (my-project-id)
            SessionName session = SessionName.of(projectId, sessionId);
            System.out.println("Session Path: " + session.toString());

                // Set the text (hello) and language code (en-US) for the query
                Builder textInput = TextInput.newBuilder().setText(dialogInputDTO.getMessage()).setLanguageCode(languageCode);

                // Build the query with the TextInput
                QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

                // Performs the detect intent request
                DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

                // Display the query result
                QueryResult queryResult = response.getQueryResult();

                System.out.println("====================");
                System.out.format("Query Text: '%s'\n", queryResult.getQueryText());
                System.out.format("Detected Intent: %s (confidence: %f)\n",
                        queryResult.getIntent().getDisplayName(), queryResult.getIntentDetectionConfidence());
                System.out.format("Fulfillment Text: '%s'\n", queryResult.getFulfillmentText());

                DialogOutputDTO dialogOutputDTO = new DialogOutputDTO(queryResult.getAction(),
                    queryResult.getFulfillmentMessagesList());

                if(queryResult.getAction().equals("PRICE")){


                    Product product = this.productService.readByFlag(queryResult.getParameters().getFieldsMap().get("storeItens").getStringValue());

                    String answer = dialogOutputDTO.getMessage()
                            .replace("[item]", product.getName())
                            .replace("[cost]", product.getPrice().toString());
                    dialogOutputDTO.setMessage(answer);

                    return dialogOutputDTO;
                }

                if(queryResult.getAction().equals("SELL_ITEM")){
                    Product product = this.productService.readByFlag(queryResult.getParameters().getFieldsMap().get("storeItens").getStringValue());
                    Integer quantity = (int)queryResult.getParameters().getFieldsMap().get("number-integer").getNumberValue();
                    String answer;
                    Integer fullprice = quantity * product.getPrice();
                    Sheet character = this.sheetService.findSheetById(id);

                    if(character.getGold() >= fullprice){
                        while (quantity > 0){
                            this.itemService.create(new Item(id, product.getName()));
                            quantity--;
                        }

                        character.setGold(character.getGold() - fullprice);
                        this.sheetService.saveSheet(character);
                        answer = dialogOutputDTO.getMessage()
                                .replace("[item]", product.getName());
                    }else{
                        answer = "Infelizmente você não tem dinheiro suficiente para isso!";
                    }

                    dialogOutputDTO.setMessage(answer);

                    return dialogOutputDTO;
                }
                //queryResult.getFulfillmentMessagesList()
                //queryResult.getParameters()
                //queryResult.getIntent()

                  return new DialogOutputDTO(queryResult.getAction(),
                        queryResult.getFulfillmentMessagesList());
        }
    }
}