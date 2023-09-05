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

    @Override
    public String toString(){
        return " Fecha: " + this.getPostDate() + "Imagen: " + this.title + "Dimensiones: " + this.height + "x"
                + this.width;
    }
}
