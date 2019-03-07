package commonFiles;

import TestFramework.ReusableMethods;

public class Payload {
	
	
	public static String getPostData() {
		
		String b= "{" +
                "\"email\" :\"ben@2041.uk\"," +
                "\"password\" : \"idietoosoon\"" +
                "}";
		return b;
	}
	

	public static String getrefreshToken() {
		
		String r = "{\"email\": \"ben@2041.uk\",\"refreshToken\":\""+ReusableMethods.refresh()+"\"}";
		
		return r;
	}
	
	
public static String getfakeData() {
		
		String b= "{" +
                "\"email\" :\"bn@2041.uk\"," +
                "\"password\" : \"idietoosoon\"" +
                "}";
		return b;
	}
	
	/*public static String postUnit() {
		
		String b = "{\"unitId\": \""+id+"\",\"year\": 2081 }";
		
		return b;
	}*/
}
	