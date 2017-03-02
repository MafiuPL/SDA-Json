package pl.sda.json;

/**
 * Created by RENT on 2017-03-02.
 */
public class AddressBuilder {
    private Address address;

    public AddressBuilder() {
        this.address = new Address();
    }

    public AddressBuilder withStreet(String street) {
        address.setStreet(street);
        return this;
    }

    public AddressBuilder withCode(String code) {
        address.setCode(code);
        return this;
    }

    public AddressBuilder withCity(String city) {
        address.setCity(city);
        return this;
    }

    public Address build() {
        return address;
    }
}
