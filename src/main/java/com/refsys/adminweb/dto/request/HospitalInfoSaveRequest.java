package com.refsys.adminweb.dto.request;

import lombok.Data;

@Data
public class HospitalInfoSaveRequest {

	private String memberPhone;
	private String hospitalInfoName;
	private String hospitalInfoAddress;
	private String hospitalInfoContactName;
	private String hospitalInfoContactPhone;
	private String hospitalInfoMemo;

}
