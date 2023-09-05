package socialnetwork;

public class ImagePost extends Post{
    private String title;
    private int height;
    private int width;

    public ImagePost(String title, int height, int width){
        this.title = title;
        this.height = height;
        this.width = width;
    }
}
