package springApi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.util.ResourceUtils;
import springApi.Entities.Bank;
import springApi.Entities.Client;
import springApi.Entities.Contribution;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class WorkJSON {

    private JSONArray getJsonArray(String path) throws IOException, ParseException {
        File file = ResourceUtils.getFile(path);
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(new FileReader(file));
    }

    public List<Bank> readJsonBank() {
        try {
            List<Bank> allBanks = new ArrayList<>();
            JSONArray jsonArray = getJsonArray("classpath:banks.json");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Bank bank = new Bank((Long) jsonObject.get("id"),
                        (String) jsonObject.get("name"),
                        (String) jsonObject.get("bik"));
                allBanks.add(bank);
            }
            return allBanks;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Client> readJsonClient() {
        try {
            List<Client> allClients = new ArrayList<>();
            JSONArray jsonArray = getJsonArray("classpath:clients.json");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Client client = new Client((Long) jsonObject.get("id"),
                        (String) jsonObject.get("fullName"),
                        (String) jsonObject.get("smallName"),
                        (String) jsonObject.get("address"),
                        (Long) jsonObject.get("idFormOfIncorporation"));
                allClients.add(client);
            }
            return allClients;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> readJsonFormOfIncorporation() {
        try {
            List<String> allForms = new ArrayList<>();
            JSONArray jsonArray = getJsonArray("classpath:formOfIncorporation.json");
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            jsonArray = (JSONArray) jsonObject.get("name");
            for (int i = 0; i < jsonArray.size(); i++) {
                allForms.add((String) jsonArray.get(i));
            }
            return allForms;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Contribution> readJsonContributions() {
        try {
            List<Contribution> allContributions = new ArrayList<>();
            JSONArray jsonArray = getJsonArray("classpath:contributions.json");
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Contribution contribution = new Contribution((Long) jsonObject.get("id"),
                        (Long) jsonObject.get("idClient"),
                        (Long) jsonObject.get("idBank"),
                        df.parse(jsonObject.get("openDate").toString()),
                        Float.parseFloat(jsonObject.get("interestRate").toString()),
                        (Long) jsonObject.get("term"));
                if (contribution.getInterestRate() <= 100 &&
                        contribution.getOpenDate().before(new Date()))
                    allContributions.add(contribution);
            }
            return allContributions;
        } catch (IOException | ParseException | java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveBankToJson(Bank bank) {
        JSONObject bankObject = new JSONObject();
        bankObject.put("id", bank.getIdBank());
        bankObject.put("name", bank.getIdBank());
        bankObject.put("bik", bank.getIdBank());
        try (FileWriter file = new FileWriter("classpath:banks.json")) {
            file.write(bankObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
