/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinisoftinc.jenie.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author trinisoftinc
 */
public class Helper {
    public static String getInputStreamContents(InputStream is) throws IOException {
        String retval = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = "";
        StringBuilder builder = new StringBuilder();
        while((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        retval = builder.toString();
        return retval;
    }
    
    public static String parseMap(HashMap map) {   
        String output = "<table border='1' cellpadding='10'>";
        Iterator<String> ite = map.keySet().iterator();
        while(ite.hasNext()) {             
            output += "<tr>";
            String key = ite.next();
            Object value = map.get(key);
            if(value instanceof ArrayList) {
                output += "<td><b>" + key.replace("\"", "") + "</b></td>";                
                output += "<td>" + parseArray((ArrayList) value) + "</td>";
            } else if(value instanceof HashMap) {
                output += "<td><b>" + key.replace("\"", "") + "</b></td>";
                output += "<td>" + parseMap((HashMap) value) + "</td>";
            } else {
                output += "<td><b>" + key.replace("\"", "") + "</b></td>";
                output += "<td>" + value.toString().replace("\"", "") + "</td>";
            }
            output += "</tr>";            
        }      
        output += "</table>";
        return output;
    }
    
    public static String parseArray(ArrayList list) {
        String output = "<table border='1' cellpadding='10'>";
        ListIterator ite = list.listIterator();
        while(ite.hasNext()) {
            output += "<tr>";
            Object value = ite.next();
            if(value instanceof ArrayList) {
                output += "<td><b>" + parseArray((ArrayList) value)+ "</b></td>";                
            } else if(value instanceof HashMap) {
                output += "<td><b>" + parseMap((HashMap) value) + "</b></td>";
            } else {
                output += "<td><b>" + value.toString().replace("\"", "") + "</b></td>";
            }
        }
        output += "</table>";
        return output;
    }
}
