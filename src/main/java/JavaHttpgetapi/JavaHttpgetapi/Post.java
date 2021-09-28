package JavaHttpgetapi.JavaHttpgetapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
	private int id;
	private int userId;
	private String title;
	private String body;
	
	public String toString() {
		return "Post{"+
				"id='"+
				id +
				", title='"+ title +'\''+
				'}';
	}
	
}
