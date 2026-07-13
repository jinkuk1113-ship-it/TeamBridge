package com.groupware.dto;

import lombok.Data;

@Data
public class NoticeDTO {
	private int noticeId;
	private int writerId;
	private String noticeTitle;
	private String noticeContent;
	private boolean isPinned;
	private int viewCount;
	private String createdAt;
	private String updatedAt;
}
