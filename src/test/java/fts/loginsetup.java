package fts;

import healthy.com.user;
import io.cucumber.java.en.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class loginsetup {
    private String username;
    private String password;



    public user newuser;




    @Given("user is connected to the database")
    public void user_is_connected_to_the_database() {
        newuser = new user();

    }

    @When("he fills in {string} with {string} for login")
    public void he_fills_in_with_for_login(String string, String string2) {
        if(string.equals("registernumber"))
            username = string2;
        else
            password = string2;
    }

    @When("user clicks on login")
    public void user_clicks_on_login() {
        newuser.login(username, password);
    }

    @Then("user should see {string} for login")
    public void user_should_see_for_login(String string) {
        assertEquals(string,newuser.getStatus());
    }


}