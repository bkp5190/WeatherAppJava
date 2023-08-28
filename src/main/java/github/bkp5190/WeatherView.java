package main.java.github.bkp5190;

import javax.swing.*;
import java.awt.event.ActionListener;

public class WeatherView {
    private JFrame frame;
    private JButton button;

    public WeatherView() {
        frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        button = new JButton("Generate Weather");
        frame.getContentPane().add(button);

        frame.setVisible(true);
    }

    public void addButtonClickListener(ActionListener listener) {
        button.addActionListener(listener);
    }
    public void displayInformation(String location, String description, Float temp) {
        String message = "Location: " + location + "\nTemperature: " + temp + "°C\nWeather: " + description;
        JOptionPane.showMessageDialog(null, message, "Weather Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
