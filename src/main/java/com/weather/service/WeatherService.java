package com.weather.service;

import java.util.List;

import com.weather.dao.WeatherDAO;
import com.weather.model.Weather;

public class WeatherService {
  public static WeatherDAO dao = null;

  public WeatherService() {
    // instantiate an implementation of WeatherDAO here after mockito finished
  }

  public Weather addWeather(Weather newWeather) {
    return dao.insertWeather(newWeather);
  }

  public List<Weather> getAllWeather() {
    return dao.getAllWeather();
  }

  // TO DO: add another method with complex logic to make mocking it valuable, add
  // tests.
}
