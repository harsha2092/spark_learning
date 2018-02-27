package service;

import models.Post;

import java.util.List;

public class PostService {
    public void addPost(String content) {
        Post post = new Post(content);
    }

    public List<Post> getAllPosts(){
        return Post.getAllPosts();
    }
}
