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
}

class Room implements DataModel {

    private final String roomId, homeId;
    private final List<String> userIdList, deviceIdList;

    Room(String roomId, String homeId) {
        this.roomId = roomId;
        this.homeId = homeId;
        userIdList = new ArrayList<>();
        deviceIdList = new ArrayList<>();
    }

    public void addUser(String userId) {
        userIdList.add(userId);
    }

    public void addDevice(String deviceId) {
        deviceIdList.add(deviceId);
    }

    public List<String> getDeviceIdList() {
        return deviceIdList;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getHomeId() {
        return homeId;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}