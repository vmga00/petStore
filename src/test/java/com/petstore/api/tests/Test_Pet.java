package com.petstore.api.tests;

import com.petstore.api.helpers.PetServiceHelpers;
import com.petstore.api.models.Category;
import com.petstore.api.models.Pet;
import com.petstore.api.models.Tag;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_Pet {

    private PetServiceHelpers petServiceHelpers;
    Pet pet;

    @BeforeClass
    private void init(){
        petServiceHelpers = new PetServiceHelpers();

        Category category = new Category();
        category.setId(1);
        category.setName("Dogs");

        List<Tag> tags = new ArrayList<Tag>();
        Tag tag = new Tag(1, "string");
        tags.add(tag);

        List<String> photoUrls = new ArrayList<String>();
        photoUrls.add("string");

        pet = new Pet(12, "dodge", category, photoUrls, tags, "available");
    }

    @Test
    public void testUpdate(){
        Response result= petServiceHelpers.getPetById(pet.getId().toString());
        if(result.getStatusCode()==200){
            result.prettyPeek();
            System.out.println("\n\nPet found, updating...");
            pet.setName("dodges");
            petServiceHelpers.updatePet(petServiceHelpers.petToJson(pet));
            petServiceHelpers.getPetById(pet.getId().toString());
            result.prettyPeek();
        }else{}
    }


}
