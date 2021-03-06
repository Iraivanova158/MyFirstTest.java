package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.List;
import java.util.Map;

public class WeatherStepDefs {
    private int cityId;
    private WeatherResponse response;

    @Given("city id: {int}")
    public void set_city_id(int cityId){
        this.cityId = cityId;

    }
    @When("we request weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.getWeather(cityId);

    }
    @Then("lon is {double}")
    public void check_lon(double lon){
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong Lon");

    }
    @Then("lat is {double}")
    public void check_lat(double lat){
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong Lat");

    }
    @Then("weather attributes are:")
    public void check_weather_attributes (Map<String, String> attributes){

        Assertions.assertEquals(Integer.valueOf(attributes.get("id")), response.getWeathers().get(0).getId());
        Assertions.assertEquals(attributes.get("main"), response.getWeathers().get(0).getMain());
        Assertions.assertEquals(attributes.get("description"), response.getWeathers().get(0).getDescription());
        Assertions.assertEquals(attributes.get("icon"), response.getWeathers().get(0).getIcon());
    }

    @Then("base is {string}")
    public void check_base (String base){
        Assertions.assertEquals(base, response.getBase());
    }
    @Then("main parameters are:")
    public void check_main_parameters (Map<String, String> parameters){
        Assertions.assertEquals(Double.valueOf(parameters.get("temp")), response.getMain().getTemp());
        Assertions.assertEquals(Integer.valueOf(parameters.get("pressure")), response.getMain().getPressure());
        Assertions.assertEquals(Integer.valueOf(parameters.get("humidity")), response.getMain().getHumidity());
        Assertions.assertEquals(Double.valueOf(parameters.get("temp_min")), response.getMain().getMinTemp());
        Assertions.assertEquals(Double.valueOf(parameters.get("temp_max")), response.getMain().getMaxTemp());

    }
    @Then("visibility is {double}")
    public void check_visibility (double visibility){
        Assertions.assertEquals(visibility, response.getVisibility());
    }
    @Then("wind parameters are:")
    public void check_wind (Map<String, String> wind){
        Assertions.assertEquals(Double.valueOf(wind.get("speed")), response.getWind().getSpeed());
        Assertions.assertEquals(Integer.valueOf(wind.get("deg")), response.getWind().getDeg());
    }
    @Then("clouds parameters are:")
    public void check_clouds (Map<String, String> clouds){
        Assertions.assertEquals(Integer.valueOf(clouds.get("all")), response.getClouds().getAll());
    }
    @Then("dt is {double}")
    public void check_dt (double dt){
        Assertions.assertEquals(dt, response.getDt());
    }
    @Then("sys parameters are:")
    public void check_sys (Map<String, String> sys){
        Assertions.assertEquals(Integer.valueOf(sys.get("type")), response.getSys().getType());
        Assertions.assertEquals(Integer.valueOf(sys.get("id")), response.getSys().getId());
        Assertions.assertEquals(Double.valueOf(sys.get("message")), response.getSys().getMessage());
        Assertions.assertEquals(sys.get("country"), response.getSys().getCountry());
        Assertions.assertEquals(Integer.valueOf(sys.get("sunrise")), response.getSys().getSunrise());
        Assertions.assertEquals(Integer.valueOf(sys.get("sunset")), response.getSys().getSunset());
    }
    @Then("id is {double}")
    public void check_id (double id){
        Assertions.assertEquals(id, response.getId());
    }
    @Then("name is {string}")
    public void check_name (String name){
        Assertions.assertEquals(name, response.getName());
    }
    @Then("cod is {double}")
    public void check_cod (double cod){
        Assertions.assertEquals(cod, response.getCod());
    }
}
