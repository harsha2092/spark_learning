package models;

import java.util.ArrayList;
import java.util.List;

public class Post {
    String content;
    static List<Post> posts = new ArrayList<>();

    public Post(String content) {
        this.content = content;
        posts.add(this);
    }

    public static List<Post> getAllPosts() {
        return posts;
    }

    public String getContent() {
        return content;
    }
}
