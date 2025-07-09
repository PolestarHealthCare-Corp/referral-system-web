--SQL Server
CREATE TABLE Member (
    member_phone VARCHAR(11) PRIMARY KEY NOT NULL,
    member_username NVARCHAR(6) NOT NULL,
    member_role TINYINT NOT NULL, -- ADMIN(0), USER(1)
    member_is_active BIT NOT NULL, -- FALSE(0), TRUE(1)
    member_created_at DATETIME2 NOT NULL DEFAULT GETDATE()
);

INSERT INTO Member (
    member_phone, member_username, member_role, member_is_active
) VALUES
      ('01012341234', N'홍길동', 1, 1),
      ('01023456789', N'이영희', 0, 1),
      ('01034567890', N'김철수', 1, 0);

CREATE TABLE hospital_info (
    hospital_info_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    member_phone VARCHAR(11) NOT NULL,
    hospital_info_name NVARCHAR(25) NOT NULL,
    hospital_info_address NVARCHAR(255) NOT NULL,
    hospital_info_contact_person NVARCHAR(6) NOT NULL,
    hospital_info_contact_phone VARCHAR(11) NOT NULL,
    hospital_info_memo NVARCHAR(500) NULL,
    hospital_info_is_active BIT NOT NULL DEFAULT 0,
    hospital_info_created_at DATETIME2 NULL DEFAULT GETDATE(),
    hospital_info_admin_comment NVARCHAR(500) NULL
);

INSERT INTO hospital_info (
    member_phone,
    hospital_info_name,
    hospital_info_address,
    hospital_info_contact_person,
    hospital_info_contact_phone,
    hospital_info_memo,
    hospital_info_is_active,
    hospital_info_created_at,
    hospital_info_admin_comment
) VALUES
      (
          '01012345678',
          N'서울의료원',
          N'서울특별시 중랑구 신내로 156',
          N'홍길동',
          '01011112222',
          N'응급 진료 가능, 야간 운영',
          1,
          DEFAULT,
          N'최초 등록된 병원입니다.'
      ),
      (
          '01087654321',
          N'부산중앙병원',
          N'부산광역시 부산진구 중앙대로 123',
          N'이영희',
          '01033334444',
          N'정형외과 전문 병원',
          0,
          DEFAULT,
          N'승인 대기 상태'
      );

--H2
CREATE TABLE Member (
    member_phone VARCHAR(11) PRIMARY KEY,
    member_username NVARCHAR(6) NOT NULL,
    member_role TINYINT NOT NULL, -- 0 = ADMIN, 1 = USER
    member_is_active BOOLEAN NOT NULL, -- true / false
    member_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO Member (
    member_phone, member_username, member_role, member_is_active
) VALUES
      ('01012341234', N'홍길동', 1, TRUE),
      ('01023456789', N'이영희', 0, TRUE),
      ('01034567890', N'김철수', 1, FALSE);

CREATE TABLE hospital_info (
    hospital_info_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_phone VARCHAR(11) NOT NULL,
    hospital_info_name NVARCHAR(25) NOT NULL,
    hospital_info_address NVARCHAR(255) NOT NULL,
    hospital_info_contact_name NVARCHAR(6) NOT NULL,
    hospital_info_contact_phone VARCHAR(11) NOT NULL,
    hospital_info_memo NVARCHAR(500),
    hospital_info_is_active BOOLEAN NOT NULL DEFAULT FALSE,
    hospital_info_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    hospital_info_admin_comment NVARCHAR(500)
);

INSERT INTO hospital_info (
    member_phone,
    hospital_info_name,
    hospital_info_address,
    hospital_info_contact_name,
    hospital_info_contact_phone,
    hospital_info_memo,
    hospital_info_is_active,
    hospital_info_created_at,
    hospital_info_admin_comment
) VALUES
      (
          '01012345678',
          N'서울의료원',
          N'서울특별시 중랑구 신내로 156',
          N'홍길동',
          '01011112222',
          N'응급 진료 가능, 야간 운영',
          TRUE,
          CURRENT_TIMESTAMP,
          N'최초 등록된 병원입니다.'
      ),
      (
          '01087654321',
          N'부산중앙병원',
          N'부산광역시 부산진구 중앙대로 123',
          N'이영희',
          '01033334444',
          N'정형외과 전문 병원',
          FALSE,
          CURRENT_TIMESTAMP,
          N'승인 대기 상태'
      );