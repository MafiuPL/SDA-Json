package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by RENT on 2017-03-02.
 */
public class JsonMapperTest {

    @Test
    public void test1() throws IOException {
        String jsonToDeserialize = "{\"firstName\":\"Zbyszek\",\"lastName\":\"Babel\",\"addresses\":{\"Work\":{\"street\":\"Ognik\",\"code\":\"60-600\",\"city\":\"Pila\"},\"Home\":{\"street\":\"Baraniaka\",\"code\":\"60-401\",\"city\":\"Poznan\"}},\"childrenNames\":[\"Marek\",\"Zbychu\"]}\n";
        ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(jsonToDeserialize, User.class);

        User user = mapper.readValue(jsonToDeserialize, User.class);
        Assert.assertEquals("Zbyszek", user.getFirstName());
        Assert.assertNotNull(user.getChildrenNames());
        Assert.assertTrue(user.getChildrenNames() != null);
        Assert.assertTrue(user.getChildrenNames().size() == 2);
        Assert.assertEquals(Arrays.asList("Marek", "Zbychu"), user.getChildrenNames());
    }

    @Test
    public void test2() throws IOException {
        User user = new UserBuilder().withFirstName("Zbyszek").withLastName("Babel")
                .withAddress("Work", new AddressBuilder().withCity("Pila").withCode("60-600").withStreet("Ognik").build())
                .withAddress("Home", new AddressBuilder().withCity("Poznan").withCode("60-401").withStreet("Baraniaka").build())
                .withChildrenNames(Arrays.asList("Marek", "Zbychu"))
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String serializedObject = mapper.writeValueAsString(user);
        Assert.assertTrue(serializedObject.contains("\"firstName\":\"Zbyszek\""));
        Assert.assertTrue(serializedObject.contains("Babel"));
        Assert.assertTrue(serializedObject.contains("Marek"));
    }

    @Test
    public void test3() throws IOException {
        User user = new UserBuilder().withFirstName("Zbyszek").withLastName("Babel")
                .withAddress("Work", new AddressBuilder().withCity("Pila").withCode("60-600").withStreet("Ognik").build())
                .withAddress("Home", new AddressBuilder().withCity("Poznan").withCode("60-401").withStreet("Baraniaka").build())
                .withChildrenNames(null)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String serializedObject = mapper.writeValueAsString(user);
        System.out.println(serializedObject);
    }
}
