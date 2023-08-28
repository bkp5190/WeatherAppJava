## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

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
- Fill in API Key and Zip Code for Weather.

java -cp target/my-weather-app-1.0.0.jar:lib/\* main.java.github.bkp5190.WeatherApp