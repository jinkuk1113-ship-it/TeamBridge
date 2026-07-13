package com.groupware.dto;

import lombok.Data;

@Data
public class RepositoryDTO {
	private int repoId;
	private String repoName;
	// NULL이면 전사 공용 자료실 -> int(기본형)는 null을 못 담아서 Integer 사용
	private Integer deptId;
	private String createdAt;
}
