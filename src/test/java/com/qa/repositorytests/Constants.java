package com.qa.repositorytests;

import com.qa.persistance.domain.User;

public class Constants {
	
	public final static String user1 = "{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}";
	public final static String user2 = "{\"uId\":2,\"username\":\"cTatum94\",\"password\":\"Mynamegeoff25\",\"email\":\"cTatum94@qa.com\"}";
	public final static String user3 = "{\"uId\":3,\"username\":\"jbro951\",\"password\":\"Jbrooks95\",\"email\":\"jbrok951@qa.com\"}";
	public final static String sameId = "{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbrok95@qa.com\"}";
	public final static String sameName = "{\"uId\":3,\"username\":\"jbro951\",\"password\":\"Jbrooks95\",\"email\":\"jbrok951@qa.com\"}";
	public final static String sameEmail = "{\"uId\":2,\"username\":\"jbrok95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}";
	public final static String smallPass = "{\"uId\":2,\"username\":\"jjbro95\",\"password\":\"Jbroo95\",\"email\":\"jjbro95@qa.com\"}";
	
	public final static User user12 = new User(1, "jbro95", "Jbrooks95", "jbro95@qa.com");
	/*public final static User user2 = new User(2, "cTatum94", "Mynamegeoff25", "@qa.com");
	public final static User sameId = new User(1, "jbro95", "Jbrooks95", "jbrok95@qa.com");
	public final static User sameName = new User(2, "jbro95", "Jbrooks95", "jbrook95@qa.com");
	public final static User sameEmail = new User(2, "jbrok95", "Jbrooks95", "jbro95@qa.com");
	public final static User smallPass = new User(2, "jjbro95", "Jbroo95", "jjbro95@qa.com");
	*/

}
