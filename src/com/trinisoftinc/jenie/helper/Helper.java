/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trinisoftinc.jenie.helper;

import com.trinisoftinc.jenie.Viewer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import javax.swing.tree.DefaultMutableTreeNode;

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
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        retval = builder.toString();

        return retval;
    }

    public static String format(String input, String contentType) {
        StringBuilder builder = new StringBuilder();
        System.out.println(contentType);
        if (contentType.equals("text/json")) {            
            String INDENT = "";
            int length = input.length();
            for (int i = 0; i < length; i++) {
                char ch = input.charAt(i);
                if (ch == '{' || ch == '[') {                    
                    builder.append("\n");
                    builder.append(INDENT);
                    builder.append(ch);
                    builder.append("\n");
                    INDENT += "\t";
                    builder.append(INDENT);
                } else if (ch == '}' || ch == ']') {
                    INDENT = INDENT.substring(0, INDENT.length() - 1);                    
                    builder.append("\n");
                    builder.append(INDENT);
                    builder.append(ch);    
                    //builder.append("\n");
                } else if(ch == ',') {
                    builder.append(ch);
                    builder.append("\n");
                    builder.append(INDENT);                                        
                } else {
                    builder.append(ch);
                }
            }
        } else {
            String INDENT = "";
            int length = input.length();
            for (int i = 0; i < length; i++) {
                char ch = input.charAt(i);                
                if(ch == '>') {
                    builder.append(ch);
                    builder.append("\n");
                } else if(ch == '<' && input.charAt(i + 1) == '/') {
                    builder.append("\n");
                    builder.append(ch);                                        
                } else {
                    builder.append(ch);
                }
            }
        }
        
        return builder.toString();
    }
    
    public static void getNodeFromMap(HashMap map, DefaultMutableTreeNode node) {
        Iterator<String> ite = map.keySet().iterator();
        while (ite.hasNext()) {
            String key = ite.next();
            Object value = map.get(key);
            if (value instanceof ArrayList) {
                DefaultMutableTreeNode keyNode = new DefaultMutableTreeNode(key.replace("\"", ""));
                getNodeFromList((ArrayList) value, keyNode);
                node.add(keyNode);
            } else if (value instanceof HashMap) {
                DefaultMutableTreeNode keyNode = new DefaultMutableTreeNode(key.replace("\"", ""));
                getNodeFromMap((HashMap) value, keyNode);
                node.add(keyNode);
            } else {
                DefaultMutableTreeNode keyNode = new DefaultMutableTreeNode(key.replace("\"", ""));
                DefaultMutableTreeNode valueNode = new DefaultMutableTreeNode(value.toString().replace("\"", ""));
                keyNode.add(valueNode);
                node.add(keyNode);
            }
        }
    }

    public static void getNodeFromList(ArrayList list, DefaultMutableTreeNode node) {
        ListIterator ite = list.listIterator();
        while (ite.hasNext()) {
            Object value = ite.next();
            if (value instanceof ArrayList) {
                getNodeFromList((ArrayList) value, node);
            } else if (value instanceof HashMap) {
                getNodeFromMap((HashMap) value, node);
            } else {
                node.add(new DefaultMutableTreeNode(value.toString().replace("\"", "")));
            }
        }
    }

    public static String parseMap(HashMap map) {
        String keyColorCode = Viewer.txtKCC.getText();
        if(keyColorCode == null || keyColorCode.equals("")) {
            keyColorCode = "#ffffff";
        }
        String valueColorCode = Viewer.txtVCC.getText();
        if(valueColorCode == null || valueColorCode.equals("")) {
            valueColorCode = "#ffffff";
        }
        
        String output = "<table border='1' cellpadding='10'>";
        Iterator<String> ite = map.keySet().iterator();
        while (ite.hasNext()) {
            output += "<tr>";
            String key = ite.next();
            Object value = map.get(key);
            if (value instanceof ArrayList) {
                output += "<td style='background-color: " + keyColorCode + "'><b>" + key.replace("\"", "") + "</b></td>";
                output += "<td style='background-color: " + valueColorCode + "'>" + parseArray((ArrayList) value) + "</td>";
            } else if (value instanceof HashMap) {
                output += "<td style='background-color: " + keyColorCode + "'><b>" + key.replace("\"", "") + "</b></td>";
                output += "<td style='background-color: " + valueColorCode + "'>" + parseMap((HashMap) value) + "</td>";
            } else {
                output += "<td style='background-color: " + keyColorCode + "'><b>" + key.replace("\"", "") + "</b></td>";
                output += "<td style='background-color: " + valueColorCode + "'>" + value.toString().replace("\"", "") + "</td>";
            }
            output += "</tr>";
        }
        output += "</table>";
        return output;
    }

    public static String parseArray(ArrayList list) {
        String keyColorCode = Viewer.txtKCC.getText();
        if(keyColorCode == null || keyColorCode.equals("")) {
            keyColorCode = "#ffffff";
        }        
        String output = "<table border='1' cellpadding='10'>";
        ListIterator ite = list.listIterator();
        while (ite.hasNext()) {
            output += "<tr>";
            Object value = ite.next();
            if (value instanceof ArrayList) {
                output += "<td style='background-color: " + keyColorCode + "'><b>" + parseArray((ArrayList) value) + "</b></td>";
            } else if (value instanceof HashMap) {
                output += "<td style='background-color: " + keyColorCode + "'><b>" + parseMap((HashMap) value) + "</b></td>";
            } else {
                output += "<td style='background-color: " + keyColorCode + "'><b>" + value.toString().replace("\"", "") + "</b></td>";
            }
        }
        output += "</table>";
        return output;
    }
}
