package main.java.github.bkp5190;

public class WeatherApp {
    public static void main(String[] args) throws Exception {

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

        WeatherModel model = new WeatherModel(apiKey, zipCode, apiUrl);
        WeatherView view = new WeatherView();
        WeatherController controller = new WeatherController(view, model);

    }
}
