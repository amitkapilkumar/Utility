package com.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amit
 */
public class NestedArrayParser {

    public List<Integer> parse(List<Object> list) {
        List<Integer> result = new ArrayList<Integer>();
        if(list == null)
            return result;

        for(Object obj : list) {
            if(obj instanceof Integer) {
                result.add((Integer) obj);
            }
            else {
                result.addAll(parse((List) obj));
            }
        }
        return result;
    }
}
