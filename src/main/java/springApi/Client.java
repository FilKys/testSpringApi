package springApi;

public class Client {
    private Long idClient;
    private String fullName;
    private String smallName;
    private String address;
    private Long idFormOfIncorporation; //[0-6]

    public Client(Long idClient,
                  String fullName,
                  String smallName,
                  String address,
                  Long idFormOfIncorporation) {
        this.idClient = idClient;
        this.fullName = fullName;
        this.smallName = smallName;
        this.address = address;
        this.idFormOfIncorporation = idFormOfIncorporation;
    }

    public Long getIdClient() {
        return idClient;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSmallName() {
        return smallName;
    }

    public String getAddress() {
        return address;
    }

    public Long getIdFormOfIncorporation() {
        return idFormOfIncorporation;
    }

}
