package com.example.ishmum.couchbaseapp2.DataGenerator;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.example.ishmum.couchbaseapp2.RandomGenerator;

import java.util.HashMap;
import java.util.Map;

public class DataGenerationManager {

    final RandomGenerator randomGenerator;
    private final Database database;

    public DataGenerationManager(Database database) {
        randomGenerator = new RandomGenerator();
        this.database = database;
    }

    void addDeviceToRoom(Device device, String deviceId, Room room, String roomId) {
        room.addDevice(deviceId);
        device.setRoomId(roomId);
    }

    void removeDeviceFromRoom(Device device, String deviceId, Room room, String roomId) {
        device.setRoomId("");
        room.removeDevice(deviceId);
    }

    Document createDevice(String deviceId, String deviceHash) {
        Map<String, Object> map = new HashMap<>();
        map.put(deviceId, new Device(deviceHash).getJSON());
        return createDocument(deviceId, map);
    }

    Document createHome(String homeId, String passPhrase) {
        Map<String, Object> map = new HashMap<>();
        map.put(homeId, new Home(passPhrase).getJSON());
        return createDocument(homeId, map);
    }

    Document createUser(String userId, String name, String email) {
        Map<String, Object> map = new HashMap<>();
        map.put(userId, new User(name, email).getJSON());
        return createDocument(userId, map);
    }

    Document createRoom(String roomId, String homeId) {
        Map<String, Object> map = new HashMap<>();
        map.put(roomId, new Room(homeId).getJSON());
        return createDocument(roomId, map);
    }

    private Document createDocument(String id, Map<String, Object> map) {
        Document document = database.getDocument(id);
        try { document.putProperties(map); }
        catch (CouchbaseLiteException e) { e.printStackTrace(); }
        return document;
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
