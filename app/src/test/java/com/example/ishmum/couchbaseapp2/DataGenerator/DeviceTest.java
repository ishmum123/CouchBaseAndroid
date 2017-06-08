package com.example.ishmum.couchbaseapp2.DataGenerator;

import com.example.ishmum.couchbaseapp2.RandomGenerator;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

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
        assertTrue(deviceHash == device.getDeviceHash());
    }

    @Test
    public void getUserIdList() throws Exception {
        assertTrue(0 == device.getUserIdList().size());
    }

    @Test
    public void getRoomId() throws Exception {
        assertTrue(null == device.getRoomId());
    }

    @Test
    public void removeUser() throws Exception {
        final String user1 = generateString(),
                user2 = generateString(),
                user3 = generateString();
        device.addUser(user1);
        device.addUser(user2);
        device.addUser(user3);

        assertTrue(device.getUserIdList().contains(user1));
        device.removeUser(user1);
        assertFalse(device.getUserIdList().contains(user1));

        assertTrue(device.getUserIdList().contains(user2));
        device.removeUser(user2);
        assertFalse(device.getUserIdList().contains(user2));

        assertTrue(device.getUserIdList().contains(user3));
        device.removeUser(user3);
        assertFalse(device.getUserIdList().contains(user3));
    }

    @Test
    public void getHomeId() throws Exception {
        assertTrue(null == device.getHomeId());
    }

    @Test
    public void getConfigData() throws Exception {
        assertTrue(null == device.getConfigData());
    }

    @Test
    public void getUsage() throws Exception {
        assertTrue(null == device.getUsage());
    }

    @Test
    public void getUsageTimeStamp() throws Exception {
        assertTrue(null == device.getUsageTimeStamp());
    }

    @Test
    public void getPresetData() throws Exception {
        assertTrue(null == device.getPresetData());
    }

    @Test
    public void addUser() throws Exception {
        final String user1 = generateString(),
                user2 = generateString(),
                user3 = generateString();

        device.addUser(user1);
        assertTrue(device.getUserIdList().contains(user1));

        device.addUser(user2);
        assertTrue(device.getUserIdList().contains(user2));

        device.addUser(user3);
        assertTrue(device.getUserIdList().contains(user3));
    }

    @Test
    public void setRoomId() throws Exception {
        final String roomId1 = generateString(),
                roomId2 = generateString();

        device.setRoomId(roomId1);
        assertTrue(roomId1 == device.getRoomId());

        device.setRoomId(roomId2);
        assertTrue(roomId1 != device.getRoomId());
        assertTrue(roomId2 == device.getRoomId());
    }

    private String generateString() {
        return randomGenerator.getRandomNumberStr();
    }

    @Test
    public void setHomeId() throws Exception {
        final String homeId1 = generateString(),
                homeId2 = generateString();

        device.setHomeId(homeId1);
        assertTrue(homeId1 == device.getHomeId());

        device.setHomeId(homeId2);
        assertTrue(homeId2 == device.getHomeId());
    }

    @Test
    public void setConfigData() throws Exception {
        final String configData1 = generateString(),
                configData2 = generateString();

        device.setConfigData(configData1);
        assertTrue(configData1 == device.getConfigData());

        device.setConfigData(configData2);
        assertTrue(configData2 == device.getConfigData());
    }

    @Test
    public void setUsage() throws Exception {
        final String usage1 = generateString(),
                usage2 = generateString();

        device.setUsage(usage1);
        assertTrue(usage1 == device.getUsage());

        device.setUsage(usage2);
        assertTrue(usage2 == device.getUsage());
    }

    @Test
    public void setUsageTimeStamp() throws Exception {
        final String usageTimeStamp1 = generateString(),
                usageTimeStamp2 = generateString();

        device.setUsageTimeStamp(usageTimeStamp1);
        assertTrue(usageTimeStamp1 == device.getUsageTimeStamp());

        device.setUsageTimeStamp(usageTimeStamp2);
        assertTrue(usageTimeStamp2 == device.getUsageTimeStamp());
    }

    @Test
    public void setPresetData() throws Exception {
        final String presetData1 = generateString(),
                presetData2 = generateString();

        device.setPresetData(presetData1);
        assertTrue(presetData1 == device.getPresetData());

        device.setPresetData(presetData2);
        assertTrue(presetData2 == device.getPresetData());
    }

    @Test
    public void test_toString() throws Exception {
        final String roomId = generateString(),
                homeId = generateString(),
                configData = generateString(),
                usage = generateString(),
                usageTimeStamp = generateString(),
                presetData = generateString(),
                userId1 = generateString(),
                userId2 = generateString(),

                deviceString1 = "{'deviceHash' : '" + deviceHash + "','roomId' : 'null'," +
                                "'homeId' : 'null','configData' : 'null','usage' : 'null','usageTimeStamp' : 'null'," +
                                "'presetData' : 'null','userIdList' : []}",

                deviceString2 =
                                "{" +
                                "'deviceHash' : '" + deviceHash + "'," +
                                "'roomId' : '" + roomId + "'," +
                                "'homeId' : '" + homeId + "'," +
                                "'configData' : '" + configData + "'," +
                                "'usage' : '" + usage + "'," +
                                "'usageTimeStamp' : '" + usageTimeStamp + "'," +
                                "'presetData' : '" + presetData + "'," +
                                "'userIdList' : [\"" + userId1 + "\",\"" + userId2 + "\"]" +
                                "}",

                deviceString3 =
                                "{" +
                                "'deviceHash' : '" + deviceHash + "'," +
                                "'roomId' : '" + roomId + "'," +
                                "'homeId' : '" + homeId + "'," +
                                "'configData' : '" + configData + "'," +
                                "'usage' : '" + usage + "'," +
                                "'usageTimeStamp' : '" + usageTimeStamp + "'," +
                                "'presetData' : '" + presetData + "'," +
                                "'userIdList' : [\"" + userId1 + "\"]" +
                                "}";

        assertTrue(deviceString1.equals(device.toString()));

        device.setRoomId(roomId);
        device.setHomeId(homeId);
        device.setConfigData(configData);
        device.setUsage(usage);
        device.setUsageTimeStamp(usageTimeStamp);
        device.setPresetData(presetData);
        device.addUser(userId1);
        device.addUser(userId2);

        assertTrue(deviceString2.equals(device.toString()));

        device.removeUser(userId2);

        assertTrue(deviceString3.equals(device.toString()));
    }

    @Test
    public void getJSON() throws Exception {
        final String roomId = generateString(),
                homeId = generateString(),
                configData = generateString(),
                usage = generateString(),
                usageTimeStamp = generateString(),
                presetData = generateString(),
                userId1 = generateString(),
                userId2 = generateString(),
                nullString = "null";

        assertTrue(getJSONDataMatch("deviceHash", deviceHash));
        assertTrue(getJSONDataMatch("roomId", nullString));
        assertTrue(getJSONDataMatch("homeId", nullString));
        assertTrue(getJSONDataMatch("configData", nullString));
        assertTrue(getJSONDataMatch("usage", nullString));
        assertTrue(getJSONDataMatch("usageTimeStamp", nullString));
        assertTrue(getJSONDataMatch("presetData", nullString));
        assertTrue(device.getJSON().getJSONArray("userIdList").length() == 0);

        device.setRoomId(roomId);
        device.setHomeId(homeId);
        device.setConfigData(configData);
        device.setUsage(usage);
        device.setUsageTimeStamp(usageTimeStamp);
        device.setPresetData(presetData);
        device.addUser(userId1);
        device.addUser(userId2);

        assertTrue(getJSONDataMatch("deviceHash", deviceHash));
        assertTrue(getJSONDataMatch("roomId", roomId));
        assertTrue(getJSONDataMatch("homeId", homeId));
        assertTrue(getJSONDataMatch("configData", configData));
        assertTrue(getJSONDataMatch("usage", usage));
        assertTrue(getJSONDataMatch("usageTimeStamp", usageTimeStamp));
        assertTrue(getJSONDataMatch("presetData", presetData));
        assertTrue(device.getJSON().getJSONArray("userIdList").length() == 2);
        assertTrue(device.getJSON().getJSONArray("userIdList").get(0).equals(userId1));
        assertTrue(device.getJSON().getJSONArray("userIdList").get(1).equals(userId2));

        device.removeUser(userId2);

        assertTrue(device.getJSON().getJSONArray("userIdList").length() == 1);
        assertTrue(device.getJSON().getJSONArray("userIdList").get(0).equals(userId1));

        boolean exceptionThrown = false;
        try { device.getJSON().getJSONArray("userIdList").get(1); }
        catch (JSONException e) { exceptionThrown = true; }

        assertTrue(exceptionThrown);
    }

    private boolean getJSONDataMatch(String key, String s) throws JSONException {
        return device.getJSON().get(key).equals(s);
    }
}