package api.testcases;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	user userPayload;
	
	
	@BeforeClass
	public void generateTestData() {
		
		faker= new Faker();
		
		userPayload = new user();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());	
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().phoneNumber());
	}
	
	@Test (priority = 1)
	public void testCreateUser() {
		
		Response response = userEndPoints.createUser(userPayload);
		
		// Log Response \
		response.then().log().all();
		
		//Validation
		assertEquals(response.getStatusCode(),200);
	}
	
	@Test (priority = 2)
	public void testGetUserData() {
		
		Response response = userEndPoints.GetUser(this.userPayload.getUsername());
		
		// Log Response 
		response.then().log().all();
		
		//Validation
		assertEquals(response.getStatusCode(),200);
	}

	@Test (priority = 3)
	public void testUpdateUserData() {
		userPayload.setFirstName(faker.name().firstName());
		Response response = userEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);
		
		// Log Response \
		response.then().log().all();
		
		//Validation
		assertEquals(response.getStatusCode(),200);
	}
	
	@Test (priority = 4)
	public void testDeleteUser() {
		
		Response response = userEndPoints.deleteUser(this.userPayload.getUsername());
		
		// Log Response \
		response.then().log().all();
		
		//Validation
		assertEquals(response.getStatusCode(),200);
	}
	
	
	

}
