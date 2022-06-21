package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarDao {
    void add(Car car);

    Car getCar(long id);

    List<Car> listCars();

    User getUserForCar(Car car);

}
