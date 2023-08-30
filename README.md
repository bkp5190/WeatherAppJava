## About

Java App that uses the Open Weather API to display weather information based on the zip code provided.

Currently set up with Maven for dependency management.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## How to Run

git clone https://github.com/bkp5190/WeatherAppJava.git

mvn clean install

source set-env.sh
- Fill in API Key for Open Weather API.
- Fill in desired Zip Code to display weather.

java -cp target/my-weather-app-1.0.0.jar:lib/\* github.bkp5190.WeatherApp

## Setup

Currently, the application is set up with GitHub Actions to build and deploy. Given the nature of the application being UI
focused, it will run in a headless mode in the pipeline to account.

## Work To Do

Set up functionality to pass in zip code for custom data.

Convert to using JavaFX instead of Swing