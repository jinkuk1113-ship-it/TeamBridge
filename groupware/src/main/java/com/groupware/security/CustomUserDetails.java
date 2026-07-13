package com.groupware.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.groupware.dto.EmployeeDTO;

import lombok.Getter;

// EmployeeDTO(우리 DB 구조)를 Spring Security가 이해하는 UserDetails(정해진 규격)로
// 바꿔주는 "어댑터" 클래스. Security 내부 로직은 EmployeeDTO를 몰라도
// 이 클래스를 통해서만 유저 정보를 다룬다.
@Getter
public class CustomUserDetails implements UserDetails {

    // 원본 직원 정보를 그대로 들고 있음 -> 나중에 컨트롤러에서
    // principal.getEmployeeDTO() 로 이름/부서 등 전체 정보를 꺼내 쓸 수 있음
    private final EmployeeDTO employeeDTO;

    public CustomUserDetails(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    // 이 유저가 가진 권한 목록을 반환.
    // Security 관례: 역할 이름 앞에 "ROLE_"을 붙여야 나중에 hasRole("ADMIN") 같은
    // 검사가 이걸 인식할 수 있음. 우리 EMPLOYEE_ROLE 값은 "EMPLOYEE" 또는 "ADMIN".
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + employeeDTO.getEmployeeRole()));
    }

    // 로그인 시 입력한 비밀번호와 비교할 대상.
    // EMPLOYEE_PWD는 평문이 아니라 BCrypt로 해시된 값이 저장돼 있어야 함.
    @Override
    public String getPassword() {
        return employeeDTO.getEmployeePwd();
    }

    // Security가 "이 유저를 식별하는 아이디"로 쓰는 값.
    // 우리 프로젝트는 사번(EMPLOYEE_NO)이 곧 로그인 아이디이므로 그대로 반환.
    @Override
    public String getUsername() {
        return employeeDTO.getEmployeeNo();
    }

    // UserDetails 인터페이스가 강제하는 메서드라 구현 안 하면 컴파일이 안 됨.
    // 로그인 시도마다 Security가 자동으로 이 4개(만료/잠금/비밀번호만료/활성화)를
    // 순서대로 호출해서 하나라도 false면 로그인을 막는데, 이 프로젝트는
    // 만료·잠금 기능 자체가 없으므로 항상 true(통과)로 고정해둔 것.
    // isEnabled()만 실제 로직(정지 계정 차단)이 들어감.

    // 계정 만료 기능 — 이 프로젝트는 안 쓰므로 항상 true(문제 없음)로 고정.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠금 기능 — 이 프로젝트는 안 쓰므로 항상 true(문제 없음)로 고정.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 만료 기능 — 이 프로젝트는 안 쓰므로 항상 true(문제 없음)로 고정.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 이 계정으로 로그인 가능한지 여부.
    // EMPLOYEE_STATUS가 'ACTIVE'가 아니면(=SUSPENDED, 정지 계정) false를 반환하고,
    // Security가 이 값을 보고 자동으로 로그인을 막아준다(DisabledException 발생).
    // -> 우리가 직접 "정지 계정이면 막기" 코드를 따로 안 짜도 되는 이유가 여기 있음.
    @Override
    public boolean isEnabled() {
        return "ACTIVE".equals(employeeDTO.getEmployeeStatus());
    }

}