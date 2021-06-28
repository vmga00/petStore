package com.petstore.api.helpers;

import com.petstore.api.constants.EndPoints;
import com.petstore.api.models.Order;
import com.petstore.api.utils.RequestHelper;
import io.restassured.response.Response;

public class StoreServiceHelpers extends RequestHelper {

    public StoreServiceHelpers() {
        initialize();
    }

    public Response setOrder(Order order) {
        return post(EndPoints.SET_ORDER, order);
    }

    public Response getOrderById(String id) {
        return get(EndPoints.GET_ORDER_BY_ID, id);
    }


    public Response deleteOrder(String id) {
        return remove(EndPoints.DELETE_ORDER, id);
    }
}
