
package weather;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author dunkel
 */
@Path("weather")
@RequestScoped
public class WeatherResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> getWeather(@QueryParam("location") String location) {
        System.out.println("REST GET arrived");
        List<Weather> verlauf = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            double grad = Math.round(Math.random() * 30);
            Weather w = new Weather(location, grad);
            verlauf.add(w);
            System.out.println("ANSWER: " + w);
        }
        return verlauf;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Converter convert(Converter converter) {
        System.out.println("REST-Input: " + converter);
        double celsius = converter.getCelsius();
        double fahrenheit = (celsius * 9 / 5) + 32;
        converter.setFahrenheit(fahrenheit);
        System.out.println("REST-PUT - RETURN::: " + converter);
        return converter;
    }
}
