package rpgtcc.service;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.cloud.dialogflow.v2.TextInput.Builder;
import rpgtcc.dto.DialogInputDTO;
import rpgtcc.dto.DialogOutputDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class DialogFlowService {

    @Value("${project-id}")
    private String projectId;
    @Value("${language-code}")
    private String languageCode;

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
        String sessionId = "123456789";

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

                //queryResult.getAction()
                //queryResult.getFulfillmentMessagesList()
                //queryResult.getParameters()
                //queryResult.getIntent()

                  return new DialogOutputDTO(queryResult.getAction(),
                        queryResult.getIntent(),
                        queryResult.getParameters(),
                        queryResult.getFulfillmentMessagesList());
        }
    }
}
