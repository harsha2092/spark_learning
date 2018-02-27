package service;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostServiceTest {
    @Test
    public void shouldAddPost() {
        PostService postService = new PostService();
        postService.addPost("content");
    }
}
