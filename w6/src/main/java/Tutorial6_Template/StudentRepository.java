
package data;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class StudentRepository {
    private final String baseUrl = "http://localhost:3004/students";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public int addStudent(Student student) {
       final HttpRequest REQUEST = HttpRequest.newBuilder()
	 .uri(URI.create(baseUrl))
	   .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(student)))
	     .build();
       
       try 
	 {
	    final HttpResponse<String> RESPONSE = client.send(REQUEST, HttpResponse.BodyHandlers.ofString());
	    return RESPONSE.statusCode();
	 }
       catch (final Exception EXCEPTION)
	 {
	    EXCEPTION.printStackTrace();
	    return 0;
	 }
    }

    public Student getStudent(String id) {
       final HttpRequest REQUEST = HttpRequest.newBuilder()
	 .uri(URI.create(baseUrl + "/" + id))
	   .GET()
	     .build();
       
       try
	 {
	    final HttpResponse<String> RESPONSE = client.send(REQUEST, HttpResponse.BodyHandlers.ofString());
	    return gson.fromJson(RESPONSE.body(), Student.class);
	 }
       catch (final Exception EXCEPTION)
	 {
	    EXCEPTION.printStackTrace();
	    return null;
	 }
    }

    public int updateStudent(String id, Student student) {
       final HttpRequest REQUEST = HttpRequest.newBuilder()
	 .uri(URI.create(baseUrl + "/" + id))
	   .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(student)))
	     .build();
       
       try
	 {
	    final HttpResponse<String> RESPONSE = client.send(REQUEST, HttpResponse.BodyHandlers.ofString());
	    return RESPONSE.statusCode();
	 }
       catch (final Exception EXCEPTION)
	 {
	    EXCEPTION.printStackTrace();
	    return 0;
	 }
    }

    public int removeStudent(String id) {
       final HttpRequest REQUEST = HttpRequest.newBuilder()
	 .uri(URI.create(baseUrl + "/" + id))
	   .DELETE()
	     .build();

       try
	 {
	    final HttpResponse<String> RESPONSE = client.send(REQUEST, HttpResponse.BodyHandlers.ofString());
	    return RESPONSE.statusCode();
	 }
       catch (final Exception EXCEPTION)
	 {
	    EXCEPTION.printStackTrace();
	    return 0;
	 }
    }

    public List<Student> getAllStudents() {
       final HttpRequest REQUEST = HttpRequest.newBuilder()
	 .uri(URI.create(baseUrl))
	   .GET()
	     .build();
       
       final TypeToken<List<Student>> LIST = new TypeToken<List<Student>>()
	 {
	 }
       ;

       try
	 {
	    final HttpResponse<String> RESPONSE = client.send(REQUEST, HttpResponse.BodyHandlers.ofString());
	    System.out.println("Got the response");
	    return gson.fromJson(RESPONSE.body(), LIST.getType());
	 }
       catch (final Exception EXCEPTION)
	 {
	    EXCEPTION.printStackTrace();
	    return null;
	 }
    }
}
