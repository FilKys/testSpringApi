package springApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springApi.WorkData;

import static springApi.Print.printFormOfIncorporation;

@RestController
public class ControllerIncorporation {
    private final String sharedKey = "SHARED_KEY";
    private WorkData workData = new WorkData();
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping("/incorporation")
    public String getFormOfIncorporation() {
        return printFormOfIncorporation(workData.getFormOfIncorporation());
    }
}
