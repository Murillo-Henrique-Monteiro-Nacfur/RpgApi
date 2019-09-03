package hot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.protobuf.Struct;

import java.util.List;

public class DialogOutputDTO {

    String action;
    //Intent intent;
    //Struct parameters;
    String message;

    public DialogOutputDTO(String action, Intent intent, Struct parameters, List<Intent.Message> fulfillment_messages) {
        this.action = action;
        //this.intent = intent;
        //this.parameters = parameters;
        this.message = "";
        for  (Intent.Message text : fulfillment_messages){
            this.message += String.join("",text.getText().getTextList());
        }
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
}
