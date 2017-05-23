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
        deviceHash = generateString();
        device = new Device(deviceHash);
    }

    @Test
    public void getDeviceHash() throws Exception {
        assert (deviceHash == device.getDeviceHash());
    }

    @Test
    public void getUserIdList() throws Exception {
        assert (0 == device.getUserIdList().size());
    }

    @Test
    public void getRoomId() throws Exception {
        assert (null == device.getRoomId());
    }

    @Test
    public void getHomeId() throws Exception {
        assert (null == device.getHomeId());
    }

    @Test
    public void getConfigData() throws Exception {
        assert (null == device.getConfigData());
    }

    @Test
    public void getUsage() throws Exception {
        assert (null == device.getUsage());
    }

    @Test
    public void getUsageTimeStamp() throws Exception {
        assert (null == device.getUsageTimeStamp());
    }

    @Test
    public void getPresetData() throws Exception {
        assert (null == device.getPresetData());
    }

    @Test
    public void addUser() throws Exception {
        final String user1 = generateString(),
                user2 = generateString(),
                user3 = generateString();

        device.addUser(user1);
        assert (1 == device.getUserIdList().size());
        assert (user1 == device.getUserIdList().get(0));

        device.addUser(user2);
        assert (2 == device.getUserIdList().size());
        assert (user2 == device.getUserIdList().get(1));

        device.addUser(user3);
        assert (3 == device.getUserIdList().size());
        assert (user3 != device.getUserIdList().get(1));
    }

    @Test
    public void setRoomId() throws Exception {
        final String roomId1 = generateString(),
                roomId2 = generateString();

        device.setRoomId(roomId1);
        assert (roomId1 == device.getRoomId());

        device.setRoomId(roomId2);
        assert (roomId1 != device.getRoomId());
        assert (roomId2 == device.getRoomId());
    }

    private String generateString() {
        return randomGenerator.getRandomNumberStr();
    }

    @Test
    public void setHomeId() throws Exception {
        final String homeId1 = generateString(),
                homeId2 = generateString();

        device.setHomeId(homeId1);
        assert (homeId1 == device.getHomeId());

        device.setHomeId(homeId2);
        assert (homeId2 == device.getHomeId());
    }

    @Test
    public void setConfigData() throws Exception {
        final String configData1 = generateString(),
                configData2 = generateString();

        device.setConfigData(configData1);
        assert (configData1 == device.getConfigData());

        device.setConfigData(configData2);
        assert (configData2 == device.getConfigData());
    }

    @Test
    public void setUsage() throws Exception {
        final String usage1 = generateString(),
                usage2 = generateString();

        device.setUsage(usage1);
        assert (usage1 == device.getUsage());

        device.setUsage(usage2);
        assert (usage2 == device.getUsage());
    }

    @Test
    public void setUsageTimeStamp() throws Exception {
        final String usageTimeStamp1 = generateString(),
                usageTimeStamp2 = generateString();

        device.setUsageTimeStamp(usageTimeStamp1);
        assert (usageTimeStamp1 == device.getUsageTimeStamp());

        device.setUsageTimeStamp(usageTimeStamp2);
        assert (usageTimeStamp2 == device.getUsageTimeStamp());
    }

    @Test
    public void setPresetData() throws Exception {
        final String presetData1 = generateString(),
                presetData2 = generateString();

        device.setPresetData(presetData1);
        assert (presetData1 == device.getPresetData());

        device.setPresetData(presetData2);
        assert (presetData2 == device.getPresetData());
    }

    @Test
    public void test_toString() throws Exception {
        final String roomId = generateString(),
                homeId = generateString(),
                configData = generateString(),
                usage = generateString(),
                usageTimeStamp = generateString(),
                presetData = generateString(),
                userId = generateString();

        final String deviceString1 = "{'deviceHash' : '" + deviceHash + "','roomId' : ''," +
                "'homeId' : '','configData' : '','usage' : '','usageTimeStamp' : ''," +
                "'presetData' : '','userIdList' : ''}",

                deviceString2 =
                        "{" +
                            "'deviceHash' : '" + deviceHash + "'," +
                            "'roomId' : '" + roomId + "'," +
                            "'homeId' : '" + homeId + "'," +
                            "'configData' : '" + configData + "'," +
                            "'usage' : '" + usage + "'," +
                            "'usageTimeStamp' : '" + usageTimeStamp + "'," +
                            "'presetData' : '" + presetData + "'," +
                            "'userIdList' : ['" + userId + "']" +
                        "}";

        assert (deviceString1 == device.toString());

        device.setRoomId(roomId);
        device.setHomeId(homeId);
        device.setConfigData(configData);
        device.setUsage(usage);
        device.setUsageTimeStamp(usageTimeStamp);
        device.setPresetData(presetData);
        device.addUser(userId);

        assert (deviceString2 == device.toString());
    }

}