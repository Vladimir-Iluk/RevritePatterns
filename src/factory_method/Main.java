package factory_method;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

record User(String name, String role) {}


public class Main {
    public static Function<String, User> createUserFactory(String role) {
        return name -> new User(name, role);
    }

    public static void main(String[] args) {
        Function<String, User> moderatorFactory = createUserFactory("Moderator");
        Function<String, User> userFactory = createUserFactory("User");

        List<User> users = new ArrayList<>();

        User mod = moderatorFactory.apply("Alice");
        users.add(mod);
        User mod2 = moderatorFactory.apply("Bob");
        users.add(mod2);
        User user = userFactory.apply("Timmy");
        users.add(user);
        User user2 = userFactory.apply("Jimmy");
        users.add(user2);

        System.out.println("List moderators :");
        for(User u : users) {
            if(u.role().equals("Moderator")) {
                System.out.println(u);
            }
        }
        System.out.println("List user :");
        for(User u : users) {
            if(!u.role().equals("Moderator")) {
                System.out.println(u);
            }
        }
    }
}