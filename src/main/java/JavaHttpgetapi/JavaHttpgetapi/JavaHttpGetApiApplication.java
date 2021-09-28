package JavaHttpgetapi.JavaHttpgetapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class JavaHttpGetApiApplication {

	private static final String POSTS_API_URL = "http://jsonplaceholder.typicode.com/posts";
	
	public static void main(String[] args) {
		SpringApplication.run(JavaHttpGetApiApplication.class, args);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().GET()
				.header("accept", "application/json")
				.uri(URI.create(POSTS_API_URL))
				.build();
		
		try {
			HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			
			//parse JSON into objects
			ObjectMapper mapper = new ObjectMapper();
			List<Post> posts = mapper.readValue(response.body(), new TypeReference<List<Post>>(){});
			posts.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
