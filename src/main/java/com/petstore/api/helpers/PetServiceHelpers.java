package com.petstore.api.helpers;

import com.petstore.api.constants.EndPoints;
import com.petstore.api.models.Category;
import com.petstore.api.models.Pet;
import com.petstore.api.models.Tag;
import com.petstore.api.utils.RequestHelper;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PetServiceHelpers extends RequestHelper {
    public PetServiceHelpers() {
        initialize();
    }

    public Response setPet(Pet pet) {
        return post(EndPoints.CREATE_PET, pet);
    }

    public Response getPetById(String id) {
        return get(EndPoints.GET_PET_BY_ID, id);
    }

    public Response deletePet(String id) {
        return remove(EndPoints.DELETE_PET, id);
    }

    public Response updatePet(JSONObject json) {
        return update(EndPoints.UPDATE_PET, json);
    }

    public JSONObject petToJson(Pet pet) {
        JSONObject jsonPet = new JSONObject();
        jsonPet.put("id", pet.getId());
        jsonPet.put("name", pet.getName());
        jsonPet.put("category:", categoryToJson(pet.getCategory()));
        jsonPet.put("photoUrls", pet.getPhotoUrls());

        List<String> tags = new ArrayList<String>();
        for(Tag tag : pet.getTags()){
            tags.add(tagToJson(tag).toString());
        }
        jsonPet.put("tags", tags);
        jsonPet.put("status", pet.getStatus());

        return jsonPet;
    }


    private JSONObject tagToJson(Tag tag) {
        JSONObject jsonTag = new JSONObject();
        jsonTag.put("id", tag.getId());
        jsonTag.put("name", tag.getName());
        return jsonTag;
    }

    private JSONObject categoryToJson(Category category) {
        JSONObject jsonCategory = new JSONObject();
        jsonCategory.put("id", category.getId());
        jsonCategory.put("name", category.getName());
        return jsonCategory;
    }


}
