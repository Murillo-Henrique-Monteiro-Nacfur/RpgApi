package hot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DialogInputDTO {
    private String message;

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
}
