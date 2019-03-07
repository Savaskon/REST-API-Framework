package commonFiles;


public class Resources {
	
	public static String postlogin() {
String x = "/api/auth/login";
		
		return x;	
	}

	public static String refreshAuth() {
		
		String r = "/api/auth/refresh-token";
		
		return r;
	}

	
	public static String getUnit() {
		
		String g = "/api/units/";
		
		return g;
		
	}
	
	public static String bookUnit() {
		
		String b = "/api/units/book";
		
		return b;
	}
	
	public static String baseUrl() {
		
		String x = "http://mars.theblueground.net/";
		
		return x;
	}

}
