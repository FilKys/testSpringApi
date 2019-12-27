package springApi.sorts;

import springApi.Entities.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortClients {

    public List<Client> getSortClients(List<Client> clientList, String type) {
        List<String> sortList1 = new ArrayList<>();
        List<String> sortList2 = new ArrayList<>();
        List<Client> newSortList = new ArrayList<>();
        for (Client client : clientList) {
            switch (type.charAt(0)) {
                case 'F':
                    sortList1.add(client.getFullName());
                    sortList2.add(client.getFullName());
                    break;
                case 'S':
                    sortList1.add(client.getSmallName());
                    sortList2.add(client.getSmallName());
                    break;
                case 'A':
                    sortList1.add(client.getAddress());
                    sortList2.add(client.getAddress());
                    break;
            }
        }
        type = type.substring(1);
        switch (type) {
            case "abc":
                Collections.sort(sortList1);
                break;
            case "zyx":
                Collections.sort(sortList1, Collections.reverseOrder());
                break;
        }
        for (String name : sortList1) {
            newSortList.add(clientList.get(sortList2.indexOf(name)));
        }
        return newSortList;
    }

    public List<Client> getSortClientsFormOfIncorporation(List<Client> clientList,
                                                          List<String> incorporationList,
                                                          String type) {
        List<String> incorporationSortList1 = new ArrayList<>();
        List<String> incorporationSortList2 = new ArrayList<>();
        List<Client> newSortList = new ArrayList<>();
        int idForm = 0;
        for (Client client : clientList) {
            idForm = Math.toIntExact(client.getIdFormOfIncorporation());
            incorporationSortList1.add(incorporationList.get(idForm));
            incorporationSortList2.add(incorporationList.get(idForm));
        }
        switch (type) {
            case "abc":
                Collections.sort(incorporationSortList1);
                break;
            case "zyx":
                incorporationSortList1.sort(Collections.reverseOrder());
                break;
        }
        for (String incorporation : incorporationSortList1) {
            newSortList.add(clientList.get(incorporationSortList2.indexOf(incorporation)));
        }
        return newSortList;
    }
}

