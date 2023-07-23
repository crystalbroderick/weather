package com.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weather.controller.WeatherController;

import io.javalin.Javalin;

/**
 * Hello world!
 */
public final class App {

    public static Logger logger = LoggerFactory.getLogger("THE LOGGER");

    public static void main(String[] args) {
        // Javalin app = Javalin.create();
        WeatherController controller = new WeatherController();
        Javalin app = controller.startApi();
        app.start();

        // making a log
        logger.info("The application has started!");
    }
}
