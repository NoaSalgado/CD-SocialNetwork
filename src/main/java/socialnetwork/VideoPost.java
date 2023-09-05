package socialnetwork;

public class VideoPost extends Post{
    private String title;
    private int quality;
    private int duration;

    public VideoPost(String title, int quality, int duration){
        this.title = title;
        this.quality = quality;
        this.duration = duration;
    }

    @Override
    public String toString(){
        return  "Fecha: " + this.getPostDate() + "Video: " + this.title + " Duración: " + this.duration
                + " Calidad: " + this.quality;
    }
}
