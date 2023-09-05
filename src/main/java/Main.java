import socialnetwork.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User newUser = new User("Noa");
        User anotherUser = new User("Pepito");
        newUser.followUser(anotherUser);
        List users = newUser.getUsersFollowing();
        System.out.println(users.contains("Pepito"));
    }
}
