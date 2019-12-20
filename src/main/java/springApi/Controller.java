package springApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static springApi.Print.*;

@RestController
public class Controller {
    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping("/banks")
    public String getBanks() {
        return printBank(new WorkJSON().readJsonBank());
    }

    @GetMapping("/clients")
    public String getClients() {
        return printClient(new WorkJSON().readJsonClient());
    }

    @GetMapping("/incorporation")
    public String getFormOfIncorporation() {
        return printFormOfIncorporation(new WorkJSON().readJsonFormOfIncorporation());
    }

    @GetMapping("/contributions")
    public String getContributions() {
        return printContributions(new WorkJSON().readJsonContributions());
    }




}
