package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarService {
    void add(Car car);
    Car getCarId(long id);
    List<Car> listCars();

    User getUserForCar(Car car);
}
