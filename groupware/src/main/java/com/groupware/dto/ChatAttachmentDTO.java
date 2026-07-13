package com.groupware.dto;

import lombok.Data;

@Data
public class ChatAttachmentDTO {
	private int attachId;
	private int messageId;
	private String fileName;
	private String filePath;
	private long fileSize;
}
