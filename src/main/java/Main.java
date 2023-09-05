import Util.Input;
import socialnetwork.SocialNetwork;
import socialnetwork.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocialNetwork mySocialNewtwork = new SocialNetwork();
        init(mySocialNewtwork);
    }

    static void init(SocialNetwork socialNewtwork){
        System.out.println("Bienvenid@ a mySocialNework!");
        System.out.println("Elige una opción:");
        System.out.println("1 -  Nuevo usuario");
        System.out.println("2 -  Ya tengo cuenta");
        System.out.println("3 - Eliminar mi cuenta");
        char userChoice = Input.character("\n");

        while(userChoice != '1' && userChoice != '2' && userChoice != '3'){
            System.out.println("Opción incorrecta. " +
                    "\nIntroduce 1 para crear nuevo usuario " +
                    "\n Introduce 2 si ya tienes cuenta");
            userChoice = Input.character();
        }
        initialUserAction(userChoice, socialNewtwork);
    }

    static void initialUserAction(char userChoice, SocialNetwork socialNetwork){
        switch(userChoice){
            case '1':
                socialNetwork.addNewUser();
                init(socialNetwork);
                break;
            case'2':
                User currentUser = socialNetwork.getSingleUser();
                selectloggedUserAction(currentUser, socialNetwork);
                break;
            case '3':
                socialNetwork.removeUser();
                init(socialNetwork);
                break;
        }
    }

    static void selectloggedUserAction(User user, SocialNetwork socialNetwork){
        System.out.println("Hola" + user.getName() + "!");
        int userChoice;
            System.out.println("Selecciona la acción que deseas realizar: ");
            System.out.println("1 - Ver muro");
            System.out.println("2 - Seguir a un usuario");
            System.out.println("3 - Dejar de sequir a un usuario");
            System.out.println("4 - Publicar un post");
            System.out.println("5 - Eliminar un post");
            System.out.println("6 - Añadir un comentario");
            System.out.println("7 - Eliminar un comentario");
            System.out.println("8 - Ver todos tus posts");
            System.out.println("9 - Ver todos tus comentarios");
            System.out.println("10 - Ver el número de comentarios de un post");
            System.out.println("11 - Salir");
            userChoice = Input.integer();
            performUserAction(user, userChoice, socialNetwork);
    }

    static void performUserAction(User user, int userChoice, SocialNetwork socialNetwork){
        switch(userChoice){
            case 1:
                user.printFollowingUsersPosts();
            case 2:
                User userToFollow = socialNetwork.getSingleUser();
                if(!userToFollow.equals(null)){
                    user.followUser(userToFollow);
                    break;
                }
            case 3:
                User userToUnfollow = socialNetwork.getSingleUser();
                if(!userToUnfollow.equals(null)){
                    user.unfollowUser(userToUnfollow);
                }
                break;
            case 4:
                user.selectPostType();
                break;
            case 5:
                user.deletePost();
                break;
            case 6:
                User userToComment = socialNetwork.getSingleUser();
                user.commentPost(userToComment);
                break;
            case 7:
                user.deleteUserComment();
                break;
            case 8:
                user.printUserPublishedPosts(user);
                break;
            case 9:
                user.printUserComments();
                break;
            case 10:
                user.printUserPostNumComments();
                break;
            case 11:
                init(socialNetwork);
                break;
        }
        selectloggedUserAction(user, socialNetwork);
    }
}
