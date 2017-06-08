package com.example.ishmum.couchbaseapp2.DataGenerator;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

class Home extends DataModel {

    private final String passPhrase;
    private final List<String> userIdList, roomIdList, deviceIdList;

    Home(String passPhrase) {
        this.passPhrase = passPhrase;
        userIdList = new ArrayList<>();
        roomIdList = new ArrayList<>();
        deviceIdList = new ArrayList<>();
    }

    public String getPassPhrase() {
        return passPhrase;
    }

    public void removeUser(String userId) {
        userIdList.remove(userId);
    }

    public void removeRoom(String roomId) {
        roomIdList.remove(roomId);
    }

    public void removeDevice(String deviceId) {
        deviceIdList.remove(deviceId);
    }


    public List<String> getUserIdList() {
        return userIdList;
    }

    public List<String> getRoomIdList() {
        return roomIdList;
    }

    public List<String> getDeviceIdList() {
        return deviceIdList;
    }

    public void addUser(String userId) {
        userIdList.add(userId);
    }

    public void addRoom(String roomId) {
        roomIdList.add(roomId);
    }

    public void addDevice(String deviceId) {
        deviceIdList.add(deviceId);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return "{" +
                "'passPhrase':'" + passPhrase + "'," +
                "'userIdList':'" + DataModelEssentials.getJsonArray(userIdList) + "'," +
                "'roomIdList':'" + DataModelEssentials.getJsonArray(roomIdList) + "'," +
                "'deviceIdList':'" + DataModelEssentials.getJsonArray(deviceIdList) + "'" +
                "}";
    }
}