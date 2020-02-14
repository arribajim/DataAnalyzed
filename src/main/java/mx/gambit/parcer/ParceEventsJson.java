package mx.gambit.parcer;

import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mx.gambit.bean.Event;
import mx.gambit.bean.Game;
import mx.gambit.bean.League;
import mx.gambit.bean.Participant;
import mx.gambit.bean.Result;

public class ParceEventsJson {
	private ArrayList<Event> eventList;
	private ArrayList<Game> gameList;
	private ArrayList<Result> resultList;
	private ArrayList<Participant> participantList;
	
	@SuppressWarnings("unchecked")
	public void parceEvents(Object obj) {
		JSONArray events = (JSONArray) obj;
		eventList = new ArrayList<Event>();
		events.forEach( country ->{
			parceEvent((JSONObject)country);
		});
	}
	
	@SuppressWarnings("unchecked")
	public void parceGames(Object obj) {
		JSONArray events = (JSONArray) obj;
		gameList = new ArrayList<Game>();		
		events.forEach( event ->{
			JSONArray games = (JSONArray) ((JSONObject)event).get("Games");
			games.forEach(part ->{
				parceGame((JSONObject)part);
			});
		});		
	}
	
	@SuppressWarnings("unchecked")
	public void parceResults(Object obj) {
		JSONArray events = (JSONArray) obj;
		resultList = new ArrayList<Result>();		
		events.forEach( event ->{
			JSONArray games = (JSONArray) ((JSONObject)event).get("Games");
			games.forEach(part ->{
				JSONArray results = (JSONArray) ((JSONObject)part).get("Results");
				results.forEach(result ->{
					parceResult((JSONObject)result);
				});
			});
		});		
	}
	
	

	private void parceResult(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		Result result = new Result();
		result.setNodeId( jsonObject.get("NodeId").toString());	                
		result.setName( jsonObject.get("Name").toString());
		result.setPriority( Integer.parseInt(jsonObject.get("Priority").toString()));
		result.setParentNodeId( jsonObject.get("ParentNodeId").toString());
		result.setOdd( jsonObject.get("Odd").toString());
		result.setLocked( Boolean.parseBoolean(jsonObject.get("Locked").toString()));
        resultList.add(result);
	}

	@SuppressWarnings("unchecked")
	public void parceParticipants(Object obj) {
		JSONArray events = (JSONArray) obj;
		participantList = new ArrayList<Participant>();		
		events.forEach( event ->{
			JSONArray participants = (JSONArray) ((JSONObject)event).get("Participants");

			participants.forEach(part ->{
				parceParticipant((JSONObject)part,(JSONObject)event);
			});
		});		
	}
	private void parceParticipant(JSONObject jsonObject, JSONObject event) {
		//Get jsonObject object within list     
			Participant part = new Participant();
			part.setNodeId( jsonObject.get("Id").toString());	                
	        part.setIsHome(Boolean.parseBoolean(jsonObject.get("IsHome").toString()));
	        part.setParentNodeId(event.get("ParentNodeId").toString());
	        //TODO move 
	        part.setName(parceName((JSONObject) jsonObject,"LocalizedNames"));	        
	        part.setShortName(parceName((JSONObject) jsonObject,"LocalizedShortNames"));	        
	        participantList.add(part);		
	}
	
	private void parceGame(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.setNodeId( jsonObject.get("NodeId").toString());	                
		game.setName( jsonObject.get("Name").toString());
		game.setPriority( Integer.parseInt(jsonObject.get("Priority").toString()));
		game.setParentNodeId( jsonObject.get("ParentNodeId").toString());
		game.setLocked( Boolean.parseBoolean(jsonObject.get("Locked").toString()));
        gameList.add(game);
	}

	private String parceName(JSONObject jsonObject, String string) {
		String nameR="";
		JSONObject LocalizedNames = (JSONObject) jsonObject.get(string);
        JSONArray names =(JSONArray)LocalizedNames.get("LocalizedValues");
        
        for(Object name:names) {
        	nameR = ((JSONObject)name).get("Value").toString();
        }
		return nameR;
	}

	private void parceEvent(JSONObject jsonObject) {
		//Get jsonObject object within list     
		Event event = new Event();
		event.setNodeId( jsonObject.get("NodeId").toString());                
		event.setName( jsonObject.get("Name").toString());
		event.setLocked( Boolean.parseBoolean(jsonObject.get("Locked").toString()));
		event.setPriority(Integer.parseInt(jsonObject.get("Priority").toString()));
		event.setParentNodeId( jsonObject.get("ParentNodeId").toString());
		//date
		 String strDate = (String) jsonObject.get("StarDate");
	        Calendar cal = Calendar.getInstance();
	        		cal.setTimeInMillis(
	        				Long.parseLong(
	        						strDate.substring(strDate.indexOf("(")+1, 
	        								strDate.indexOf(")"))));
		event.setStarDate(cal.getTime());
		event.setStatisticsId(jsonObject.get("StatisticsId").toString());
	         
        eventList.add(event);        
	}
	
	
	
	/**
	 * @return the eventList
	 */
	public ArrayList<Event> getEventList() {
		return eventList;
	}
	/**
	 * @param eventList the eventList to set
	 */
	public void setEventList(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}
	/**
	 * @return the gameList
	 */
	public ArrayList<Game> getGameList() {
		return gameList;
	}
	/**
	 * @param gameList the gameList to set
	 */
	public void setGameList(ArrayList<Game> gameList) {
		this.gameList = gameList;
	}
	/**
	 * @return the resultList
	 */
	public ArrayList<Result> getResultList() {
		return resultList;
	}
	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(ArrayList<Result> resultList) {
		this.resultList = resultList;
	}
	/**
	 * @return the participantList
	 */
	public ArrayList<Participant> getParticipantList() {
		return participantList;
	}
	/**
	 * @param participantList the participantList to set
	 */
	public void setParticipantList(ArrayList<Participant> participantList) {
		this.participantList = participantList;
	}
}
