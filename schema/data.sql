-- 개발/테스트용 초기 데이터
-- 전제: 같은 폴더의 schema.sql을 먼저 실행해서 테이블이 생성돼 있어야 함
-- 모든 계정의 비밀번호는 "1234" (BCryptPasswordEncoder로 해시된 값, 아래 해시 그대로 사용)
-- 팀원 각자 로컬 DB에 이 스크립트를 실행하면 동일한 계정으로 로그인 테스트 가능

USE groupware;

-- ------------------------------------
-- 1. DEPARTMENT
-- ------------------------------------
INSERT INTO DEPARTMENT (DEPT_NAME) VALUES
  ('개발팀'),
  ('인사팀'),
  ('영업팀');

-- ------------------------------------
-- 2. POSITION (POSITION_RANK: 1=부서장 … 5=사원)
-- ------------------------------------
INSERT INTO POSITION (POSITION_NAME, POSITION_RANK) VALUES
  ('부서장', 1),
  ('팀장',   2),
  ('대리',   3),
  ('주임',   4),
  ('사원',   5);

-- ------------------------------------
-- 3. EMPLOYEE
-- 비밀번호 원문은 전부 "1234" (아래는 BCrypt 해시값, 평문 아님)
-- ------------------------------------
INSERT INTO EMPLOYEE
  (EMPLOYEE_NO, EMPLOYEE_PWD, EMPLOYEE_NAME, DEPT_ID, POSITION_ID, EMPLOYEE_ROLE, EMPLOYEE_PHONE, EMPLOYEE_EMAIL, EMPLOYEE_STATUS, HIRE_DATE)
VALUES
  -- 관리자 계정: DEPT_ID/POSITION_ID는 NULL 허용(CK_EMPLOYEE_DEPT_POSITION 제약조건 참고)
  ('admin',    '$2a$10$6mG/6wF8HO.a0UnKigjXYOtmblujqdx2pnmWlgT5DRiTzErqUXzq6', '관리자',   NULL, NULL, 'ADMIN',    '010-0000-0000', 'admin@groupware.com',    'ACTIVE', '2020-01-01'),
  -- 개발팀 부서장
  ('20260010', '$2a$10$6mG/6wF8HO.a0UnKigjXYOtmblujqdx2pnmWlgT5DRiTzErqUXzq6', '김부장',   1,    1,    'EMPLOYEE', '010-1111-0010', 'dept10@groupware.com',   'ACTIVE', '2020-03-01'),
  -- 개발팀 팀장
  ('20260102', '$2a$10$6mG/6wF8HO.a0UnKigjXYOtmblujqdx2pnmWlgT5DRiTzErqUXzq6', '이팀장',   1,    2,    'EMPLOYEE', '010-1111-0102', 'lead102@groupware.com',  'ACTIVE', '2021-06-15'),
  -- 개발팀 사원
  ('20260601', '$2a$10$6mG/6wF8HO.a0UnKigjXYOtmblujqdx2pnmWlgT5DRiTzErqUXzq6', '박사원',   1,    5,    'EMPLOYEE', '010-1111-0601', 'staff601@groupware.com', 'ACTIVE', '2026-01-05'),
  -- 정지 계정 테스트용 (isEnabled()=false 경로 확인용)
  ('20260099', '$2a$10$6mG/6wF8HO.a0UnKigjXYOtmblujqdx2pnmWlgT5DRiTzErqUXzq6', '최정지',   2,    5,    'EMPLOYEE', '010-2222-0099', 'susp099@groupware.com',  'SUSPENDED', '2022-09-01');

-- ------------------------------------
-- 테스트 계정 목록 (전부 비밀번호 1234)
-- ------------------------------------
-- admin      | 관리자   | ADMIN 로그인 확인용
-- 20260010   | 김부장   | 정상 로그인 확인용 (부서장)
-- 20260102   | 이팀장   | 정상 로그인 확인용 (팀장)
-- 20260601   | 박사원   | 정상 로그인 확인용 (사원)
-- 20260099   | 최정지   | 로그인 차단(SUSPENDED) 확인용 -> 로그인 시도하면 실패해야 정상
