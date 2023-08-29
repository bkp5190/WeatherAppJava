package github.bkp5190;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherApp {
    public static void main(String[] args) throws Exception {

        System.out.println(System.getProperty("java.awt.headless"));

        String apiKey = System.getenv("OPENWEATHERMAP_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            System.out.println("API key not set. Exiting...");
            return;
        }

        String zipCode = System.getenv("ZIP_CODE");
        if (zipCode == null || zipCode.isEmpty()) {
            System.out.println("Zip code is not set. Exiting...");
            return;
        }

        String apiUrl = System.getenv("OPENWEATHERMAP_URL");
        if (apiUrl == null || apiUrl.isEmpty()) {
            System.out.println("Weather API URL is not set. Exiting...");
        }

        String headlessProp = System.getProperty("java.awt.headless");
        if (headlessProp != null && headlessProp.equals("true")) {
            // Handle headless mode (non-GUI)
            System.out.println("Running in headless mode (non-GUI).");

            // Initialize WeatherModel with API key and zip code
            WeatherModel model = new WeatherModel(apiKey, zipCode, apiUrl);

            // Fetch weather data and process it
            double[] latLonArray = model.setLatAndLonBasedOnZip();
            JSONObject information = model.generateWeatherInformation(latLonArray[0], latLonArray[1]);

            // Extract and display weather information
            String location = information.getString("name");
            JSONObject innerMainObject = information.getJSONObject("main");
            Float temperature = innerMainObject.getFloat("temp");
            JSONArray innerWeatherObject = information.getJSONArray("weather");
            String description = innerWeatherObject.getJSONObject(0).getString("description");

            System.out.println("Location: " + location);
            System.out.println("Temperature: " + temperature + "°C");
            System.out.println("Weather: " + description);
        } else {
            // Initialize the GUI only if not in headless mode
            WeatherModel model = new WeatherModel(apiKey, zipCode, apiUrl);
            WeatherView view = new WeatherView();
            WeatherController controller = new WeatherController(view, model);
        }
    }
}