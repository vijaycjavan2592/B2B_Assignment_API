package resources;

public class TestDataBuild {

	public static String createUserPayload(String name, String username, String email, String phone) {

		return "{\r\n    \"name\": \""+name+"\",\r\n    \"username\": \""+username+"\",\r\n    \"email\": \""+email+"\",\r\n    \"phone\": \""+phone+"\"\r\n}\r\n";
	}

}
