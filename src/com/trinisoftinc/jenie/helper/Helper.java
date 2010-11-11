/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinisoftinc.jenie.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JTextPane;

/**
 *
 * @author trinisoftinc
 */
public class Helper {
    public static String getFileContents(File f) throws IOException {
        String retval = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line = "";
        StringBuilder builder = new StringBuilder();
        while((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        retval = builder.toString();
        return retval;
    }
    
    public static boolean displayMap(JTextPane pane, HashMap map) {
        String output = "<html><body>";
        output += "<h3>Json Dictionary Found</h3><hr/>";
        output += "<ul type='none'>";
        Iterator<String> ite = map.keySet().iterator();
        return true;
    }
    
    public static boolean parseArray(JTextPane pane) {
        return true;
    }
}
