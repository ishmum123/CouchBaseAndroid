package com.example.ishmum.couchbaseapp2.DataGenerator;

import com.example.ishmum.couchbaseapp2.RandomGenerator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class HomeTest {

    private RandomGenerator randomGenerator;
    private String passPhrase;
    private Home home;

    @Before
    public void setUp() throws Exception {
        randomGenerator = new RandomGenerator();
        passPhrase = generateString();
        home = new Home(passPhrase);
    }

    @Test
    public void getPassPhrase() throws Exception {
        assertTrue(passPhrase == home.getPassPhrase());
    }

    @Test
    public void removeUser() throws Exception {
        final String user1 = generateString(),
                user2 = generateString(),
                user3 = generateString();
        home.addUser(user1);
        home.addUser(user2);
        home.addUser(user3);

        assertTrue(home.getUserIdList().contains(user1));
        home.removeUser(user1);
        assertFalse(home.getUserIdList().contains(user1));

        assertTrue(home.getUserIdList().contains(user2));
        home.removeUser(user2);
        assertFalse(home.getUserIdList().contains(user2));

        assertTrue(home.getUserIdList().contains(user3));
        home.removeUser(user3);
        assertFalse(home.getUserIdList().contains(user3));
    }

    private String generateString() {
        return randomGenerator.getRandomNumberStr();
    }

    @Test
    public void removeRoom() throws Exception {
        addRoom();

        final String roomId = randomGenerator.getRandomNumberStr();
        home.addRoom(roomId);

        assertTrue(home.getRoomIdList().size() == 2);
        assertTrue(home.getRoomIdList().get(1).equals(roomId));

        home.removeRoom(roomId);

        assertTrue(home.getRoomIdList().size() == 1);
        assertFalse(home.getRoomIdList().contains(roomId));

    }

    @Test
    public void removeDevice() throws Exception {
        addDevice();

        final String deviceId = randomGenerator.getRandomNumberStr();
        home.addDevice(deviceId);

        assertTrue(home.getDeviceIdList().size() == 2);
        assertTrue(home.getDeviceIdList().get(1).equals(deviceId));

        home.removeDevice(deviceId);

        assertTrue(home.getDeviceIdList().size() == 1);
        assertFalse(home.getDeviceIdList().contains(deviceId));
    }

    @Test
    public void getUserIdList() throws Exception {
        assertTrue(0 == home.getUserIdList().size());
    }

    @Test
    public void getRoomIdList() throws Exception {
        assertTrue(home.getRoomIdList().size() == 0);
    }

    @Test
    public void getDeviceIdList() throws Exception {
        assertTrue(home.getDeviceIdList().size() == 0);
    }

    @Test
    public void addUser() throws Exception {
        final String user1 = generateString(),
                user2 = generateString(),
                user3 = generateString();

        home.addUser(user1);
        assertTrue(home.getUserIdList().contains(user1));

        home.addUser(user2);
        assertTrue(home.getUserIdList().contains(user2));

        home.addUser(user3);
        assertTrue(home.getUserIdList().contains(user3));
    }

    @Test
    public void addRoom() throws Exception {
        final String roomId = randomGenerator.getRandomNumberStr();

        assertTrue(home.getRoomIdList().size() == 0);

        home.addRoom(roomId);

        assertTrue(home.getRoomIdList().size() == 1);
        assertTrue(home.getRoomIdList().get(0).equals(roomId));
    }

    @Test
    public void addDevice() throws Exception {
        final String deviceId = generateString();

        assertTrue(home.getDeviceIdList().size() == 0);

        home.addDevice(deviceId);

        assertTrue(home.getDeviceIdList().size() == 1);
        assertTrue(home.getDeviceIdList().get(0).equals(deviceId));
    }

    @Test
    public void test_toString() throws Exception {

    }

    @Test
    public void getJSON() throws Exception {

    }
}