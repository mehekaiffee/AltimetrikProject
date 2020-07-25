package ApiAutomation;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

	public class GetApi {
     
		public static void getResponse(String[]args) {
			
			Response getResponse=given().
					param("foo1", "bar1")
					.param("foo2", "bar2")
					.auth().none()
					.header("Content-Type","application/json")
					.contentType(ContentType.JSON)
					.when()
					.get("https://postman-echo.com/get");
					
					getResponse.prettyPrint();
					//System.out.println("Response is " +getResponse.asString());				
					System.out.println("Status code is " +getResponse.statusCode());
						
					Assert.assertEquals(getResponse.statusCode(),200);
					Assert.assertEquals(getResponse.getBody().path("args.foo1"), "bar1");
					Assert.assertEquals(getResponse.getBody().path("args.foo2"), "bar2");
					Assert.assertEquals(getResponse.getBody().path("headers.x-forwarded-proto"), "https");
					Assert.assertEquals(getResponse.getBody().path("headers.x-forwarded-port"), "443");	
					Assert.assertEquals(getResponse.getBody().path("headers.host"), "postman-echo.com");		
					//Assert.assertEquals(getResponse.getBody().path("headers.x-amzn-trace-id"), "Root=1-5f1a731e-d39b2fb8523eb347e1e7c078");				
					String traceId=getResponse.getBody().path("headers.x-amzn-trace-id");
					Assert.assertTrue(traceId.contains("Root="));
					Assert.assertEquals(getResponse.getBody().path("headers.content-type"), "application/json; charset=UTF-8");
					Assert.assertEquals(getResponse.getBody().path("headers.accept"), "*/*");
					Assert.assertEquals(getResponse.getBody().path("headers.user-agent"), "Apache-HttpClient/4.5.3 (Java/12.0.1)");
					Assert.assertEquals(getResponse.getBody().path("headers.accept-encoding"), "gzip,deflate");				
					Assert.assertEquals(getResponse.getBody().path("url"), "https://postman-echo.com/get?foo1=bar1&foo2=bar2");
					

					System.out.println("Response Time is " +getResponse.getTime());
		
		}
     
	}
