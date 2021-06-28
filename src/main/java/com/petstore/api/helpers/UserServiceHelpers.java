package com.petstore.api.helpers;

import com.petstore.api.constants.EndPoints;
import com.petstore.api.models.User;
import io.restassured.response.Response;

public class UserServiceHelpers extends com.petstore.api.utils.Utils {

    public UserServiceHelpers() {
        initialize();
    }

    public Response createUser(User user) {
        return post(EndPoints.CREATE_USER, user);
    }

    public Response getUserByUserName(String userName) {
        return get(EndPoints.GET_USER_BY_USERNAME, userName);
    }

    public Response userLogin(String userName, String password) {
        String query = "username=" + userName;
        query += "&password=" + password;
        return get(EndPoints.USER_LOGIN, query);
    }

    public Response userLogout() {
        return get(EndPoints.USER_LOGOUT, "");
    }

    public Response deleteUser(String username) {
        return remove(EndPoints.GET_USER_BY_USERNAME, username);
    }

}
