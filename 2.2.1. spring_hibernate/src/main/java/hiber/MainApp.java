package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

//      carService.add(new Car("BMW", 5));
//      carService.add(new Car("VAZ", 2109));
//      carService.add(new Car("GAZ", 21));
//      carService.add(new Car("MAZ", 6124));

      Car car1 = carService.getCarId(10l);
      Car car2 = carService.getCarId(11l);
      Car car3 = carService.getCarId(12l);
      Car car4 = carService.getCarId(13l);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Avto = "+user.getCar().toString());
         System.out.println();
      }

      System.out.println("Имя владельца автомобиля "+ car1.toString() +" - " +
              carService.getUserForCar(car1).getFirstName());

      context.close();
   }
}
