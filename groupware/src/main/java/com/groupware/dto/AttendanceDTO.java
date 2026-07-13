package com.groupware.dto;

import lombok.Data;

@Data
public class AttendanceDTO {
	private int attendanceId;
	private int employeeId;
	private String workDate;
	private String checkInTime;
	private String checkOutTime;
	private String attendanceStatus;
}
