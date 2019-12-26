package springApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springApi.WorkData;
import springApi.sorts.SortBank;

import java.util.List;

import static springApi.Print.*;

@RestController
public class ControllerBanks {
    private final String sharedKey = "SHARED_KEY";
    private WorkData workData = new WorkData();
    private SortBank sortBank = new SortBank();
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping("/banks")
    public String getBanks() {
        return printBank(workData.getBankList());
    }

    @GetMapping("/banks/sort/bik/maxmin")
    public String getSortBankBikMaxMin() {
        return printBank(sortBank.getSortBankBik("MaxMin"));
    }

    @GetMapping("/banks/sort/bik/minmax")
    public String getSortBankBikMinMax() {
        return printBank(sortBank.getSortBankBik("MinMax"));
    }

    @GetMapping("/banks/sort/name/abc")
    public String getSortBankNameABC() {
        return printBank(sortBank.getSortBankName("abc"));
    }

    @GetMapping("/banks/sort/name/zyx")
    public String getSortBankNameZYX() {
        return printBank(sortBank.getSortBankName("zyx"));
    }
}
