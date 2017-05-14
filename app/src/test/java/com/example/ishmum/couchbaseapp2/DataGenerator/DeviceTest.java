package com.example.ishmum.couchbaseapp2.DataGenerator;

import com.example.ishmum.couchbaseapp2.RandomGenerator;

import org.junit.Before;
import org.junit.Test;

public class DeviceTest {

    private Device device;
    private RandomGenerator randomGenerator;
    private String deviceHash;

    @Before
    public void setUp() throws Exception {
        randomGenerator = new RandomGenerator();
        deviceHash = randomGenerator.getRandomNumberStr();
        device = new Device(deviceHash);
    }

    @Test
    public void getDeviceHash() throws Exception {
        assert(deviceHash == device.getDeviceHash());
    }

    @Test
    public void getUserIdList() throws Exception {
        assert(0 == device.getUserIdList().size());
    }

    @Test
    public void getRoomId() throws Exception {
        assert(null == device.getRoomId());
    }

    @Test
    public void getHomeId() throws Exception {
        assert(null == device.getHomeId());
    }

    @Test
    public void getConfigData() throws Exception {
        assert(null == device.getConfigData());
    }

    @Test
    public void getUsage() throws Exception {
        assert(null == device.getUsage());
    }

    @Test
    public void getUsageTimeStamp() throws Exception {
        assert(null == device.getUsageTimeStamp());
    }

    @Test
    public void getPresetData() throws Exception {
        assert(null == device.getPresetData());
    }

    @Test
    public void addUser() throws Exception {
        final String user1 = randomGenerator.getRandomNumberStr(),
                    user2 = randomGenerator.getRandomNumberStr(),
                    user3 = randomGenerator.getRandomNumberStr();

        device.addUser(user1);
        assert(1 == device.getUserIdList().size());
        assert(user1 == device.getUserIdList().get(0));

        device.addUser(user2);
        assert(2 == device.getUserIdList().size());
        assert(user2 == device.getUserIdList().get(1));

        device.addUser(user3);
        assert(3 == device.getUserIdList().size());
        assert(user3 != device.getUserIdList().get(1));
    }

    @Test
    public void setRoomId() throws Exception {
        final String roomId1 = randomGenerator.getRandomNumberStr(),
                    roomId2 = randomGenerator.getRandomNumberStr();

        device.setRoomId(roomId1);
        assert(roomId1 == device.getRoomId());

        device.setRoomId(roomId2);
        assert(roomId1 != device.getRoomId());
        assert(roomId2 == device.getRoomId());
    }

    @Test
    public void setHomeId() throws Exception {

    }

    @Test
    public void setConfigData() throws Exception {

    }

    @Test
    public void setUsage() throws Exception {

    }

    @Test
    public void setUsageTimeStamp() throws Exception {

    }

    @Test
    public void setPresetData() throws Exception {

    }

    @Test
    public void test_toString() throws Exception {

    }

}