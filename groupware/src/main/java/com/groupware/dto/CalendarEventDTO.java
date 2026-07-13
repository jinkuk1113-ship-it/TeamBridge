package com.groupware.dto;

import lombok.Data;

@Data
public class CalendarEventDTO {
	private int eventId;
	private int employeeId;
	private String eventTitle;
	private String startDate;
	private String endDate;
	private String eventCategory;
	private String createdAt;
}
