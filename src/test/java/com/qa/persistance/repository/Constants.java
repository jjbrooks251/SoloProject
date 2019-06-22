package com.qa.persistance.repository;

import java.util.HashSet;
import java.util.Set;

import com.qa.persistance.domain.Rarity;
import com.qa.persistance.domain.Type;
import com.qa.persistance.domain.Unit;
import com.qa.persistance.domain.User;

public class Constants {
	
	public final static String user1 = "{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\",\"characters\":[]}";
	public final static String user2 = "{\"uId\":2,\"username\":\"cTatum94\",\"password\":\"Mynamegeoff25\",\"email\":\"cTatum94@qa.com\"}";
	public final static String user3 = "{\"uId\":3,\"username\":\"jbro951\",\"password\":\"Jbrooks95\",\"email\":\"jbrok951@qa.com\"}";
	public final static String sameId = "{\"uId\":1,\"username\":\"jbro951\",\"password\":\"Jbrooks95\",\"email\":\"jbrok95@qa.com\"}";
	public final static String sameName = "{\"uId\":3,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbrok951@qa.com\"}";
	public final static String sameEmail = "{\"uId\":2,\"username\":\"jbrok95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}";
	public final static String smallPass = "{\"uId\":2,\"username\":\"jjbro95\",\"password\":\"Jbroo95\",\"email\":\"jjbro95@qa.com\"}";
	
	public final static String char1 = "{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":9578,\"atk\":10453,\"def\":5478}";
	
	public static final String MOCK_RARE_DATA_ARRAY1 = "[{\"rId\":1,\"name\":\"N\",\"lvMax\":20}]";
	public static final String MOCK_RARE_OBJECT1 = "{\"rId\":1,\"name\":\"N\",\"lvMax\":20}";
	public static final Rarity rare1 = new Rarity(1, "N", 20);

	public static final String MOCK_RARE_OBJECT2 = "{\"rId\":2,\"name\":\"R\",\"lvMax\":40}";
	public static final Rarity rare2 = new Rarity(2, "R", 40);

	public static final String MOCK_RARE_OBJECT3 = "{\"rId\":3,\"name\":\"SR\",\"lvMax\":60}";
	public static final Rarity rare3 = new Rarity(3, "SR", 60);
	
	public static final String MOCK_STORE_OBJECT1 = "{\"uId\":1,\"cId\":1}";

	public static final Unit unit1 = new Unit(1, "SSJ3 Gotenks", "Super", 20, 20, 20, 2, 2);
	public static final Unit unit2 = new Unit(2, "SSJ Gotenks", "Super", 20, 20, 20, 1, 1);
	public static final String MOCK_STORE_DATA_ARRAY3 = "[{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20,\"type\":2,\"rarity\":2}]";
	
	public static final String MOCK_TYPE_OBJECT1 = "{\"tId\":1,\"name\":\"AGL\"}";
	public static final Type type1 = new Type(1, "AGL");
	public static final String MOCK_TYPE_DATA_ARRAY1 = "[{\"tId\":1,\"name\":\"AGL\"}]";
	
	public static final String MOCK_TYPE_OBJECT2 = "{\"tId\":2,\"name\":\"STR\"}";
	public static final Type type2 = new Type(2, "STR");
	
	public static final String MOCK_TYPE_OBJECT3 = "{\"tId\":3,\"name\":\"TEQ\"}";
	public static final Type type3 = new Type(3, "TEQ");
	
	public static final String MOCK_UNIT_DATA_ARRAY1 = "[{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20,\"type\":2,\"rarity\":2}]";
	public static final String MOCK_UNIT_OBJECT1 = "{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20,\"type\":2,\"rarity\":2}";

	public static final String MOCK_UNIT_OBJECT2 = "{\"cId\":2,\"name\":\"SSJ Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20,\"type\":1,\"rarity\":1}";

	public static final String MOCK_UNIT_OBJECT3 = "{\"cId\":13,\"name\":\"goku\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20,\"type\":2,\"rarity\":2}";
	public static final Unit unit3 = new Unit(13, "goku", "Super", 20, 20, 20, 2, 2);

	public static final String MOCK_USER_DATA_ARRAY1 = "[{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}]";
	public static final String MOCK_USER_OBJECT1 = "{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"}";
	
	public static final String MOCK_USER_OBJECT2 = "{\"uId\":2,\"username\":\"cTatum94\",\"password\":\"Mynamegeoff25\",\"email\":\"cTatum94@qa.com\"}";
	
	public static final String MOCK_USER_OBJECT3 = "{\"uId\":3,\"username\":\"jbro951\",\"password\":\"Jbrooks951\",\"email\":\"jbrok951@qa.com\"}";
	
	public static final User user11 = new User(1, "jbro95", "Jbrooks95", "jbro95@qa.com", null);
	public static final User user12 = new User(2, "cTatum94", "Mynamegeoff25", "cTatum94@qa.com", null);
	public static final User user13 = new User(3, "jbro951", "Jbrooks951", "jbrok951@qa.com", null);

	public static final Set<Unit> units = new HashSet<>();
	
	public static final String MOCK_TEAM_DATA_ARRAY1 = "[{\"tId\":1,\"name\":\"team\",\"user\":{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"},\"characters\":[{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20,\"type\":2,\"rarity\":2}]}]";
	public static final String MOCK_TEAM_OBJECT1 = "{\"tId\":1,\"name\":\"team\",\"user\":{\"uId\":1,\"username\":\"jbro95\",\"password\":\"Jbrooks95\",\"email\":\"jbro95@qa.com\"},\"characters\":[{\"cId\":1,\"name\":\"SSJ3 Gotenks\",\"alignment\":\"Super\",\"hp\":20,\"atk\":20,\"def\":20,\"type\":2,\"rarity\":2}]}";
	
}
