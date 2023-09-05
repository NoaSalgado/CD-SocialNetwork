package socialnetwork;

import Util.Input;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<User> usersFollowing;
    private List<Post> postsPublished;

    public User(String name){
        this.name = name.toLowerCase();
        this.usersFollowing = new ArrayList<>();
        this.postsPublished = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public List getUsersFollowing(){
        return this.usersFollowing;
    }
    public void followUser(User user){
        for(User u: usersFollowing){
            if
        }
        usersFollowing.add(user);
    }

    public void unfollowUser(User user){
        usersFollowing.remove(user);
    }

    public void addTextPost(){
        String text = Input.string("Introduce el texto del post: ");
        this.postsPublished.add(new TextPost(text));
        showConfirmationMessage("Post publicado correctamente");
    }

    public void addImagePost(){
        String title = Input.string("Introduce el título de la imagen: ");
        int height = Input.integer("Introduce la altura de la imagen: ");
        int width = Input.integer("Introduce el ancho de la imagen: ");
        this.postsPublished.add(new ImagePost(title, height, width));
        showConfirmationMessage("Imagen publicada correctamente");
    }

    public void addVideoPost(){
        String title = Input.string("Introduce el título del vídeo: ");
        int quality = Input.integer("Introduce la calidad del vídeo: ");
        int duration = Input.integer("Introduce la duración del vídeo: ");
        this.postsPublished.add(new VideoPost(title, quality, duration));
    }

    private void showConfirmationMessage(String message){
        System.out.println(message);
    }
}
