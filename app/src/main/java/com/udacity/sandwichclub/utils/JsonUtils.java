package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {


        JSONObject  sandwichObject = new JSONObject(json);
        JSONObject  nameObject = new JSONObject(sandwichObject.getString("name"));

        Sandwich sandwich = new Sandwich();

        sandwich.setMainName(nameObject.getString("mainName"));

        JSONArray alsoKnownAsArray = (JSONArray) nameObject.getJSONArray("alsoKnownAs");
        ArrayList<String> alsoKnownAsList = new ArrayList<String>();
        for (int i=0; i < alsoKnownAsArray.length(); i++) {
            alsoKnownAsList.add(alsoKnownAsArray.getString(i));
        }
        sandwich.setAlsoKnownAs(alsoKnownAsList);

        sandwich.setDescription(sandwichObject.getString("description"));

        sandwich.setImage(sandwichObject.getString("image"));

        JSONArray ingredientsArray = (JSONArray) sandwichObject.getJSONArray("ingredients");
        ArrayList<String> ingredientsList = new ArrayList<String>();
        for (int i=0; i < ingredientsArray.length(); i++) {
            ingredientsList.add(ingredientsArray.getString(i));
        }
        sandwich.setIngredients(ingredientsList);

        sandwich.setPlaceOfOrigin(sandwichObject.getString("placeOfOrigin"));

        return sandwich;
    }
}
