package springApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springApi.WorkData;
import springApi.sorts.SortBank;
import springApi.sorts.SortClients;
import springApi.sorts.SortContribution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import static springApi.Print.*;

@RestController
public class Controller {
    private final String sharedKey = "SHARED_KEY";
    private WorkData workData = new WorkData();
    private SortBank sortBank = new SortBank();
    private SortClients sortClients = new SortClients();
    private SortContribution sortContribution = new SortContribution();
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    //C - client, F - Full name, S - Small name, A - Address, I - Form Of Incorporation
    // N - Name, B - Bik

    @GetMapping("/banks")
    public String getBanks() {
        return printBank(workData.getBankList());
    }

    //type = MaxMin, MinMax
    @GetMapping("/banks/sortb={type}")
    public String getSortBankBik(@PathVariable("type") String type) {
        return printBank(sortBank.getSortBankBik(workData.getBankList(), "MinMax"));
    }

    // type = abc, zyx
    @GetMapping("/banks/sortn={type}")
    public String getSortBankName(@PathVariable("type") String type) {
        return printBank(sortBank.getSortBankName(workData.getBankList(), type));
    }

    @GetMapping("/contributions")
    public String getContributions() {
        return printContributions(workData.getContributionList());
    }

    @GetMapping("/clients")
    public String getClients() {
        return printClient(workData.getClientList());
    }

    //type = Aabc, Azyx, Sabc, Szyx, Fabc, Fzyx
    @GetMapping("/clients/sortaddress={type}")
    public String getSortClientsAddress(@PathVariable("type") String type) {
        return printClient(sortClients.getSortClients(workData.getClientList(), type));
    }

    //type = abc, zyx
    @GetMapping("/clients/sortinc={type}")
    public String getSortClientsFormOfIncorporation(@PathVariable("type") String type) {
        return printClient(sortClients.getSortClientsFormOfIncorporation(workData.getClientList(),
                workData.getFormOfIncorporation(),
                type));

    }

    //type = CFabc, CFzyx, CSabc, CSzyx, CAabc, CAzyx, Iabc, Izyx
    @GetMapping("/contributions/sortcfn={type}")
    public String getContributionsSortClientsFullName(@PathVariable("type") String type) {
        return printContributions(sortContribution.getSortClients(workData.getContributionList(),
                workData.getClientList(),
                workData.getFormOfIncorporation(),
                type));
    }

    //type = Nabc, Nzyx, BMinMax, BMaxMin
    @GetMapping("/contributions/sortb={type}")
    public String getContributionsSortBanksName(@PathVariable("type") String type) {
        return printContributions(sortContribution.getSortBank(workData.getContributionList(),
                workData.getBankList(),
                type));
    }

    //type = MinMax, MaxMin
    @GetMapping("/contributions/sortod={type}")
    public String getContributionsSortOpenDate(@PathVariable("type") String type) {
        return printContributions(sortContribution.getSortDate(workData.getContributionList(), type));
    }

    @GetMapping(value = "/contributions/sortodr={date1}&{date2}")
    public String getContributionsSortOpenDateRange(@PathVariable("date1") String date1,
                                                    @PathVariable("date2") String date2) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return printContributions(sortContribution.getSortDateRange(workData.getContributionList(),
                df.parse(date1),
                df.parse(date2)));
    }

    //type = MinMax, MaxMin
    @GetMapping(value = "/contributions/sortr={type}")
    public String getContributionsSortInterestRate(@PathVariable("type") String type) throws ParseException {
        return printContributions(sortContribution.getSortRate(workData.getContributionList(), type));
    }

    //type = MinMax, MaxMin
    @GetMapping(value = "/contributions/sortt={type}")
    public String getContributionsSortTerm(@PathVariable("type") String type) throws ParseException {
        return printContributions(sortContribution.getSortTerm(workData.getContributionList(), type));
    }
}
