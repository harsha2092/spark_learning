package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PostTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateNewPostObjects() {
        Post post = new Post("Day 1: Intro");
        assertEquals(true,post instanceof Post);
    }

    @Test
    public void shouldGetContentFromPost() {
        Post post = new Post("Test");
        assertEquals("Test",post.getContent());
    }

    @Test
    public void shouldGetPosts() {
        Post post = new Post("Post1");
        Post otherPost = new Post("Post2");
        assertEquals(2,Post.getAllPosts().size());
    }

    @Test
    public void postsShouldContainAllPosts() {
        Post post = new Post("Post1");
        Post otherPost = new Post("Post2");
        List<Post> posts = Post.getAllPosts();
        assertEquals(true,posts.contains(post));
        assertEquals(true,posts.contains(otherPost));
    }
}
