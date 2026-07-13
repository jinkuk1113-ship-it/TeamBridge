package com.groupware.dto;

import lombok.Data;

@Data
public class ApprovalDTO {
	private int approvalId;
	private int drafterId;
	private int formTypeId;
	private String approvalTitle;
	private String approvalContent;
	// 휴가 신청서가 아니면 NULL -> Integer가 아니라 String이라 그대로 null 담을 수 있음
	private String leaveStartDate;
	private String leaveEndDate;
	private String approvalStatus;
	private String createdAt;
}
