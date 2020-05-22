package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqSpecification;
	public RequestSpecification requestSpecification() throws IOException {
				
		if(reqSpecification==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		reqSpecification = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseurl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return reqSpecification;
		}
		return reqSpecification;
	}

	
	public static String jsonPath(Response response , String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		String expectedValue = js.get(key);
		return expectedValue;
	}

	public static double jsonPath_int(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		double expectedValue = js.getDouble(key);
		return expectedValue;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		
		Properties prop = new Properties();
		
	
			FileInputStream file  = new FileInputStream("D:\\Project\\B2B_Assignment_API\\src\\test\\java\\resources\\global.properties");
			
				prop.load(file);

		return prop.getProperty(key);
	}
	

}
