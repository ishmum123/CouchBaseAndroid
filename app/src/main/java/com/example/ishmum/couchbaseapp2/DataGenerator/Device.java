package com.example.ishmum.couchbaseapp2.DataGenerator;


import java.util.ArrayList;
import java.util.List;

class Device extends DataModel {

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
                + "'userIdList' : " + DataModelEssentials.getJsonArray(userIdList)
                + "}";
    }
}

