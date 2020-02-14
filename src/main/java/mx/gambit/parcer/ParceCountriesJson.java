package mx.gambit.parcer;


import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mx.gambit.bean.Country;
import mx.gambit.bean.League;

public class ParceCountriesJson {

	private ArrayList<Country> countriesList;
	private ArrayList<League> leaguesList;
	@SuppressWarnings("unchecked")
	public void parceCountries(Object obj) {
		JSONArray countries = (JSONArray) obj;
		countriesList = new ArrayList<Country>();
		countries.forEach( country ->{
			parceCountry((JSONObject)country);
		});
	}
	
	@SuppressWarnings("unchecked")
	public void parceLeagues(Object obj) {
		JSONArray countries = (JSONArray) obj;
		leaguesList = new ArrayList<League>();		
		countries.forEach( country ->{
			JSONArray Leagues = (JSONArray) ((JSONObject)country).get("Leagues");

			Leagues.forEach(league ->{
				parceLeague((JSONObject)league);
			});
		});		
	}
	
	public void parceLeague(JSONObject jsonObject) {
		//Get jsonObject object within list     
			League country = new League();
	        country.setNodeId( jsonObject.get("NodeId").toString());	                
	        country.setName( jsonObject.get("Name").toString());
	        country.setPriority( Integer.parseInt(jsonObject.get("Priority").toString()));
	        country.setParentNodeId( jsonObject.get("ParentNodeId").toString());
	        leaguesList.add(country);		
	}

	public void parceCountry(JSONObject jsonObject) {
		//Get jsonObject object within list     
		Country country = new Country();
        country.setNodeId( jsonObject.get("NodeId").toString());
        country.setCountryCode( jsonObject.get("CountryCode").toString());        
        country.setName( jsonObject.get("Name").toString());
        country.setPriority( Integer.parseInt(jsonObject.get("Priority").toString()));
        country.setParentNodeId( jsonObject.get("ParentNodeId").toString());
        countriesList.add(country);        
	}

	/**
	 * @return the countriesList
	 */
	public ArrayList<Country> getCountriesList() {
		return countriesList;
	}

	/**
	 * @param countriesList the countriesList to set
	 */
	public void setCountriesList(ArrayList<Country> countriesList) {
		this.countriesList = countriesList;
	}

	/**
	 * @return the leaguesList
	 */
	public ArrayList<League> getLeaguesList() {
		return leaguesList;
	}

	/**
	 * @param leaguesList the leaguesList to set
	 */
	public void setLeaguesList(ArrayList<League> leaguesList) {
		this.leaguesList = leaguesList;
	}
}
