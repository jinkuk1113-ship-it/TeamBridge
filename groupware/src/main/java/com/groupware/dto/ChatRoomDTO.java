package com.groupware.dto;

import lombok.Data;

@Data
public class ChatRoomDTO {
	private int roomId;
	private String roomType;
	// GROUP 방만 값이 있고 DM 방은 NULL
	private String roomName;
	private String createdAt;
}
