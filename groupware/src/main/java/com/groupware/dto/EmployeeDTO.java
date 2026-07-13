package com.groupware.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
	private int employeeId;
	private String employeeNo; 		// 사번(로그인 ID 겸용)
	private String employeePwd;
	private String employeeName;
	private int deptId;
	private int positionId;
	private String employeeRole;	// EMPLOYEE / ADMIN
	private String employeePhone;
	private String employeeEmail;
	private String profileImg;
	private String employeeStatus;	// ACTIVE / SUSPENDED
	private String hireDate;
	private String createdAt;
}