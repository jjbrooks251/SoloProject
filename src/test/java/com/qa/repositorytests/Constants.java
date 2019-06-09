package com.qa.repositorytests;

import com.qa.persistance.domain.User;

public class Constants {
	
	/* 
	 {"1":{"uId":1,"username\":" jbro95","password":"Jbrooks95","email":"jbro95@qa.com"}}
	"{\"id\":2,\"username\":\" cTatum94\",\"password\":\"Mynamegeoff25\",\"email\":\"cTatum94@qa.com\"}"
	"{\"id\":1,\"username\":\" jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbrok95@qa.com\"}"
	"{\"id\":2,\"username\":\" jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbrok95@qa.com\"}"
	"{\"id\":2,\"username\":\" jbrok95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}"
	"{\"id\":2,\"username\":\" jjbro95\",\"password\":\"Jbroo95\",\"email\":\"jjbro95@qa.com\"}"
	*/
	public final static User user1 = new User(1, "jbro95", "Jbrooks95", "jbro95@qa.com");
	public final static User user2 = new User(2, "cTatum94", "Mynamegeoff25", "@qa.com");
	public final static User sameId = new User(1, "jbro95", "Jbrooks95", "jbrok95@qa.com");
	public final static User sameName = new User(2, "jbro95", "Jbrooks95", "jbrook95@qa.com");
	public final static User sameEmail = new User(2, "jbrok95", "Jbrooks95", "jbro95@qa.com");
	public final static User smallPass = new User(2, "jjbro95", "Jbroo95", "jjbro95@qa.com");
	

}
