package springApi.Entities;

public class Bank {
    private Long idBank;
    private String name;
    private String bik;

    public Bank(Long id, String name, String bik) {
        this.idBank = id;
        this.name = name;
        this.bik = bik;
    }

    public Long getIdBank() {
        return idBank;
    }

    public String getNameBank(){
        return name;
    }

    public String getBikBank(){
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public void setName(String name) {
        this.name = name;
    }
}
