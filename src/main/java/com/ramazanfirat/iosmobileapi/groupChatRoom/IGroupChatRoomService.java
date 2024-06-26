package com.ramazanfirat.iosmobileapi.groupChatRoom;

import java.util.List;

public interface IGroupChatRoomService {

  GroupChatRoom createGroupChatRoom(GroupChatRoom groupChatRoom);

  GroupChatRoom findGroupChatRoomById(String roomId);

  List<GroupChatRoom> findGroupChatRoomsByUserId(String userId);

  void addUserToGroupChatRoom(String roomId, String userId);

  void removeUserFromGroupChatRoom(String roomId, String userId);

  void deleteGroupChatRoom(String roomId);
}