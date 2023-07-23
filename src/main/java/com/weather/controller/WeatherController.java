package com.weather.controller;

import java.util.ArrayList;
import java.util.List;

import com.weather.App;
import com.weather.model.Weather;

import io.javalin.Javalin;
import io.javalin.http.Context;

// communicates with the service layer, service layer to the database.
public class WeatherController {
  // normally there's single reference to our service layer , but we're using an
  // array list.

  List<Weather> weatherList;

  public WeatherController() {
    weatherList = new ArrayList<Weather>();
  }

  public Javalin startApi() {
    Javalin app = Javalin.create();
    // TO DO: register endpoints to the Javalin app
    // app.get("hello", this::sayHello); same thing as below:
    app.get("hello", ctx -> ctx.json("Hello!"));
    app.post("weather", this::addWeather);
    app.get("weather", this::getAllWeather);
    return app;
  }

  // app.get("hello", this::sayHello); how to call this method..
  void sayHello(Context ctx) {
    ctx.json("hello!");
  }

  void addWeather(Context ctx) {
    /* defines structure.. w/ method references. turns into weather object */
    Weather weather = ctx.bodyAsClass(Weather.class);

    // this is where we would call the service layer, but we only have an array list
    weatherList.add(weather);

    ctx.status(201); // no return.. its for context
    App.logger.info("Added weather");
  }

  void getAllWeather(Context ctx) {
    ctx.json(weatherList);
    App.logger.info("Weather forecast retrieved ");
  }
}
