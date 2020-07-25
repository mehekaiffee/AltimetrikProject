package ApiAutomation;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import java.io.File;

import org.testng.Assert;

public class PostApi {
public static void main(String[] args) {
		
		Response postResponse=given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(new File("./Payload.json")).log().all()
				.post("https://postman-echo.com/post");
		
		postResponse.prettyPrint();

		        Assert.assertEquals(postResponse.statusCode(),200);
		
				System.out.println("Post Response status code is "+postResponse.statusCode());
				Assert.assertEquals(postResponse.getBody().path("data.foo1"), "bar1");
				Assert.assertEquals(postResponse.getBody().path("data.foo2"), "bar2");
				Assert.assertEquals(postResponse.getBody().path("headers.x-forwarded-proto"), "https");
				Assert.assertEquals(postResponse.getBody().path("headers.x-forwarded-port"), "443");	
				Assert.assertEquals(postResponse.getBody().path("headers.host"), "postman-echo.com");				
				String traceId=postResponse.getBody().path("headers.x-amzn-trace-id");
				Assert.assertTrue(traceId.contains("Root="));
				Assert.assertEquals(postResponse.getBody().path("headers.content-type"), "application/json; charset=UTF-8");
				Assert.assertEquals(postResponse.getBody().path("headers.accept"), "*/*");
				Assert.assertEquals(postResponse.getBody().path("headers.user-agent"), "Apache-HttpClient/4.5.3 (Java/12.0.1)");
				Assert.assertEquals(postResponse.getBody().path("headers.accept-encoding"), "gzip,deflate");				
				Assert.assertEquals(postResponse.getBody().path("url"), "https://postman-echo.com/post");

				

	}


}
