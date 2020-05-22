package resources;
//enum is special class in java which has collection of methods or constants

public enum APIResources {
	
	AddUserAPI("/users"),
	GetUserAPI("/users?id=");
	private String resource;

	
	APIResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}
	
	public String getResource() {
		
		return resource;	
	}

}
