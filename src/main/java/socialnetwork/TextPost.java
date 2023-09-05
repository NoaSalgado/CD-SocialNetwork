package socialnetwork;

public class TextPost extends Post{
    private String content;

    public TextPost(String content){
        this.content = content;
    }

    @Override
    public String toString(){
        return "Fecha: " + this.getPostDate() + "Texto: " + this.content;
    }
}
