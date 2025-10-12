-- Referral 샘플 데이터 (3개)
SET IDENTITY_INSERT Referral ON;

INSERT INTO Referral (
    referral_id, user_department, user_name, user_phone, user_password, hospital_name,
    hospital_zip_code, hospital_address, hospital_contact_name, hospital_contact_phone,
    xray_count, ct_count, mr_count, mg_count,
    hospital_memo, approval_type, use_yn, create_date_time, created_by, update_date_time, updated_by
) VALUES
      (1, '내과', '김철수', '01012345678', '1234', '서울병원', '12345', '서울시 강남구 1길', '이영희', '01098765432',
       1, 0, 0, 2, '메모1', '10', 'Y', '2025-10-12 12:00:00', '김철수', '2025-10-12 14:00:00', '김철수'),
      (2, '외과', '박영희', '01023456789', '5678', '부산병원', '23456', '부산시 해운대구 2길', '김민수', '01087654321',
       0, 1, 1, 0, '메모2', '10', 'Y', '2025-10-12 12:00:01', '박영희', '2025-10-12 14:00:01', '박영희'),
      (3, '소아과', '이민호', '01034567890', '9012', '대전병원', '34567', '대전시 유성구 3길', '최지우', '01076543210',
       2, 2, 0, 1, '메모3', '31', 'Y', '2025-10-12 12:00:02', '이민호', '2025-10-12 14:00:02', '이민호');

SET IDENTITY_INSERT Referral OFF;

-- File 샘플 데이터 (3개)
SET IDENTITY_INSERT File ON;

INSERT INTO File (
    file_id, referral_id, file_name, file_path, file_type, use_yn, created_date_time, created_by, update_date_time, updated_by
) VALUES
      (1, 1, 'xray 예시', '/2025/10/10/', '11', 'Y', '2025-10-12 12:00:00', '김철수', NULL, NULL),
      (2, 2, '김민수 명함', '/2025/10/10/', '10', 'Y', '2025-10-12 12:00:01', '박영희', NULL, NULL),
      (3, 2, '요구사항', '/2025/10/10/', '20', 'Y', '2025-10-12 12:00:02', '박영희', NULL, NULL);

SET IDENTITY_INSERT File OFF;

-- Status_History 샘플 데이터 (3개)
SET IDENTITY_INSERT Status_History ON;

INSERT INTO Status_History (
    status_id, referral_id, approval_type, comment, use_yn, created_by_name, created_date_time, created_by
) VALUES
      (1, 1, '20', '승인상태 변경', 'Y', '홍길동', '2025-10-12 13:00:00', 'admin1Id'),
      (2, 2, '20', '승인상태 변경', 'Y', '김병원', '2025-10-12 13:00:01', 'admin2Id'),
      (3, 3, '32', '승인상태 변경', 'Y', '김병원', '2025-10-12 13:00:02', 'admin2Id');

SET IDENTITY_INSERT Status_History OFF;

-- Referral_History 샘플 데이터 (3개)
SET IDENTITY_INSERT Referral_History ON;

INSERT INTO Referral_History (
    history_id, referral_id, updated_fields, create_date_time, created_by
) VALUES
      (1, 1, 'user_name, xray_count', '2025-10-12 14:00:00', '김철수'),
      (2, 2, 'hospital_name, ct_count', '2025-10-12 14:00:01', '박영희'),
      (3, 3, 'hospital_contact_phone', '2025-10-12 14:00:02', '이민호');

SET IDENTITY_INSERT Referral_History OFF;
