package com.example.ishmum.couchbaseapp2.DataGenerator;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

interface DataModel {
    String toString();
}

class Device implements DataModel {

    private final String deviceHash;
    private String roomId, homeId, configData, usage, usageTimeStamp, presetData;
    private final List<String> userIdList;

    Device(String deviceHash) {
        this.deviceHash = deviceHash;
        userIdList = new ArrayList<>();
    }

    public void removeUser(String userId) {
        userIdList.remove(userId);
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void addUser(String userId) {
        userIdList.add(userId);
    }

    public String getDeviceHash() {
        return deviceHash;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    public String getConfigData() {
        return configData;
    }

    public void setConfigData(String configData) {
        this.configData = configData;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getUsageTimeStamp() {
        return usageTimeStamp;
    }

    public void setUsageTimeStamp(String usageTimeStamp) {
        this.usageTimeStamp = usageTimeStamp;
    }

    public String getPresetData() {
        return presetData;
    }

    public void setPresetData(String presetData) {
        this.presetData = presetData;
    }

    @Override
    public String toString() {
        return "{"
                + "'deviceHash' : '" + deviceHash + "',"
                + "'roomId' : '" + roomId + "',"
                + "'homeId' : '" + homeId + "',"
                + "'configData' : '" + configData + "',"
                + "'usage' : '" + usage + "',"
                + "'usageTimeStamp' : '" + usageTimeStamp + "',"
                + "'presetData' : '" + presetData + "',"
                + "'userIdList' : '" + new Gson().toJson(userIdList) + "'"
                + "}";
    }
}

class User implements DataModel {

    private final String name, email;
    private String role, expireAt;
    private final List<String> homeIdList, roomIdList, deviceIdList;

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

    User(String name, String email) {
        this.name = name;
        this.email = email;
        homeIdList = new ArrayList<>();
        roomIdList = new ArrayList<>();
        deviceIdList = new ArrayList<>();
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return "{" +
                "'name':'" + name + "'," +
                "'email':'" + email + "'," +
                "'role':'" + role + "'," +
                "'expireAt':'" + expireAt + "'," +
                "'homeIdList':'" + gson.toJson(homeIdList) + "'," +
                "'roomIdList':'" + gson.toJson(roomIdList) + "'," +
                "'deviceIdList':'" + gson.toJson(deviceIdList) + "'" +
                "}";
    }
}

class Home implements DataModel {

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
                "'userIdList':'" + gson.toJson(userIdList) + "'," +
                "'roomIdList':'" + gson.toJson(roomIdList) + "'," +
                "'deviceIdList':'" + gson.toJson(deviceIdList) + "'" +
                "}";
    }
}

class Room implements DataModel {

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
                "'userIdList':'" + gson.toJson(userIdList) + "'," +
                "'deviceIdList':'" + gson.toJson(deviceIdList) + "'" +
                "}";
    }
}