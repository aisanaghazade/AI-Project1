package p1;

import java.util.Vector;

public class State_p1 {
	String city_name;
	Vector<String> visited_cities;
	Vector<Integer> visited_number;
	public State_p1(String city_name, Vector<String> visited_city, Vector<Integer> visted_number, int city_number) {
		this.city_name = city_name;
		this.visited_cities = new Vector<String>();
		this.visited_number = new Vector<Integer>();
		for(int i=0; i<visited_city.size(); i++){
			this.visited_cities.addElement(visited_city.elementAt(i));
			this.visited_number.addElement(visted_number.elementAt(i));
		}
		this.visited_cities.addElement(city_name);
		this.visited_number.addElement(city_number);
	}
}
