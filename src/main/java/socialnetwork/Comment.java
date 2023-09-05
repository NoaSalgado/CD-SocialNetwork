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
}
