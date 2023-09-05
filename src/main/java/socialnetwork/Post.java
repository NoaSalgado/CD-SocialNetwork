package socialnetwork;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Post {
    private LocalDate postDate;
    private List<Comment> comments;

    public Post(){
        this.postDate = LocalDate.now();
        this.comments = new ArrayList<>();
    }

    public LocalDate getPostDate(){
        return this.postDate;
    }
    public List<Comment> getComments(){
        return this.comments;
    }

    public void addComment(String commentText, User owner){
        this.comments.add(new Comment(commentText, owner));
    }

    public int getNumComments(){
        return this.getComments().size();
    }

    public void deleteComment(Comment comment){
        this.comments.remove(comment);
    }
}
