package com.weather.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import com.weather.dao.WeatherDAO;
import com.weather.model.Weather;

public class WeatherServiceTest {
  private static WeatherService service = null;

  // @BeforeEach
  // public void setupService() {
  // service = new WeatherService();
  // }

  @Test
  public void testAddWeather() {
    // mocking the DAO layer
    WeatherDAO mockDAO = mock(WeatherDAO.class); // refer to class (interface) without creating the object

    // create test object
    Weather testWeather = new Weather("Wednesday", 90.0, new double[] { 90, 91, 92, 91 });

    // creating expected object
    Weather expectedWeather = new Weather(1, "Wednesday", 90.0, new double[] { 90, 91, 92, 91 });

    // stub a method
    when(mockDAO.insertWeather(testWeather)).thenReturn(expectedWeather);

    // call the service layer and create the object
    Weather actualWeather = service.addWeather(testWeather);

    // the actual test:
    assertNotNull(actualWeather);
  }
}
