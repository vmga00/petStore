package com.petstore.api.tests;

import com.petstore.api.helpers.UserServiceHelpers;
import com.petstore.api.models.User;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class Test_User {
    private UserServiceHelpers userServiceHelpers;
    private User user;

    @BeforeClass
    private void init(){
        userServiceHelpers = new UserServiceHelpers();
        user = new User();
        int id = 11;
        user.setId(id);
        user.setUsername("vicman"+id);
        user.setFirstName("vic"+id);
        user.setLastName("man"+id);
        user.setEmail("mail@email.com");
        user.setPassword("123");
        user.setPhone("12345");
        user.setUserStatus(1);
    }

    @Test
    public void test_CREATE_USER(){
        Response result = userServiceHelpers.createUser(user);

        assertEquals(200,result.statusCode());
    }

    @Test
    public void test_GET_USER_BY_USERNAME(){
        Response result = userServiceHelpers.getUserByUserName("vicman11");
        result.print();
    }

    @Test
    public void test_USER_LOGIN(){
        Response result = userServiceHelpers.userLogin("vicman11", "123");
        result.print();
    }

    @Test
    public void test_USER_LOGOUT(){
        Response result = userServiceHelpers.userLogin("vicman11", "123");
        result.print();
        System.out.println();
        result = userServiceHelpers.userLogout();
        result.print();
    }

    @Test
    public void test_DELETE_USER(){
        //user exit? delete : create & delete
        Response result = userServiceHelpers.getUserByUserName(user.getUsername());
        result.prettyPrint();
        if(result.getStatusCode()==200){
            result = userServiceHelpers.deleteUser(user.getUsername());
        }else{
            System.out.println("\nUser not found, creating one..");
            userServiceHelpers.createUser(user);
            System.out.println("\nUser created, starting deleting process for " + user.getUsername());
            userServiceHelpers.getUserByUserName(user.getUsername());
            userServiceHelpers.deleteUser(user.getUsername());
            System.out.println("\nVerify " + user.getUsername() + " was deleted...");
            userServiceHelpers.getUserByUserName(user.getUsername());
        }
        result.prettyPrint();
    }

}
