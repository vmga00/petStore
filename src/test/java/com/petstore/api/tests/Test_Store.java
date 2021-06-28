package com.petstore.api.tests;

import com.petstore.api.helpers.StoreServiceHelpers;
import com.petstore.api.models.Order;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Store {
    private StoreServiceHelpers storeServiceHelpers;
    Order order;

    @BeforeClass
    private void init() {
        storeServiceHelpers = new StoreServiceHelpers();
        order = new Order();
        order.setId(100);
        order.setPetId(1000);
        order.setQuantity(5);
        order.setShipDate("2021-06-28T16:01:45.616Z");
        order.setStatus("approved");
        order.setComplete(true);
    }

    @Test
    public void test_store_PLACE_ORDER() {
        Response result = storeServiceHelpers.setOrder(order);
        result.prettyPeek();
    }

    @Test
    public void test_store_GET_ORDER_BY_ID() {
        Response result = storeServiceHelpers.getOrderById(order.getId().toString());
        result.prettyPeek();
    }

    @Test
    public void test_store_DELETE_ORDER() {
        Response result = storeServiceHelpers.getOrderById(order.getId().toString());
        if (result.getStatusCode() == 200) {
            System.out.println("Order found, deleting...");
            result = storeServiceHelpers.deleteOrder(order.getId().toString());
        } else {
            System.out.println("Order not found, creating order...");
            storeServiceHelpers.setOrder(order);
            System.out.println("Order created, attempting to delete it...");
            storeServiceHelpers.deleteOrder(order.getId().toString());
            storeServiceHelpers.getOrderById(order.getId().toString());
        }
        result.prettyPeek();
    }
}
