package resourses;

//Enum is special class in java which has collection of constants and methods
public enum APIResourses {

	addPlaceAPI("/maps/api/place/add/json"),
	getplaceAPI("/maps/api/place/get/json"),
	deleteplaceAPI("/maps/api/place/delete/json");
private String resourse;
	APIResourses(String resourse) {
		// TODO Auto-generated constructor stub
		this.resourse=resourse;
	}
	
	public String getResource() {
		
		return resourse;
		
	}
}
