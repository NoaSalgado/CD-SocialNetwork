package socialnetwork;

import java.time.LocalDate;

public class Comment {
    private String commentText;
    private LocalDate commentDate;
    private User owner;

    public Comment(String commentText, User owner){
        this.commentText = commentText;
        this.owner = owner;
        this.commentDate = LocalDate.now();
    }

    public String getCommentText(){
        return this.commentText;
    }

    public LocalDate getCommentDate(){
        return this.commentDate;
    }

    public User getOwner(){
        return this.owner;
    }

    @Override
    public String toString(){
        return "Usuario: " + this.getOwner().getName() + "Fecha: " + this.getCommentDate()
                + " Comentario: " + this.getCommentText();
    }
}
