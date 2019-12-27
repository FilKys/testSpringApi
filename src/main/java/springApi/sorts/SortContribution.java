package springApi.sorts;

import org.json.simple.JSONArray;
import springApi.Entities.Bank;
import springApi.Entities.Client;
import springApi.Entities.Contribution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SortContribution {

    public List<Contribution> getSortClients(List<Contribution> contributionList,
                                             List<Client> clientList,
                                             List<String> incorporationList,
                                             String type) {

        SortClients sortClients = new SortClients();
        List<Client> clientForSortList = new ArrayList<>();
        List<Client> clientOriginalList = new ArrayList<>();
        Client client;
        for (Contribution contribution : contributionList) {
            client = clientList.get(Math.toIntExact((contribution.getIdClient())));
            clientForSortList.add(client);
            clientOriginalList.add(client);
        }
        switch (type.charAt(0)) {
            case 'C':
                type = type.substring(1);
                clientForSortList = sortClients.getSortClients(clientForSortList, type);
                break;
            case 'I':
                type = type.substring(1);
                clientForSortList = sortClients.getSortClientsFormOfIncorporation(clientForSortList,
                        incorporationList,
                        type);
                break;
        }
        List<Contribution> newSortContributionList = new ArrayList<>();
        for (Client client1 : clientForSortList) {
            newSortContributionList.add(contributionList.get(clientOriginalList.indexOf(client1)));
        }
        return newSortContributionList;
    }

    public List<Contribution> getSortBank(List<Contribution> contributionList,
                                          List<Bank> bankList,
                                          String type) {
        SortBank sortBank = new SortBank();
        List<Bank> bankListForSortList = new ArrayList<>();
        List<Bank> bankListOriginalList = new ArrayList<>();
        Bank bank;
        for (Contribution contribution : contributionList) {
            bank = bankList.get(Math.toIntExact(contribution.getIdBank()));
            bankListForSortList.add(bank);
            bankListOriginalList.add(bank);
        }
        switch (type.charAt(0)) {
            case 'B':
                type = type.substring(1);
                bankListForSortList = sortBank.getSortBankBik(bankListForSortList, type);
                break;
            case 'N':
                type = type.substring(1);
                bankListForSortList = sortBank.getSortBankName(bankListForSortList, type);
                break;
        }
        List<Contribution> newSortContributionList = new ArrayList<>();
        for (Bank bank1 : bankListForSortList) {
            newSortContributionList.add(contributionList.get(bankListOriginalList.indexOf(bank1)));
        }
        return newSortContributionList;
    }

    public List<Contribution> getSortDate(List<Contribution> contributionList, String type) {
        List<Date> openDateForSortList = new ArrayList<>();
        List<Date> openDateOriginalList = new ArrayList<>();
        Date openDate;
        for (Contribution contribution : contributionList) {
            openDate = contribution.getOpenDate();
            openDateForSortList.add(openDate);
            openDateOriginalList.add(openDate);
        }
        switch (type) {
            case "MinMax":
                Collections.sort(openDateForSortList);
                break;
            case "MaxMin":
                Collections.sort(openDateForSortList, Collections.reverseOrder());
                break;
        }
        List<Contribution> newSortContributionList = new ArrayList<>();
        for (Date bank1 : openDateForSortList) {
            newSortContributionList.add(contributionList.get(openDateOriginalList.indexOf(bank1)));
        }
        return newSortContributionList;
    }

    public List<Contribution> getSortDateRange(List<Contribution> contributionList,
                                               Date date1,
                                               Date date2) throws ParseException {
        if (date1 == null) {
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            date1 = df.parse("01.01.1900");
        }
        if (date2 == null) {
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            date2 = df.parse(new Date().toString());
        }
        if (date1.after(date2))
            return null;
        List<Contribution> newList = new ArrayList<>();
        for (Contribution contribution : contributionList) {
            if (contribution.getOpenDate().after(date1) && contribution.getOpenDate().before(date2) ||
                    contribution.getOpenDate().equals(date1) || contribution.getOpenDate().equals(date2))
                newList.add(contribution);
        }
        return newList;
    }

    public List<Contribution> getSortRate(List<Contribution> contributionList, String type) {
        List<Float> objectForSortList = new ArrayList<>();
        List<Float> objectOriginalList = new ArrayList<>();
        Float data;
        for (Contribution contribution : contributionList) {
            data = contribution.getInterestRate();
            objectForSortList.add(data);
            objectOriginalList.add(data);
        }
        type = type.substring(1);
        switch (type) {
            case "MinMax":
                Collections.sort(objectForSortList);
                break;
            case "MaxMin":
                Collections.sort(objectForSortList, Collections.reverseOrder());
                break;
        }
        List<Contribution> newSortContributionList = new ArrayList<>();
        for (Float interestRate : objectForSortList) {
            newSortContributionList.add(contributionList.get(objectOriginalList.indexOf(interestRate)));
        }
        return newSortContributionList;
    }

    public List<Contribution> getSortTerm(List<Contribution> contributionList, String type) {
        List<Long> objectForSortList = new ArrayList<>();
        List<Long> objectOriginalList = new ArrayList<>();
        Long data;
        for (Contribution contribution : contributionList) {
            data = contribution.getTerm();
            objectForSortList.add(data);
            objectOriginalList.add(data);
        }
        type = type.substring(1);
        switch (type) {
            case "MinMax":
                Collections.sort(objectForSortList);
                break;
            case "MaxMin":
                Collections.sort(objectForSortList, Collections.reverseOrder());
                break;
        }
        List<Contribution> newSortContributionList = new ArrayList<>();
        for (Long interestRate : objectForSortList) {
            newSortContributionList.add(contributionList.get(objectOriginalList.indexOf(interestRate)));
        }
        return newSortContributionList;
    }

}
