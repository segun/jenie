/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinisoftinc.jenie.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trinisoftinc
 */
public class HelperTest {

    public HelperTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInputStreamContents method, of class Helper.
     */
    @Test
    public void testGetInputStreamContents() throws Exception {
        System.out.println("getInputStreamContents");
        InputStream is = null;
        String expResult = "";
        String result = Helper.getInputStreamContents(is);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of format method, of class Helper.
     */
    @Test
    public void testFormat() {
        System.out.println("format");
        String input = "";
        String contentType = "";
        String expResult = "";
        String result = Helper.format(input, contentType);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNodeFromMap method, of class Helper.
     */
    @Test
    public void testGetNodeFromMap() {
        System.out.println("getNodeFromMap");
        HashMap map = null;
        DefaultMutableTreeNode node = null;
        Helper.getNodeFromMap(map, node);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNodeFromList method, of class Helper.
     */
    @Test
    public void testGetNodeFromList() {
        System.out.println("getNodeFromList");
        ArrayList list = null;
        DefaultMutableTreeNode node = null;
        Helper.getNodeFromList(list, node);
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseMap method, of class Helper.
     */
    @Test
    public void testParseMap() {
        System.out.println("parseMap");
        HashMap map = null;
        String expResult = "";
        String result = Helper.parseMap(map);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseArray method, of class Helper.
     */
    @Test
    public void testParseArray() {
        System.out.println("parseArray");
        ArrayList list = null;
        String expResult = "";
        String result = Helper.parseArray(list);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMapFromJSONObject method, of class Helper.
     */
    @Test
    public void testGetMapFromJSONObject() throws Exception {
        System.out.println("getMapFromJSONObject");
        JSONObject object = null;
        HashMap expResult = null;
        HashMap result = Helper.getMapFromJSONObject(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListFromJSONArray method, of class Helper.
     */
    @Test
    public void testGetListFromJSONArray() throws Exception {
        System.out.println("getListFromJSONArray");
        JSONArray array = null;
        ArrayList expResult = null;
        ArrayList result = Helper.getListFromJSONArray(array);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}