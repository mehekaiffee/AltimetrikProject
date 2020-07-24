package ApiAutomation;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutApi {
public static void main(String[] args) {
		
		Response putResponse=given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(new File("./Payload.json")).log().all()
				.put("https://postman-echo.com/put");

		        Assert.assertEquals(putResponse.statusCode(),200);
		        
				System.out.println("Put Response status code is "+putResponse.statusCode());
				Assert.assertEquals(putResponse.getBody().path("data.foo1"), "bar1");
				Assert.assertEquals(putResponse.getBody().path("data.foo2"), "bar2");
				Assert.assertEquals(putResponse.getBody().path("headers.x-forwarded-proto"), "https");
				Assert.assertEquals(putResponse.getBody().path("headers.x-forwarded-port"), "443");	
				Assert.assertEquals(putResponse.getBody().path("headers.host"), "postman-echo.com");				
				String traceId=putResponse.getBody().path("headers.x-amzn-trace-id");
				Assert.assertTrue(traceId.contains("Root="));
				Assert.assertEquals(putResponse.getBody().path("headers.content-type"), "application/json; charset=UTF-8");
				Assert.assertEquals(putResponse.getBody().path("headers.accept"), "*/*");
				Assert.assertEquals(putResponse.getBody().path("headers.user-agent"), "Apache-HttpClient/4.5.3 (Java/11.0.7)");
				Assert.assertEquals(putResponse.getBody().path("headers.accept-encoding"), "gzip,deflate");				
				Assert.assertEquals(putResponse.getBody().path("url"), "https://postman-echo.com/put");				

	}

}
