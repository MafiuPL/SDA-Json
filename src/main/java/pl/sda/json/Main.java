package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * Created by RENT on 2017-03-02.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setFirstName("Zbyszek");
        user.setLastName("Babel");

        Address address = new Address();
        address.setStreet("Baraniaka");
        address.setCode("60-401");
        address.setCity("Poznan");

        Address address2 = new Address();
        address2.setStreet("Ognik");
        address2.setCode("60-600");
        address2.setCity("Pila");

        Map<String, Address> addresses = new HashMap<>();
        addresses.put("Home", address);
        addresses.put("Work", address2);

        user.setAddresses(addresses);

        List<String> childrenNames = Arrays.asList("Marek", "Zbychu");

        user.setChildrenNames(childrenNames);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);

        System.out.println(json);
    }
}
