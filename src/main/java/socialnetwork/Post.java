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
}
