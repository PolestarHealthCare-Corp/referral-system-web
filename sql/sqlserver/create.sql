-- Referral 테이블
CREATE TABLE Referral (
    referral_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    user_department NVARCHAR(10) NULL,
    user_name NVARCHAR(5) NOT NULL,
    user_phone VARCHAR(11) NOT NULL,
    user_password CHAR(4) NOT NULL,
    hospital_name NVARCHAR(28) NOT NULL,
    hospital_zip_code VARCHAR(5) NOT NULL,
    hospital_address NVARCHAR(200) NOT NULL,
    hospital_contact_name NVARCHAR(5) NOT NULL,
    hospital_contact_phone VARCHAR(11) NOT NULL,
    xray_count TINYINT NOT NULL,
    ct_count TINYINT NOT NULL,
    mr_count TINYINT NOT NULL,
    mg_count TINYINT NOT NULL,
    hospital_memo NVARCHAR(500) NULL,
    approval_type CHAR(2) NOT NULL,
    use_yn CHAR(1) NOT NULL,
    create_date_time DATETIME NOT NULL,
    created_by NVARCHAR(15) NOT NULL,
    update_date_time DATETIME NULL,
    updated_by NVARCHAR(15) NULL
);

-- File 테이블
CREATE TABLE File (
    file_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    referral_id BIGINT NOT NULL,
    file_name NVARCHAR(255) NOT NULL,
    file_path NVARCHAR(255) NOT NULL,
    file_type CHAR(2) NOT NULL,
    use_yn CHAR(1) NOT NULL,
    created_date_time DATETIME NOT NULL,
    created_by NVARCHAR(15) NOT NULL,
    update_date_time DATETIME NULL,
    updated_by NVARCHAR(15) NULL,
    CONSTRAINT FK_File_Referral FOREIGN KEY (referral_id) REFERENCES Referral(referral_id)
);

-- Status_History 테이블
CREATE TABLE Status_History (
    status_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    referral_id BIGINT NOT NULL,
    approval_type CHAR(2) NOT NULL,
    comment NVARCHAR(500) NULL,
    use_yn CHAR(1) NOT NULL,
    created_by_name NVARCHAR(5) NOT NULL,
    created_date_time DATETIME NOT NULL,
    created_by NVARCHAR(15) NOT NULL,
    CONSTRAINT FK_Status_Referral FOREIGN KEY (referral_id) REFERENCES Referral(referral_id)
);

-- Referral_History 테이블
CREATE TABLE Referral_History (
    history_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    referral_id BIGINT NOT NULL,
    updated_fields NVARCHAR(500) NOT NULL,
    create_date_time DATETIME NOT NULL,
    created_by NVARCHAR(15) NOT NULL,
    CONSTRAINT FK_ReferralHistory_Referral FOREIGN KEY (referral_id) REFERENCES Referral(referral_id)
);
