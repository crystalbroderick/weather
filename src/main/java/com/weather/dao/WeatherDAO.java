package com.weather.dao;

import java.util.List;

import com.weather.model.Weather;

public interface WeatherDAO {
  Weather insertWeather(Weather newWeather);

  List<Weather> getAllWeather();

  Weather getById(int id);

  void updateWeather(int id, Weather newDetails);

  boolean deleteWeather(int id);
}
