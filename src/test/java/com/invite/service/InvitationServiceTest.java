package com.invite.service;

import com.invite.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Amit
 */
public class InvitationServiceTest {

    private InvitationService invitationService;

    @Before
    public void setup() {
        invitationService = new InvitationService();
    }

    @Test
    public void itShouldInviteNearestCustomer() {
        List<Customer> list = null;
        try {
            list = invitationService.sendInvite("customer.text");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 16);
    }

    @Test
    public void itShouldValidateNull() {
        List<Customer> list = null;
        try {
            list = invitationService.sendInvite(null);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void itShouldValidateEmptyFilePath() {
        List<Customer> list = null;
        try {
            list = invitationService.sendInvite("");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void itShouldValidateNonExistingFile() {
        List<Customer> list = null;
        try {
            list = invitationService.sendInvite("xyz.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 0);
    }
}
