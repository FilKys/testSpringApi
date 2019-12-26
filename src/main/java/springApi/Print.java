package springApi;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

public class Print {
    public static String printFormOfIncorporation(List<String> allFormOfIncorporations) {
        String res = "Организационно-правовая форма  :";
        for (int i = 0; i < allFormOfIncorporations.size(); i++) {
            res += "<br>";
//            res += "id: " + i + "<br>";
            res += "mame: " + allFormOfIncorporations.get(i) + "<br>";
            res += "-------------";
        }
        return res;
    }

    public static String printClient(List<Client> allClients) {
        String res = "Банки :";
        List<String> formOfIncorporationList = new WorkJSON().readJsonFormOfIncorporation();
        for (Client client : allClients) {
            res += "<br>";
//            res += "id: " + client.getIdClient().toString() + "<br>";
            res += "fullName: " + client.getFullName() + "<br>";
            res += "smallName: " + client.getSmallName() + "<br>";
            res += "address: " + client.getAddress() + "<br>";
//            res += "idFormOfIncorporation: " + client.getIdFormOfIncorporation().toString() + "<br>";
            res += "nameFormOfIncorporation: " + formOfIncorporationList.get(Math.toIntExact(client.getIdFormOfIncorporation())) + "<br>";
            res += "-------------";
        }
        return res;
    }

    public static String printBank(List<Bank> allBanks) {
        String res = "Банки :";
        for (Bank bank : allBanks) {
            res += "<br>";
//            res += "idBank: " + bank.getIdBank().toString() + "<br>";
            res += "name: " + bank.getNameBank() + "<br>";
            res += "bik: " + bank.getBikBank() + "<br>";
            res += "-------------";
        }
        return res;
    }

    public static String printContributions(List<Contribution> contributionsList) {
        String res = "Вклады :";
        List<Client> allClients = new WorkJSON().readJsonClient();
        List<Bank> allBanks = new WorkJSON().readJsonBank();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (Contribution contribution : contributionsList) {
            res += "<br>";
//            res += "id: " + contribution.getIdContribution() + "<br>";
//            res += "idClient: " + contribution.getIdClient() + "<br>";
            res += "clientName: " + allClients.get(Math.toIntExact(contribution.getIdClient())).getFullName() + "<br>";
//            res += "idBank: " + contribution.getIdBank() + "<br>";
            res += "nameBank: " + allBanks.get(Math.toIntExact(contribution.getIdBank())).getNameBank() + "<br>";
            res += "openDate: " + df.format(contribution.getOpenDate()) + "<br>";
            res += "interestRate: " + contribution.getInterestRate() + "%<br>";
            res += "term: " + contribution.getTerm() + " мес.<br>";
            res += "-------------";
        }
        return res;
    }
}
