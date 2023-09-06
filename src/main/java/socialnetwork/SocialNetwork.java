package socialnetwork;

import Util.Input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SocialNetwork {
    private List<User> users;

    public List<User> getUsers(){
        return this.users;
    }
    public SocialNetwork(){
        this.users = new ArrayList<>();
        this.users.add(new User("noa"));
        this.users.add(new User("maria"));
        this.users.add(new User("juan"));
    }

    public void addNewUser(){
            String username = Input.string("Introduce tu nombre de usuario: \n").toLowerCase().trim();
            if(!userExists(username)){
                this.users.add(new User(username));
                showMessage("Tu cuenta se ha creado correctamente");
            }else{
                showMessage("El usuario ya existe");
            }
        }

        public void removeUser(){
            String username = Input.string("Introduce tu nombre de usuario: ");
            if(userExists(username)){
                for(User user: this.users){
                    if(user.getName().equals(username.toLowerCase().trim())){
                        this.users.remove(user);
                        showMessage("Tu usuario se ha eliminado correctamente");
                    }
                }
            }else{
                showMessage("El usuario introducido no existe");
            }
        }

    private  boolean userExists(String username){
        for(User user: this.getUsers()){
            if(user.getName().equals(username.toLowerCase().trim())){
                return true;
            }
        }
        return false;
    }

    public User getSingleUser() {
            String username = Input.string("Introduce tu nombre de usuario: \n");
            if(userExists(username)){
                User currentUser = null;
                for (User user : this.users) {
                    if (user.getName().equals(username.toLowerCase().trim())) {
                        currentUser = user;
                    }
                }
                return currentUser;
            }else{
                showMessage("El usuario introducido no existe");
                return null;
            }
    }

    public void suggestFriends(User user){
        List<User> suggestedFriends = new ArrayList<>();
        if(!user.getUsersFollowing().isEmpty()){
            for(User u: this.getUsers()){
                if(u.equals(user)){
                    continue;
                }
                List<User> commonFriends = new ArrayList<>(this.getUsers());
                commonFriends.retainAll(user.getUsersFollowing());
                if(!commonFriends.isEmpty()){
                    suggestedFriends.add(u);
                }
        }
        }
        suggestedFriends.removeAll(user.getUsersFollowing());
        printSuggestedFriends(suggestedFriends);
    }

    private void printSuggestedFriends(List<User> suggestedFriends){
        if(!suggestedFriends.isEmpty()){
            showMessage("Gente a la que podrías conocer: ");
            for(User u: suggestedFriends){
                System.out.println(u.getName());
            }
        }
    }


    private void showMessage(String message){
        System.out.println(message);
    }

    }

