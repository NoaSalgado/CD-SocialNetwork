package socialnetwork;

import Util.Input;

import java.util.*;

public class User {
    private String name;
    private List<User> usersFollowing;
    private List<Post> postsPublished;

    public User(String name) {
        this.name = name.toLowerCase();
        this.usersFollowing = new ArrayList<>();
        this.postsPublished = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<User> getUsersFollowing() {
        return this.usersFollowing;
    }

    public List<Post> getPostsPublished() {
        return this.postsPublished;
    }

    public void followUser(User user) {
        if (!isFollowingUser(user.getName())) {
            this.usersFollowing.add(user);
            showMessage("Ahora sigues a " + user.getName());
        } else {
            showMessage("Ya sigues a este usuario");
        }
    }

    public void unfollowUser(User user) {
        if (isFollowingUser(user.getName())) {
            this.usersFollowing.remove(user);
            showMessage("Has dejado de seguir a " + user.getName());
        } else {
            showMessage("No sigues a este usuario");
        }
    }

    private boolean isFollowingUser(String username) {
        for (User user : this.usersFollowing) {
            if (user.name.equals(username.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void selectPostType() {
        System.out.println("Selecciona el tipo de post que quieres publicar: ");
        System.out.println("1 - Texto");
        System.out.println("2 - Imagen");
        System.out.println("3 - Video");
        char postType = Input.character();
        switch (postType) {
            case '1':
                addTextPost();
                break;
            case '2':
                addImagePost();
                break;
            case '3':
                addVideoPost();
                break;
            default:
                System.out.println("Opción incorrecta");
                selectPostType();
        }
    }

    private void addTextPost() {
        String text = Input.string("Introduce el texto del post: ");
        this.postsPublished.add(new TextPost(text));
        showMessage("Post publicado correctamente");
    }

    private void addImagePost() {
        String title = Input.string("Introduce el título de la imagen: ");
        int height = Input.integer("Introduce la altura de la imagen: ");
        int width = Input.integer("Introduce el ancho de la imagen: ");
        this.postsPublished.add(new ImagePost(title, height, width));
        showMessage("Imagen publicada correctamente");
    }

    private void addVideoPost() {
        String title = Input.string("Introduce el título del vídeo: ");
        int quality = Input.integer("Introduce la calidad del vídeo: ");
        int duration = Input.integer("Introduce la duración del vídeo: ");
        this.postsPublished.add(new VideoPost(title, quality, duration));
    }

    public void deletePost() {
        System.out.println("Indica el número del post que deseas eliminar");
        for (int i = 0; i < this.postsPublished.size(); i++) {
            System.out.println(i + " - " + this.postsPublished.get(i));
        }
        Post postToDelete = this.postsPublished.get(Input.integer());
        if (!postToDelete.equals(null)) {
            this.postsPublished.remove(postToDelete);
            showMessage("Tu post ha sido eliminado");
            System.out.println(this.postsPublished.size());
        } else {
            showMessage("El post seleccionado no existe");
            deletePost();
        }
    }

    public void printUserPublishedPosts(User user) {
        for (int i = 0; i < user.postsPublished.size(); i++) {
            System.out.println(i + " - " + user.postsPublished.get(i));
        }
    }

    public void commentPost(User user) {
        System.out.println("Indica el número de post que deseas comentar: ");
        printUserPublishedPosts(user);
        Post postToComment = user.postsPublished.get(Input.integer());
        if (!postToComment.equals(null)) {
            String commentText = Input.string("Introduce tu comentario");
            postToComment.addComment(commentText, this);
            showMessage("Tu comentario se ha añadido correctamente");
        } else {
            showMessage("El post seleccionado no existe");
            commentPost(user);
        }
    }

    private List<Comment> getUserComments() {
        List<Comment> userComments = new ArrayList<>();
        for (User user : this.usersFollowing) {
            for (Post post : user.getPostsPublished()) {
                for (Comment comment : post.getComments()) {
                    if (comment.getOwner().equals(this)) {
                        userComments.add(comment);
                    }
                }
            }
        }
        return userComments;
    }
    public void printUserComments () {
        for (int i = 0; i < getUserComments().size(); i++){
            System.out.println(i + " - " +
                    getUserComments().get(i));
        }
    }

    public void deleteUserComment(){
        List<Comment> userComments = getUserComments();
        System.out.println("Indica el número del comentario que quieres eliminar: ");
        printUserComments();
        Comment commentToDelete = userComments.get(Input.integer());
        if(!commentToDelete.equals(null)){
            for(User user: this.usersFollowing){
                for(Post post: user.getPostsPublished()){
                    if(post.getComments().contains(commentToDelete)){
                        post.deleteComment(commentToDelete);
                    }
                }
            }
            showMessage("Tu comentario ha sido eliminado");
        }else{
            System.out.println("El comentario indicado no existe");
            deleteUserComment();
        }
    }

    public void printUserPostNumComments () {
        System.out.println("Indica el número del post del que quieres conocer el número de comentarios: ");
        printUserPublishedPosts(this);
        Post postToCountComments = this.postsPublished.get(Input.integer());
        System.out.println("Número de comentarios: " + postToCountComments.getNumComments());
    }

    private List<Post> getAllFollowingUsersPosts(){
        List<Post> allFollowingUsersPosts = new ArrayList<>();
        for(User user: this.usersFollowing){
            allFollowingUsersPosts.addAll(user.getPostsPublished());
        }
        return allFollowingUsersPosts;
    }

    public void printFollowingUsersPosts(){
        List<Post> followingUsersPosts = getAllFollowingUsersPosts();
        followingUsersPosts.sort((post1, post2) -> post1.getPostDate().compareTo(post2.getPostDate()));
        for(int i = 0; i < followingUsersPosts.size(); i++){
            if(i >= 10){
                break;
            }
            System.out.println(followingUsersPosts.get(i));
        }
    }
    private void showMessage (String message){
        System.out.println(message);
    }

    public String toString () {
        return "Usuario: " + this.getName();
    }
}

