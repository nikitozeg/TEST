package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;@
Entity
public class Post extends Model {

    @
    Required
    public String title;

    @
    Required
    public Date postedAt;

    @
    Lob@ Required@ MaxSize(10000)
    public String content;@
    Required@ ManyToOne
    public User author;

    public Post(User author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }

}