package socialnetwork;

import Util.Input;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<User> users;

    public List<User> getUsers(){
        return this.users;
    }
    public SocialNetwork(){
        this.users = new ArrayList<>();
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
    private void showMessage(String message){
        System.out.println(message);
    }

    }

