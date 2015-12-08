package responses;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

//TODO: test values
public class TestPins {

    //API call: https://api.pinterest.com/v1/boards/francisabila/all-about-me/pins/?access_token=ARp8HNzfw2scBtJqtYA57a8xFeAqFBzML4SnnEZCe9w6DeAJGAAAAAA&fields=id,link,counts,note,id,link,creator%28id,first_name,last_name,url%29,board%28id,name,url%29
    @Test
    public void testBoardResponse() throws IOException {
        final String response = loadFile("responses/BoardResponse.json");
        final Pins pins = new Gson().fromJson(response, Pins.class);

        System.out.println(pins);
    }

    //API call: https://api.pinterest.com/v1/pins/525091637782793357/?access_token=ARp8HNzfw2scBtJqtYA57a8xFeAqFBzML4SnnEZCe9w6DeAJGAAAAAA&fields=id,link,counts,note,id,link,creator%28id,first_name,last_name,url%29,board%28id,name,url%29
    @Test
    public void testPinResponse() throws IOException {
        final String response = loadFile("responses/CompletePinResponse.json");
        final Pin pin = new Gson().fromJson(response, Pin.class);

        System.out.println(pin);
    }

    private static String loadFile(final String resource) throws IOException {
        return IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }
}
