import org.junit.*;
import play.test.*;
import models.*;
import java.util.List;
public class Tes extends UnitTest {

@Before
public void setup() {
Fixtures.deleteDatabase();
}

@Test

/*public void tryConnectAsUser() {
    // Create a new user and save it
    new User("bob@gmail.com", "secret", "Bob").save();
    
    // Test 
    assertNotNull(User.connect("bob@gmail.com", "secret"));
    assertNull(User.connect("bob@gmail.com", "badpassword"));
    assertNull(User.connect("tom@gmail.com", "secret"));
}*/
public void createPost() {
    // Create a new user and save it
    User bob = new User("bob@gmail.com", "secret", "Bob").save();
    
    // Create a new post
    new Post(bob, "My first post", "Hello world").save();
    
    // Test that the post has been created
    assertEquals(1, Post.count());
    
    // Retrieve all posts created by Bob
    List<Post> bobPosts = Post.find("byAuthor", bob).fetch();
    
    // Tests
    assertEquals(1, bobPosts.size());
    Post firstPost = bobPosts.get(0);
    assertNotNull(firstPost);
    assertEquals(bob, firstPost.author);
    assertEquals("My first post", firstPost.title);
    assertEquals("Hello world", firstPost.content);
    assertNotNull(firstPost.postedAt);
}
}
/*
public void createPost() {
    // Create a new user and save it
    User bob = new User("bob@gmail.com", "secret", "Bob").save();
    
    // Create a new post
    new Post(bob, "My first post", "Hello world").save();
    
    // Test that the post has been created
    assertEquals(1, Post.count());
    
    // Retrieve all posts created by Bob
    List<Post> bobPosts = Post.find("byAuthor", bob).fetch();
    
    // Tests
    assertEquals(1, bobPosts.size());
    Post firstPost = bobPosts.get(0);
    assertNotNull(firstPost);
    assertEquals(bob, firstPost.author);
    assertEquals("My first post", firstPost.title);
    assertEquals("Hello world", firstPost.content);
    assertNotNull(firstPost.postedAt);*/

