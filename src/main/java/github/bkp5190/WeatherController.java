package main.java.github.bkp5190;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherController {
    private WeatherView view;
    private WeatherModel model;

    public WeatherController(WeatherView view, WeatherModel model) {
        this.view = view;
        this.model = model;

        // Add button click listener
        view.addButtonClickListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                double[] latLonArray = model.setLatAndLonBasedOnZip();
                
                JSONObject information = model.generateWeatherInformation(latLonArray[0], latLonArray[1]);
                System.out.println(information);
                
                String location = information.getString("name");
                
                JSONObject innerMainObject = information.getJSONObject("main");
                Float temperature = innerMainObject.getFloat("temp");

                JSONArray innerWeatherObject = information.getJSONArray("weather");

                String description = "";

                for (int i = 0; i < innerWeatherObject.length(); i++) {
                    JSONObject elementObject = innerWeatherObject.getJSONObject(i);
                    description = elementObject.getString("description");
                }
                
                System.out.println(description);
                view.displayInformation(location, description, temperature);
            }
        });
    }
}
