package pl.primigemius.ade.report;

/**
 *
 * @author bartoszk
 */
public class Archive {
    
    private String name;
    private Address address;

    public Archive(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Archive() {
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
}
