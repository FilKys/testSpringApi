package springApi;

public class Bank {
    private String name;
    private String bik;

    public void Bank(String name, String bik) {
        this.name = name;
        this.bik = bik;
    }

    public String getNameBank(){
        return name;
    }

    public String getBikBank(){
        return bik;
    }
}
