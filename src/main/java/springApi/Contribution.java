package springApi;

import java.util.Date;

public class Contribution {
    private Long idContribution;
    private Long idClient;
    private Long idBank;
    private Date openDate;
    private float interestRate;
    private Long term;

    public Contribution(Long idContribution,
                        Long idClient,
                        Long idBank,
                        Date openDate,
                        float interestRate,
                        Long term) {
        this.idContribution =idContribution;
        this.idClient = idClient;
        this.idBank = idBank;
        this.openDate = openDate;
        this.interestRate = interestRate;
        this.term = term;
    }

    public Long getIdContribution() {
        return idContribution;
    }

    public Long getIdClient() {
        return idClient;
    }

    public Long getIdBank() {
        return idBank;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public Long getTerm() {
        return term;
    }
}
