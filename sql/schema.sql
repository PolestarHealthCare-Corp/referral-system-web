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