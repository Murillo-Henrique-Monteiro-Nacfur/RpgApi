package rpgtcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DialogInputDTO {

    private Long sheetId;
    private String message;

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("sheetId")
    public Long getSheetId() {
        return sheetId;
    }

    public void setSheetId(Long sheetId) {
        this.sheetId = sheetId;
    }
}
