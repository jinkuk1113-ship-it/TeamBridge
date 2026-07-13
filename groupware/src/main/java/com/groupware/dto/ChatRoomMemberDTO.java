package com.groupware.dto;

import lombok.Data;

@Data
public class ChatRoomMemberDTO {
	private int memberRowId;
	private int roomId;
	private int employeeId;
	// 아직 아무 메시지도 안 읽었으면 NULL -> int(기본형)는 null을 못 담아서 Integer 사용
	private Integer lastReadMessageId;
	private String joinedAt;
}
