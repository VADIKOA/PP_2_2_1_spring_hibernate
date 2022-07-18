package hiber.dao;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {
    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public Car getCar(long id) {
        Car car = sessionFactory.getCurrentSession().get(Car.class, id);
        return car;
    }

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override
    public User getUserForCar(Car car) {
        String modelCar = car.getModel();
        Integer series = car.getSeries();
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("SELECT user FROM Car " +
                "WHERE model = :mod AND series = :ser")
                .setParameter("mod", modelCar).setParameter("ser", series);

        return query.getSingleResult();
    }
}
