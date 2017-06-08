package com.example.ishmum.couchbaseapp2.DataGenerator;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

class Room extends DataModel {

    private final String homeId;
    private final List<String> userIdList, deviceIdList;

    Room(String homeId) {
        this.homeId = homeId;
        userIdList = new ArrayList<>();
        deviceIdList = new ArrayList<>();
    }

    public void addUser(String userId) {
        userIdList.add(userId);
    }

    public void removeUser(String userId) {
        userIdList.remove(userId);
    }

    public void addDevice(String deviceId) {
        deviceIdList.add(deviceId);
    }

    public void removeDevice(String deviceId) {
        deviceIdList.remove(deviceId);
    }

    public List<String> getDeviceIdList() {
        return deviceIdList;
    }

    public String getHomeId() {
        return homeId;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return "{" +
                "'homeId':'" + homeId + "'," +
                "'userIdList':" + DataModelEssentials.getJsonArray(userIdList) + "," +
                "'deviceIdList':" + DataModelEssentials.getJsonArray(deviceIdList) +
                "}";
    }
}