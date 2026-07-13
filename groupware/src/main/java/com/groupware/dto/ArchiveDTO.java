package com.groupware.dto;

import lombok.Data;

@Data
public class ArchiveDTO {
	private int archiveId;
	private int repoId;
	private int writerId;
	private String archiveTitle;
	private String archiveContent;
	private String createdAt;
	private String updatedAt;
}
