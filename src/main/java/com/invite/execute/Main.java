package com.invite.execute;

import com.invite.model.Customer;
import com.invite.service.InvitationService;
import com.parser.NestedArrayParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amit
 */
public class Main {

    public static void main(String... args) {
        InvitationService invitationService = new InvitationService();
        NestedArrayParser arrayParser = new NestedArrayParser();
        List<Object> list = new ArrayList<Object>(Arrays.asList(Arrays.asList(1, 2, Arrays.asList(3)), 4));
        try {
            List<Customer> customers = invitationService.sendInvite(args[0]);
            System.out.print("Invited Guests : \n");
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }
            System.out.print("\n\nFlatten Array for [[1,2,[3]],4] : ");
            System.out.print("[");
            for(Integer i : arrayParser.parse(list)) {
                System.out.print(i + " ");
            }
            System.out.print("]\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
