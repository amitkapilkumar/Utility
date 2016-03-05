package com.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amit
 */
public class NestedArrayParserTest {

    private NestedArrayParser nestedArrayParser;

    @Before
    public void setup() {
        nestedArrayParser = new NestedArrayParser();
    }

    @Test
    public void itShouldMatchTheExpectedList() {
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4);
        List<Object> list = new ArrayList<Object>(Arrays.asList(Arrays.asList(1, 2, Arrays.asList(3)), 4));
        List<Integer> actualList = nestedArrayParser.parse(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void itShouldMatchTheExpectedListForRepeatedValues() {
        List<Integer> expectedList = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Object> list = new ArrayList<Object>(Arrays.asList(Arrays.asList(1, 2, Arrays.asList(2), Arrays.asList(3), Arrays.asList(3, 3)), 4));
        List<Integer> actualList = nestedArrayParser.parse(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void itShouldMatchTheExpectedListForNegativeNumbers() {
        List<Integer> expectedList = Arrays.asList(1, 2, 2, 3, 3, 3, 4, -4 , -10, -3, -4, 7 ,8);
        List<Object> list = new ArrayList<Object>(Arrays.asList(Arrays.asList(1, 2, Arrays.asList(2), Arrays.asList(3), Arrays.asList(3, 3)), 4, Arrays.asList(-4, -10), Arrays.asList(-3, -4, 7, 8)));
        List<Integer> actualList = nestedArrayParser.parse(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void itShouldMatchTheExpectedListForDeepNestedArrays() {
        List<Integer> expectedList = Arrays.asList(1, 2);
        List<Object> list = new ArrayList<Object>(Arrays.asList(Arrays.asList(Arrays.asList(Arrays.asList(Arrays.asList(Arrays.asList(Arrays.asList(1), 2)))))));
        List<Integer> actualList = nestedArrayParser.parse(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void itShouldMatchTheExpectedListForNullList() {
        List<Integer> expectedList = new ArrayList<Integer>();
        List<Integer> actualList = nestedArrayParser.parse(null);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void itShouldMatchTheExpectedListForEmptyList() {
        List<Integer> expectedList = new ArrayList<Integer>();
        List<Integer> actualList = nestedArrayParser.parse(new ArrayList<Object>());
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }
}