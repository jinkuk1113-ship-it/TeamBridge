package com.groupware.dto;

import lombok.Data;

@Data
public class ArchiveFileDTO {
	private int fileId;
	private int archiveId;
	private String fileName;
	private String filePath;
	private long fileSize;
	private String uploadedAt;
}
