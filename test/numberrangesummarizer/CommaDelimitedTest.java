/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Franco
 */
public class CommaDelimitedTest {

    public CommaDelimitedTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class CommaDelimited.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CommaDelimited.main(args);
    }

    /**
     * Test of collect method, of class CommaDelimited.
     */
    @Test
    public void testCollect() {
        System.out.println("collect");
        String input = "15,3,6,7,8,125,13,14,15,21";
        CommaDelimited instance = new CommaDelimited();
        Collection<Integer> result = instance.collect(input);
        assertEquals(Arrays.asList(3, 6, 7, 8, 13, 14, 15, 15, 21, 125), result);
    }

    /**
     * Test of summarizeCollection method, of class CommaDelimited.
     */
    @Test
    public void testSummarizeCollection() {
        System.out.println("summarizeCollection");
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21);
        CommaDelimited instance = new CommaDelimited();
        String expResult = "1, 3, 6-8, 12-15, 21";
        String result = instance.summarizeCollection(input);
        assertEquals(expResult, result);;
    }

}
