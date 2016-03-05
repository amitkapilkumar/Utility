package com.invite.io;

import com.invite.model.Customer;
import com.invite.Constants;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amit
 */
public class FileProcessor {

    public List<Customer> parse(String filepath) throws IOException {
        List<Customer> customers = new ArrayList<Customer>();
        if(filepath == null || filepath.isEmpty()) {
            return customers;
        }

        File file = new File(filepath);
        if(!file.exists())
            return customers;

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            customers.add(mapToCustomerVO(jsonObject));
        }

        br.close();
        return customers;
    }

    private Customer mapToCustomerVO(JSONObject jsonObject) {
        return  new Customer(jsonObject.getLong(Constants.USERID),
                jsonObject.getString(Constants.NAME),
                Double.parseDouble(jsonObject.getString(Constants.LATITUDE)),
                Double.parseDouble(jsonObject.getString(Constants.LONGITUDE)));
    }
}
