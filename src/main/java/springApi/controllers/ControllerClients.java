package springApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springApi.WorkData;
import springApi.sorts.SortClients;

import static springApi.Print.printClient;

@RestController
public class ControllerClients {
    private final String sharedKey = "SHARED_KEY";
    private WorkData workData = new WorkData();
    private SortClients sortClients = new SortClients();
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping("/clients")
    public String getClients() {
        return printClient(workData.getClientList());
    }

    @GetMapping("/clients/sort/fullname/abc")
    public String getSortClientsFullNameABC() {
        return printClient(sortClients.getSortClients("Fabc"));
    }

    @GetMapping("/clients/sort/fullname/zyx")
    public String getSortClientsFullNameZYX() {
        return printClient(sortClients.getSortClients("Fzyx"));
    }

    @GetMapping("/clients/sort/smallname/abc")
    public String getSortClientsSmallNameABC() {
        return printClient(sortClients.getSortClients("Sabc"));
    }

    @GetMapping("/clients/sort/smallname/zyx")
    public String getSortClientsSmallNameZYX() {
        return printClient(sortClients.getSortClients("Szyx"));
    }

    @GetMapping("/clients/sort/address/abc")
    public String getSortClientsAddressABC() {
        return printClient(sortClients.getSortClients("Aabc"));
    }

    @GetMapping("/clients/sort/address/zyx")
    public String getSortClientsAddressZYX() {
        return printClient(sortClients.getSortClients("Azyx"));
    }

    @GetMapping("/clients/sort/incorporation/abc")
    public String getSortClientsFormOfIncorporationABC() {
        return printClient(sortClients.getSortClientsFormOfIncorporation("abc"));
    }
    @GetMapping("/clients/sort/incorporation/zyx")
    public String getSortClientsFormOfIncorporationZYX() {
        return printClient(sortClients.getSortClientsFormOfIncorporation("zyx"));
    }
}
