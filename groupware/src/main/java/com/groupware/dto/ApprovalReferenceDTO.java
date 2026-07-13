package com.groupware.dto;

import lombok.Data;

@Data
public class ApprovalReferenceDTO {
	private int refId;
	private int approvalId;
	// 부서 참조 또는 개인 참조 둘 중 하나만 값이 들어가고 나머지는 NULL
	// -> int(기본형)는 null을 못 담아서 Integer 사용
	private Integer deptId;
	private Integer employeeId;
}
