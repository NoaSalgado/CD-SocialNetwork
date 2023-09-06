import Util.Input;
import socialnetwork.SocialNetwork;
import socialnetwork.User;
import ui.TextUI;


public class Main {
    public static void main(String[] args) {
        SocialNetwork mySocialNetwork = new SocialNetwork();
        TextUI.init(mySocialNetwork);
    }
}


