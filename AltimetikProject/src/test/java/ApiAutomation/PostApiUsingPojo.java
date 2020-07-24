package ApiAutomation;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

	public class PostApiUsingPojo {

		public static void main(String[] args) {
			
			Pojo payload=new Pojo("bar1", "bar2");
			
			
			Response postResponse=given()
					.auth().none()
					.header("Content-Type","application/json")
					.contentType(ContentType.JSON)
					.when()
					.body(payload).log().all()
					.post("https://postman-echo.com/post");

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
					Assert.assertEquals(postResponse.getBody().path("headers.user-agent"), "Apache-HttpClient/4.5.3 (Java/11.0.7)");
					Assert.assertEquals(postResponse.getBody().path("headers.accept-encoding"), "gzip,deflate");				
					Assert.assertEquals(postResponse.getBody().path("url"), "https://postman-echo.com/post");

					

		}

	}



