package springApi;

import springApi.Entities.Bank;
import springApi.Entities.Client;
import springApi.Entities.Contribution;

import java.util.List;

public class WorkData {
    private List<Bank> bankList;
    private List<Client> clientList;
    private List<Contribution> contributionList;
    private List<String> formOfIncorporation;
    WorkJSON workJSON = new WorkJSON();

    public WorkData() {
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

    public void addBank(String name, String bik) {
        Long maxId = -1L;
        boolean work = true;
        for (Bank bank : bankList) {
            if (bank.getIdBank() < maxId) {
                maxId = bank.getIdBank();
            }
            if (name.equals(bank.getNameBank()) || bik.equals(bank.getBikBank())) {
                work = false;
                break;
            }
        }
        if (work) {
            Bank newBank = new Bank(maxId, name, bik);
            workJSON.saveBankToJson(newBank);
            bankList = workJSON.readJsonBank();
        }
    }

    public void setBank(Long idBank, String name, String bik) {
        Bank bank = new Bank(idBank, name, bik);
        boolean work = true;
        for (Bank bank1 : bankList) {
            if (bank1.getIdBank() != idBank && bank1.getNameBank() == name ||
                    bank1.getIdBank() != idBank && bank1.getBikBank() == bik) {
                work = false;
                break;
            }
        }
        if(work) {
            for (Bank b : bankList) {
                if (b.getIdBank() == idBank) {
                    b.setName(name);
                    b.setBik(bik);
                    break;
                }
            }
        }
    }

    public void delBank(Long idBank){

    }
}
