package dao;

import model.City;

public interface CityDao {

    City getCityByName(String cityName);
}
