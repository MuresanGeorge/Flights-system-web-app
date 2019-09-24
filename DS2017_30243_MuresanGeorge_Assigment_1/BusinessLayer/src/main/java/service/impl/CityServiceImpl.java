package service.impl;

import dao.CityDaoImpl;
import model.City;
import service.CityService;

public class CityServiceImpl implements CityService {

    CityDaoImpl cityDao = new CityDaoImpl();

    public City getCityByName(String cityName) {
        return cityDao.getCityByName(cityName);
    }
}
