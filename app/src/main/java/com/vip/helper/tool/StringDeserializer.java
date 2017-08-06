package com.vip.helper.tool;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class StringDeserializer implements JsonDeserializer<String> {
	 @Override
	  public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	      throws JsonParseException
	  {
		  if("null".equals(json.getAsString())){
			  return "";
		  }
	    if (json.isJsonPrimitive()) return json.getAsString();
	    return "";
	  }
}
