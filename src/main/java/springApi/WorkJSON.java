package springApi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> readJsonFormOfIncorporation(){
        try{
            List<String> allForms = new ArrayList<>();
            JSONArray jsonArray = getJsonArray("classpath:formOfIncorporation.json");
            JSONObject jsonObject =  (JSONObject) jsonArray.get(0);
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
}
