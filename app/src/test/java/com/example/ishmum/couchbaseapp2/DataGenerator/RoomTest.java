package com.example.ishmum.couchbaseapp2.DataGenerator;

import com.example.ishmum.couchbaseapp2.RandomGenerator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class RoomTest {

    private RandomGenerator randomGenerator;
    private Room room;
    private String homeId;

    @Before
    public void setUp() throws Exception {
        randomGenerator = new RandomGenerator();
        homeId = generateString();
        room = new Room(homeId);
    }

    @Test
    public void addUser() throws Exception {
        final String user1 = generateString(),
                user2 = generateString(),
                user3 = generateString();

        room.addUser(user1);
        assertTrue(room.getUserIdList().contains(user1));

        room.addUser(user2);
        assertTrue(room.getUserIdList().contains(user2));

        room.addUser(user3);
        assertTrue(room.getUserIdList().contains(user3));
    }

    @Test
    public void removeUser() throws Exception {
        final String user1 = generateString(),
                user2 = generateString(),
                user3 = generateString();
        room.addUser(user1);
        room.addUser(user2);
        room.addUser(user3);

        assertTrue(room.getUserIdList().contains(user1));
        room.removeUser(user1);
        assertFalse(room.getUserIdList().contains(user1));

        assertTrue(room.getUserIdList().contains(user2));
        room.removeUser(user2);
        assertFalse(room.getUserIdList().contains(user2));

        assertTrue(room.getUserIdList().contains(user3));
        room.removeUser(user3);
        assertFalse(room.getUserIdList().contains(user3));
    }

    @Test
    public void addDevice() throws Exception {
        final String deviceId = generateString();

        assertTrue(room.getDeviceIdList().size() == 0);

        room.addDevice(deviceId);

        assertTrue(room.getDeviceIdList().size() == 1);
        assertTrue(room.getDeviceIdList().get(0).equals(deviceId));
    }

    @Test
    public void removeDevice() throws Exception {
        addDevice();

        final String deviceId = randomGenerator.getRandomNumberStr();
        room.addDevice(deviceId);

        assertTrue(room.getDeviceIdList().size() == 2);
        assertTrue(room.getDeviceIdList().get(1).equals(deviceId));

        room.removeDevice(deviceId);

        assertTrue(room.getDeviceIdList().size() == 1);
        assertFalse(room.getDeviceIdList().contains(deviceId));
    }

    @Test
    public void getDeviceIdList() throws Exception {
        assertTrue(room.getDeviceIdList().size() == 0);
    }

    @Test
    public void getHomeId() throws Exception {
        assertTrue(homeId == room.getHomeId());
    }

    @Test
    public void getUserIdList() throws Exception {
        assertTrue(0 == room.getUserIdList().size());
    }

    @Test
    public void test_toString() throws Exception {
        final String deviceId1 = generateString(),
                deviceId2 = generateString(),
                userId1 = generateString(),
                userId2 = generateString(),

                roomString1 = "{" +
                        "'homeId':'" + homeId + "'," +
                        "'userIdList':[]," +
                        "'deviceIdList':[]" +
                        "}",

                roomString2 = "{" +
                        "'homeId':'" + homeId + "'," +
                        "'userIdList':[\"" + userId1 + "\",\"" + userId2 + "\"]," +
                        "'deviceIdList':[\"" + deviceId1 + "\",\"" + deviceId2 + "\"]" +
                        "}",

                roomString3 = "{" +
                        "'homeId':'" + homeId + "'," +
                        "'userIdList':[\"" + userId1 + "\"]," +
                        "'deviceIdList':[\"" + deviceId1 + "\"]" +
                        "}";

        assertTrue(roomString1.equals(room.toString()));

        room.addUser(userId1);
        room.addUser(userId2);
        room.addDevice(deviceId1);
        room.addDevice(deviceId2);

        assertTrue(roomString2.equals(room.toString()));

        room.removeUser(userId2);
        room.removeDevice(deviceId2);

        assertTrue(roomString3.equals(room.toString()));
    }

    @Test
    public void getJSON() throws Exception {

    }

    private String generateString() {
        return randomGenerator.getRandomNumberStr();
    }
}