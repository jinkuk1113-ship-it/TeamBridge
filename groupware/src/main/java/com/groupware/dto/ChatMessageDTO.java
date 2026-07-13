package com.groupware.dto;

import lombok.Data;

@Data
public class ChatMessageDTO {
	private int messageId;
	private int roomId;
	// 시스템 메시지("OOO님이 입장했습니다" 등)는 보낸 사람이 없어서 NULL
	// -> int(기본형)는 null을 못 담아서 Integer 사용
	private Integer senderId;
	private String messageType;
	private String content;
	private String sentAt;
}
