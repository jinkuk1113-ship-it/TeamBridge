package com.groupware.dto;

import lombok.Data;

@Data
public class ApprovalLineDTO {
	private int lineId;
	private int approvalId;
	private int stepNo;
	private int approverId;
	private String lineStatus;
	private String lineComment;
	private String decidedAt;
}
