package com.example.ishmum.couchbaseapp2.DataGenerator;

import com.example.ishmum.couchbaseapp2.RandomGenerator;

import java.util.HashMap;
import java.util.Map;

public class DataGenerationManager {

    final RandomGenerator randomGenerator;

    public DataGenerationManager() {
        randomGenerator = new RandomGenerator();
    }

    void addDeviceToRoom(Device device, String deviceId, Room room, String roomId) {
        room.addDevice(deviceId);
        device.setRoomId(roomId);
    }

    void removeDeviceFromRoom(Device device, String deviceId, Room room, String roomId) {
        device.setRoomId("");
        room.removeDevice(deviceId);
    }

    Map<String, Device> createDevice() {
        Map<String, Device> map = new HashMap<>();
        map.put(generateString(), new Device(generateString()));
        return map;
    }

    Map<String, Home> createHome() {
        Map<String, Home> map = new HashMap<>();
        map.put(generateString(), new Home(generateString()));
        return map;
    }

    Map<String, User> createUser() {
        Map<String, User> map = new HashMap<>();
        map.put(generateString(), new User(generateString(), generateString()));
        return map;
    }

    Map<String, Room> createRoom(String homeId) {
        Map<String, Room> map = new HashMap<>();
        map.put(generateString(), new Room(homeId));
        return map;
    }

    void addUserToDevice(Device device, String deviceId, User user, String userId) {
        device.addUser(userId);
        user.addDevice(deviceId);
    }

    void addUserToRoom(Room room, String roomId, User user, String userId) {
        room.addUser(userId);
        user.addRoom(roomId);
    }

    void addUserToHome(Home home, String homeId, User user, String userId) {
        home.addUser(userId);
        user.addHome(homeId);
    }

    void removeUserFromDevice(Device device, String deviceId, User user, String userId) {
        device.removeUser(userId);
        user.removeRoom(deviceId);
    }

    void removeUserFromRoom(Room room, String roomId, User user, String userId) {
        room.removeUser(userId);
        user.removeRoom(roomId);
    }

    void removeUserFromHome(Home home, String homeId, User user, String userId) {
        home.removeUser(userId);
        user.removeHome(homeId);
    }

    private String generateString() {
        return randomGenerator.getRandomNumberStr();
    }

}
