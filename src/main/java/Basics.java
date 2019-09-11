import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		given().
			param("location", "33.8670522,151.1957362").
			param("radius", "1500").
			param("key", "AIzaSyBMR0RlzNr6O_OHaLlqF-ICKtm6jkdrKHE").
		when().
			get("/maps/api/place/nearbysearch/json").
		then().assertThat().
			statusCode(200).and().contentType(ContentType.JSON).and().
			body("results[0].name",equalTo("Sydney") );
			
		

	}

}
