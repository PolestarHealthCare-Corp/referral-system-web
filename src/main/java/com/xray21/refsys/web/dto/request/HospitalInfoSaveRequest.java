package com.xray21.refsys.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HospitalInfoSaveRequest {

	private String memberPhone;
	private String hospitalInfoName;
	private String hospitalInfoAddress;
	private String hospitalInfoContactName;
	private String hospitalInfoContactPhone;
	private String hospitalInfoMemo;

}
