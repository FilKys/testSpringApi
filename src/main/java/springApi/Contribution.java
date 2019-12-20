package springApi;

import java.util.Date;

public class Contribution {
    private int idClient;
    private int idBank;
    private Date openDate;
    private float interestRate;

    public void Contribution(int idClient,
                             int idBank,
                             Date openDate,
                             float interestRate) {
        this.idClient = idClient;
        this.idBank = idBank;
        this.openDate = openDate;
        this.interestRate = interestRate;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdBank() {
        return idBank;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public float getInterestRate() {
        return interestRate;
    }

}
