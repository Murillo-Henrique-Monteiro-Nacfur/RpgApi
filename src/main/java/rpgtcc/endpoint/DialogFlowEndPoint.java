package rpgtcc.endpoint;

import rpgtcc.dto.DialogInputDTO;
import rpgtcc.dto.DialogOutputDTO;
import rpgtcc.service.DialogFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dialog")
public class DialogFlowEndPoint {

    @Autowired
    private DialogFlowService dialogFlowService;

    @PostMapping
    public DialogOutputDTO getResponse(@RequestBody DialogInputDTO dialogInputDTO){

        try {
            return this.dialogFlowService.getResponse(dialogInputDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
