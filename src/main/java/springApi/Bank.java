package springApi;

public class Bank {
    private Long id;
    private String name;
    private String bik;

    public Bank(Long id, String name, String bik) {
        this.id = id;
        this.name = name;
        this.bik = bik;
    }

    public Long getId() {
        return id;
    }

    public String getNameBank(){
        return name;
    }

    public String getBikBank(){
        return bik;
    }
}
