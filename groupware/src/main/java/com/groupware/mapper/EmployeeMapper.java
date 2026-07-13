package com.groupware.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.groupware.dto.EmployeeDTO;

@Mapper
public interface EmployeeMapper {
	EmployeeDTO findByEmployeeNo(String employeeNo);
}
