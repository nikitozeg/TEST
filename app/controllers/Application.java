package controllers;

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

}