package fr.afcepf.al27.ticketshack.front.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseurJson {

	public static Object jsonToObject(String stringInput) {
		ObjectMapper mapper = new ObjectMapper();

		//BufferedReader br = null;
		String jsonInput = stringInput;
		String jsonFormate = "";
		Object o = new Object();
		jsonFormate = jsonInput.replaceAll("\"", "\\\"");
	
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			try {
				o = mapper.readValue(jsonFormate, new TypeReference<Object>() {});
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			return o;
		}

	public static String objectToJson(Object o) {
		ObjectMapper mapper = new ObjectMapper();
		String stringOutput = "";

		try {
			stringOutput = mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return stringOutput;
	}
}
