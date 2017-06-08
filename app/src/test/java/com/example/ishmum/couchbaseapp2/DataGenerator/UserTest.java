package com.example.ishmum.couchbaseapp2.DataGenerator;

import com.example.ishmum.couchbaseapp2.RandomGenerator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class UserTest {

    private User user;
    private RandomGenerator randomGenerator;
    private String name, email;

    @Before
    public void setUp() throws Exception {
        randomGenerator = new RandomGenerator();
        name = randomGenerator.getRandomNumberStr();
        email = randomGenerator.getRandomNumberStr();
        user = new User(name, email);
    }

    @Test
    public void getName() throws Exception {
        assertTrue(user.getName().equals(name));
    }

    @Test
    public void getEmail() throws Exception {
        assertTrue(user.getEmail().equals(email));
    }

    @Test
    public void addHome() throws Exception {
        final String homeId = randomGenerator.getRandomNumberStr();

        assertTrue(user.getHomeIdList().size() == 0);

        user.addHome(homeId);

        assertTrue(user.getHomeIdList().size() == 1);
        assertTrue(user.getHomeIdList().get(0).equals(homeId));
    }

    @Test
    public void addDevice() throws Exception {
        final String deviceId = randomGenerator.getRandomNumberStr();

        assertTrue(user.getDeviceIdList().size() == 0);

        user.addDevice(deviceId);

        assertTrue(user.getDeviceIdList().size() == 1);
        assertTrue(user.getDeviceIdList().get(0).equals(deviceId));
    }

    @Test
    public void addRoom() throws Exception {
        final String roomId = randomGenerator.getRandomNumberStr();

        assertTrue(user.getRoomIdList().size() == 0);

        user.addRoom(roomId);

        assertTrue(user.getRoomIdList().size() == 1);
        assertTrue(user.getRoomIdList().get(0).equals(roomId));
    }

    @Test
    public void removeRoom() throws Exception {
        addRoom();

        final String roomId = randomGenerator.getRandomNumberStr();
        user.addRoom(roomId);

        assertTrue(user.getRoomIdList().size() == 2);
        assertTrue(user.getRoomIdList().get(1).equals(roomId));

        user.removeRoom(roomId);

        assertTrue(user.getRoomIdList().size() == 1);
        assertFalse(user.getRoomIdList().contains(roomId));
    }

    @Test
    public void removeHome() throws Exception {
        addHome();

        final String homeId = randomGenerator.getRandomNumberStr();
        user.addHome(homeId);

        assertTrue(user.getHomeIdList().size() == 2);
        assertTrue(user.getHomeIdList().get(1).equals(homeId));

        user.removeHome(homeId);

        assertTrue(user.getHomeIdList().size() == 1);
        assertFalse(user.getHomeIdList().contains(homeId));
    }

    @Test
    public void removeDevice() throws Exception {
        addDevice();

        final String deviceId = randomGenerator.getRandomNumberStr();
        user.addDevice(deviceId);

        assertTrue(user.getDeviceIdList().size() == 2);
        assertTrue(user.getDeviceIdList().get(1).equals(deviceId));

        user.removeDevice(deviceId);

        assertTrue(user.getDeviceIdList().size() == 1);
        assertFalse(user.getDeviceIdList().contains(deviceId));
    }

    @Test
    public void getRole() throws Exception {
        assertTrue(user.getRole() == null);
    }

    @Test
    public void getExpireAt() throws Exception {
        assertTrue(user.getExpireAt() == null);
    }

    @Test
    public void getHomeIdList() throws Exception {
        assertTrue(user.getHomeIdList().size() == 0);
    }

    @Test
    public void getRoomIdList() throws Exception {
        assertTrue(user.getRoomIdList().size() == 0);
    }

    @Test
    public void getDeviceIdList() throws Exception {
        assertTrue(user.getDeviceIdList().size() == 0);
    }

    @Test
    public void setRole() throws Exception {
        final String role = randomGenerator.getRandomNumberStr();
        user.setRole(role);
        assertTrue(user.getRole().equals(role));
    }

    @Test
    public void setExpireAt() throws Exception {
        final String expireAt = randomGenerator.getRandomNumberStr();
        user.setExpireAt(expireAt);
        assertTrue(user.getExpireAt().equals(expireAt));
    }

    @Test
    public void test_toString() throws Exception {

    }

    @Test
    public void getJSON() throws Exception {

    }
}