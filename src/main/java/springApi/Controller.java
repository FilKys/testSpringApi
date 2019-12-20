package springApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    private String printFormOfIncorporation(List<String> allFormOfIncorporations) {
        String res = "Организационно-правовая форма  :";
        for (int i = 0; i < allFormOfIncorporations.size(); i++) {
            res += "<br>";
            res += "id: " +i + "<br>";
            res += "mame: " + allFormOfIncorporations.get(i) + "<br>";
            res += "-------------";
        }
        return res;
    }

    private String printClient(List<Client> allClients) {
        String res = "Банки :";
        for (Client client : allClients) {
            res += "<br>";
            res += "id: " + client.getIdClient().toString() + "<br>";
            res += "fullName: " + client.getFullName() + "<br>";
            res += "smallName: " + client.getSmallName() + "<br>";
            res += "address: " + client.getAddress() + "<br>";
            res += "idFormOfIncorporation: " + client.getIdFormOfIncorporation().toString() + "<br>";
            res += "-------------";
        }
        return res;
    }

    private String printBank(List<Bank> allBanks) {
        String res = "Банки :";
        for (Bank bank : allBanks) {
            res += "<br>";
            res += "id: " + bank.getId().toString() + "<br>";
            res += "name: " + bank.getNameBank() + "<br>";
            res += "bik: " + bank.getBikBank() + "<br>";
            res += "-------------";
        }
        return res;
    }

}
