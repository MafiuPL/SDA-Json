package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by RENT on 2017-03-02.
 */
public class JacksonTest {
    @Test

    public void test1() {

        String jsonToDeserialize = "{\"firstName\":\"Bartosz\"," +

                "\"lastName\":\"Nowak\"," +

                "\"addresses\":{\"Home\":{\"street\":\"Al. Niepodległości\",\"city\":\"Poznań\"}}}";
//        TODO dopisac assert

    }


    @Test

    public void test2() throws IOException {

        String jsonToDeserialize = "{\"originalTitle\":\"Saving Private Ryan\",\"plTitle\":\"Szeregowiec Ryan\",\"director\":{\"firstName\":\"Steven\",\"lastName\":\"Spielberg\"}}";
        ObjectMapper mapper = new ObjectMapper();
        Movie movie = mapper.readValue(jsonToDeserialize, Movie.class);
        System.out.println(jsonToDeserialize);
//        TODO dopisac assert

    }


    @Test

    public void test3() throws IOException {

        String jsonToDeserialize = "{\"originalTitle\":\"Empire Strikes Back\",\"plTitle\":\"Imperium kontratakuje\",\"director\":{\"firstName\":\"Irvin\",\"lastName\":\"Kershner\"}, \"boxOffice\":538375067}";
        ObjectMapper mapper = new ObjectMapper();
        Movie movie = mapper.readValue(jsonToDeserialize, Movie.class);
        System.out.println(jsonToDeserialize);
        //TODO dopisac assert

    }

}

