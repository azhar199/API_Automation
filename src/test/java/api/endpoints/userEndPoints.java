package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {
	
	public static Response createUser(user payload) {
		
		Response response = (Response) given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(Routes.post_url);
		
		return response;
			
	}	
	
public static Response GetUser(String userName) {
		
		Response response = (Response) given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", userName)
				
				
				.when()
				.post(Routes.get_url);
		
		return response;
			
	}	
public static Response UpdateUser(String userName, user payload) {
	
	Response response = (Response) given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
			
			.when()
			.put(Routes.put_url);
	
	return response;
		
}	
public static Response deleteUser(String userName) {
	
	Response response = (Response) given()
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			
			
			.when()
			.delete(Routes.delete_url);
	
	return response;
		
}	
		
	
}
