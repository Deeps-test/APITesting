package resourses;

import java.util.ArrayList;

import POJO.AddPlace;
import POJO.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad(String name , String language, String address) {
		AddPlace place = new AddPlace();
		ArrayList mylist = new ArrayList();
		mylist.add("Shop");
		mylist.add("Shoe park");
		
		Location l = new Location();
		l.setLat(45.987765);
		l.setLng(-98.96554);
		place.setAccuracy(50);
		place.setPhone_number("(+91) 983 893 3937");
		place.setAddress(address);
		//place.setName("Frontline  house jnas");
		place.setName(name);
		place.setTypes(mylist);
		place.setWebsite("http://google.com");
		place.setLanguage(language);
		place.setLocation(l);
		return place;
	}

	public String DeleteplacePayload(String place_id)
	{
		return "{\n"
				+ "\"place_id\":\""+place_id+"\"\n"
				+ "}";
	}
}
