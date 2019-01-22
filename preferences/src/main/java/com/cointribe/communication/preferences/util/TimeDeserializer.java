package com.cointribe.communication.preferences.util;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TimeDeserializer extends JsonDeserializer<Time> {

    @Override
    public Time deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
       
    	DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;
    
    	LocalTime local =LocalTime.parse(jp.getText(), formatter);
    	
    	Time tme=Time.valueOf(local);

         return tme;
    }

}
