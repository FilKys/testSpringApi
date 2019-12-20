public class Client {
    private String fullName;
    private String smallName;
    private String address;
    private int idFormOfIncorporation;

    public void Client(String fullName,
                       String smallName,
                       String address,
                       int idFormOfIncorporation) {
        this.fullName = fullName;
        this.smallName = smallName;
        this.address = address;
        this.idFormOfIncorporation = idFormOfIncorporation;
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

    public int getIdFormOfIncorporation() {
        return idFormOfIncorporation;
    }

}
