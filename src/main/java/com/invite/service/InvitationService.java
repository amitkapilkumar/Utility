package com.invite.service;

import com.invite.io.FileProcessor;
import com.invite.model.Customer;
import com.invite.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Amit
 */
public class InvitationService {

    private DistanceCalculationService distanceCalculationService;
    private FileProcessor fileProcessor;

    public InvitationService() {
        distanceCalculationService = new DistanceCalculationService();
        fileProcessor = new FileProcessor();
    }

    public List<Customer> sendInvite(String filepath) throws IOException {
        List<Customer> customers = new ArrayList<Customer>();
        for(Customer customer : fileProcessor.parse(filepath)) {
            double distance = distanceCalculationService.distance(Constants.FIXED_LATITUDE, customer.getLatitude(), Constants.FIXED_LONGITUDE, customer.getLongitude());
            if(distance <= Constants.MAX_DISTANCE) {
                customers.add(customer);
            }
        }
        Collections.sort(customers);
        return customers;
    }
}
