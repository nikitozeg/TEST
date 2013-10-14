package controllers;
 
import java.util.*;
 
import play.*;
import play.mvc.*;
 
import models.*;
 
public class Application extends Controller {
 
    public static void index() {
        Post frontPost = Post.find("order by postedAt desc").first();
        List<Post> olderPosts = Post.find(
            "order by postedAt desc"
        ).from(1).fetch(10);
        render(frontPost, olderPosts);
    }
 }


/*package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	// статическая переменная, которая будет хранить наше значение
    public static String savedValue = "";
	public static void index(boolean isPost, String value) {
		if (isPost){
			savedValue=value;
			redirect("Application.index");
		}
		renderArgs.put("myVar", savedValue);
        render();
    }

}*/