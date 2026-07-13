package com.groupware.dto;

import lombok.Data;

@Data
public class ApprovalFormTypeDTO {
	private int formTypeId;
	private String formTypeName;
	private int approvalStepCount;
}
