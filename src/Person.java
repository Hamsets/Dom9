public class Person {
    private String firstName;
    private String lastName;
    private Address address;
    public Person (String firstName, String lastName, Address address) throws NullFieldException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        checkNull(this.firstName,this.lastName,this.address);
    }

    public void setFirstName(String firstName) throws NullFieldException {
        checkNull(firstName,this.lastName,this.address);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws NullFieldException {
        checkNull(this.firstName,lastName,this.address);
        this.lastName = lastName;
    }

    public void setAddress(Address address) throws NullFieldException {
        checkNull(this.firstName,this.lastName,address);
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString (){
        String address = this.address.getCity() + " " + this.address.getStreet() + " "+ this.address.getHouse();
        return this.lastName + " " + this.firstName + " " + address + " ";
    }

    private void checkNull (String firstName, String lastName, Address address) throws NullFieldException{
        try {
            if (firstName==null||lastName==null||address.getCity()==null||address.getStreet()==null||address.getHouse()==0) {
                throw new NullFieldException("Empty field !!!");
            }
        } catch (NullFieldException ex){
            System.out.println(ex.getMessage());
        }
    }
}


