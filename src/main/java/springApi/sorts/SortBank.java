package springApi.sorts;

import springApi.Bank;
import springApi.WorkData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortBank {
    private WorkData workData = new WorkData();

    public List<Bank> getSortBankBik(String type) {
        List<Bank> bankList = workData.getBankList();
        List<Integer> bikList1 = new ArrayList<>();
        List<Integer> bikList2 = new ArrayList<>();
        List<Bank> newBankList = new ArrayList<>();
        for (Bank bank : bankList) {
            bikList1.add(Integer.valueOf(bank.getBikBank()));
            bikList2.add(Integer.valueOf(bank.getBikBank()));
        }
        switch (type) {
            case "MinMax":
                Collections.sort(bikList1);
                break;
            case "MaxMin":
                Collections.sort(bikList1, Collections.reverseOrder());
                break;
        }
        for (Integer bik : bikList1) {
            newBankList.add(bankList.get(bikList2.indexOf(bik)));
        }
        return newBankList;
    }

    public List<Bank> getSortBankName(String type) {
        List<Bank> bankList = workData.getBankList();
        List<String> nameList1 = new ArrayList<>();
        List<String> nameList2 = new ArrayList<>();
        List<Bank> newBankList = new ArrayList<>();
        for (Bank bank : bankList) {
            nameList1.add(bank.getNameBank());
            nameList2.add(bank.getNameBank());
        }
        switch (type) {
            case "abc":
                Collections.sort(nameList1);
                break;
            case "zyx":
                Collections.sort(nameList1, Collections.reverseOrder());
                break;
        }
        for (String name : nameList1) {
            newBankList.add(bankList.get(nameList2.indexOf(name)));
        }
        return newBankList;
    }
}
