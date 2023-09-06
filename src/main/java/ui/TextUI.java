package ui;

import Util.Input;
import socialnetwork.SocialNetwork;
import socialnetwork.User;

public final class TextUI {
    public static void init(SocialNetwork socialNetwork){
        System.out.println("Bienvenid@ a mySocialNework 🎉!");
        System.out.println("Elige una opción:");
        System.out.println("1️⃣ - Nuevo usuario");
        System.out.println("2️⃣ - Ya tengo cuenta");
        System.out.println("3️⃣ - Eliminar mi cuenta");
        System.out.println("4️⃣ - Salir");
        int userChoice = Input.integer();
        initialUserAction(userChoice, socialNetwork);
    }

    public static void initialUserAction(int userChoice, SocialNetwork socialNetwork){
        switch(userChoice){
            case 1:
                System.out.println("Introduce un nombre de usuario: \n");
                socialNetwork.addNewUser();
                init(socialNetwork);
                break;
            case 2:
                System.out.println("Introduce tu nombre de usuario: \n");
                User currentUser = socialNetwork.getSingleUser();
                selectloggedUserAction(currentUser, socialNetwork);
                break;
            case 3:
                System.out.println("Introduce tu nombre de usuario: \n");
                socialNetwork.removeUser();
                init(socialNetwork);
                break;
            case 4:
                System.out.println("Has cerrado la aplicación 🙋‍♀️");
            default:
                System.out.println("Opción incorrecta");
                init(socialNetwork);
        }
    }

    public static void selectloggedUserAction(User user, SocialNetwork socialNetwork){
        System.out.println("Hola " + user.getName() + " 👋!");
        socialNetwork.suggestFriends(user);
        int userChoice;
        System.out.println("Selecciona la acción que deseas realizar: ");
        System.out.println("1️⃣ - Ver muro");
        System.out.println("2️⃣ - Seguir a un usuario");
        System.out.println("3️⃣ - Dejar de sequir a un usuario");
        System.out.println("4️⃣ - Publicar un post");
        System.out.println("5️⃣ - Eliminar un post");
        System.out.println("6️⃣ - Añadir un comentario");
        System.out.println("7️⃣ - Eliminar un comentario");
        System.out.println("8️⃣ - Ver todos tus posts");
        System.out.println("9️⃣ - Ver todos tus comentarios");
        System.out.println("1️⃣0️⃣ - Ver el número de comentarios de un post");
        System.out.println("1️⃣1️⃣ - Cerrar sesión\n");
        userChoice = Input.integer();
        performUserAction(user, userChoice, socialNetwork);
    }

    public static void performUserAction(User user, int userChoice, SocialNetwork socialNetwork){
        switch(userChoice){
            case 1:
                user.printFollowingUsersPosts();
            case 2:
                System.out.println("Introduce el nombre de usuario que deseas seguir: \n");
                User userToFollow = socialNetwork.getSingleUser();
                if(!userToFollow.equals(null)){
                    user.followUser(userToFollow);
                    break;
                }
            case 3:
                System.out.println("Introduce el nombre de usuario al que deseas dejar de seguir: \n");
                User userToUnfollow = socialNetwork.getSingleUser();
                if(!userToUnfollow.equals(null)){
                    user.unfollowUser(userToUnfollow);
                }
                break;
            case 4:
                System.out.println("Selecciona el tipo de post que quieres publicar: ");
                System.out.println("1️⃣ - Texto");
                System.out.println("2️⃣ - Imagen");
                System.out.println("3️⃣ - Video\n");
                user.selectPostType();
                break;
            case 5:
                System.out.println("Indica el número del post que deseas eliminar: \n");
                user.printUserPublishedPosts();
                user.deletePost();
                break;
            case 6:
                System.out.println("Selecciona el nombre de usuario que ha creado el post: \n");
                User userToComment = socialNetwork.getSingleUser();
                System.out.println("Indica el número de post que deseas comentar: ");
                user.commentPost(userToComment);
                break;
            case 7:
                System.out.println("Indica el número del comentario que quieres eliminar: ");
                user.deleteUserComment();
                break;
            case 8:
                user.printUserPublishedPosts();
                break;
            case 9:
                System.out.println(user);
                user.printUserComments();
                break;
            case 10:
                user.printUserPostNumComments();
                break;
            case 11:
                System.out.println("Has cerrado sesión 🔒");
                init(socialNetwork);
                break;
        }
        selectloggedUserAction(user, socialNetwork);
    }
}

