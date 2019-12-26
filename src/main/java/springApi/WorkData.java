package springApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WorkData {
    private List<Bank> bankList;
    private List<Client> clientList;
    private List<Contribution> contributionList;
    private List<String> formOfIncorporation;

    public WorkData() {
        WorkJSON workJSON = new WorkJSON();
        bankList = workJSON.readJsonBank();
        clientList = workJSON.readJsonClient();
        contributionList = workJSON.readJsonContributions();
        formOfIncorporation = workJSON.readJsonFormOfIncorporation();
    }

    public List<Bank> getBankList() {
        return bankList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public List<Contribution> getContributionList() {
        return contributionList;
    }

    public List<String> getFormOfIncorporation() {
        return formOfIncorporation;
    }


}
