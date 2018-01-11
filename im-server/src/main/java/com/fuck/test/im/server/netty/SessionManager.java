package com.fuck.test.im.server.netty;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DESCRIPTION:
 * channel 无法缓存至redis
 * 新增当前进场channel缓存便于推送消息至各客户端
 * imRoomsMap
 * key: tv_room_ + roomId value: roomMap(key:userId value:IMService)
 * @author zouyan
 * @create 2018-01-05 下午2:57
 * created by fuck~
 **/
public class SessionManager {

    public static final Map<String, Object> imRoomsMap = new ConcurrentHashMap<String, Object>();

    public static void putRoomSession(String roomKey, Map<String, Object> roomMap) {
        imRoomsMap.put(roomKey, roomMap);
    }

    public static Map<String, Object> findRoomSessionById(String roomKey) {
        return (Map<String, Object>)imRoomsMap.get(roomKey);
    }

    public static void removeRoomSession(String roomKey) {
        imRoomsMap.remove(roomKey);
    }
}
