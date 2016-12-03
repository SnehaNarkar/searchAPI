package com.service.core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParserUtil 
{
JSONObject jsonObject;
	
	public JsonParserUtil (String Json) throws ParseException{
		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject) parser.parse(Json);
	}
	
	public int getResultCount() {
		return Integer.parseInt(jsonObject.get("Count").toString());
	}
	
	public JSONArray getResults(){
		return (JSONArray) jsonObject.get("results"); 
	}

}
