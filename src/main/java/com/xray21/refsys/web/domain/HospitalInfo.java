package com.xray21.refsys.web.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class HospitalInfo {

	//TODO hospitalInfo 삭제 건의 필요
	private Long hospitalInfoId;
	private String memberPhone;
	private String hospitalInfoName;
	private String hospitalInfoAddress;
	private String hospitalInfoContactName;
	private String hospitalInfoContactPhone;
	private String hospitalInfoMemo;
	private boolean hospitalInfoIsActive;
	private LocalDateTime hospitalInfoCreatedAt;
	private String hospitalInfoAdminComment;

}

