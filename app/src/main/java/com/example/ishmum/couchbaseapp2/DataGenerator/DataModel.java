package com.example.ishmum.couchbaseapp2.DataGenerator;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public abstract class DataModel {

    public abstract String toString();

    JSONObject getJSON() {
        return DataModelEssentials.getJSONOBject(toString());
    }
}

class DataModelEssentials {

    private static final Gson gson = new Gson();

    static String getJsonArray(List<String> stringList) {
        return gson.toJson(stringList);
    }

    static JSONObject getJSONOBject(String s) {
        try { return new JSONObject(s); }
        catch (JSONException e) { return new JSONObject(); }
    }
}