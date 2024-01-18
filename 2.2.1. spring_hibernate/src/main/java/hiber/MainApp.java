package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("car1", 1)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",new Car("car2", 2)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("car3", 3)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",new Car("car3", 4)));
      userService.add(new User("User11", "Lastname11", "user11@mail.ru",new Car("car11", 11)));
      userService.add(new User("User21", "Lastname21", "user21@mail.ru",new Car("car21", 21)));
      userService.add(new User("User31", "Lastname31", "user31@mail.ru",new Car("car31", 31)));
      userService.add(new User("User41", "Lastname41", "user41@mail.ru",new Car("car41", 41)));

      List<User> users = userService.listUsers();


      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar() );
         System.out.println();
      }

      System.out.println("__________________");
      User user = userService.getUserByCarInfo("car41", 41);
//      System.out.println(userService.getUserByCarInfo("car41", 41));

      context.close();
   }
}
