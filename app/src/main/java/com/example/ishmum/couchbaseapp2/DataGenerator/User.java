package com.example.ishmum.couchbaseapp2.DataGenerator;


import java.util.ArrayList;
import java.util.List;

class User extends DataModel {

    private final String name, email;
    private String role, expireAt;
    private final List<String> homeIdList, roomIdList, deviceIdList;

    User(String name, String email) {
        this.name = name;
        this.email = email;
        homeIdList = new ArrayList<>();
        roomIdList = new ArrayList<>();
        deviceIdList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addHome(String homeId) {
        homeIdList.add(homeId);
    }

    public void addDevice(String deviceId) {
        deviceIdList.add(deviceId);
    }

    public void addRoom(String roomId) {
        roomIdList.add(roomId);
    }

    public void removeRoom(String roomId) {
        roomIdList.remove(roomId);
    }

    public void removeHome(String homeId) {
        homeIdList.remove(homeId);
    }

    public void removeDevice(String deviceId) {
        deviceIdList.remove(deviceId);
    }

    public String getRole() {
        return role;
    }

    public String getExpireAt() {
        return expireAt;
    }

    public List<String> getHomeIdList() {
        return homeIdList;
    }

    public List<String> getRoomIdList() {
        return roomIdList;
    }

    public List<String> getDeviceIdList() {
        return deviceIdList;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }

    @Override
    public String toString() {
        return "{" +
                "'name':'" + name + "'," +
                "'email':'" + email + "'," +
                "'role':'" + role + "'," +
                "'expireAt':'" + expireAt + "'," +
                "'homeIdList':'" + DataModelEssentials.getJsonArray(homeIdList) + "'," +
                "'roomIdList':'" + DataModelEssentials.getJsonArray(roomIdList) + "'," +
                "'deviceIdList':'" + DataModelEssentials.getJsonArray(deviceIdList) + "'" +
                "}";
    }
}