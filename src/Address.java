import java.io.Serializable;

public class Address implements Serializable {
    private String city;
    private String street;
    private int house;
    public Address(String city, String street, int house){
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }
}
