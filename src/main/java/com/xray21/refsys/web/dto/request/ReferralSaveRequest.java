package com.xray21.refsys.web.dto.request;

public class ReferralSaveRequest {

	private String userDepartment;
	private String userName;
	private String userPhone;
	private String userPassword;
	private String hospitalName;
	private String hospitalZipCode;
	private String hospitalAddress;
	private String hospitalContactName;
	private String hospitalContactPhone;
	private Integer xrayCount;
	private Integer ctCount;
	private Integer mrCount;
	private Integer mgCount;
	private String hospitalMemo;

	public String getUserDepartment() {
		return userDepartment;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getHospitalZipCode() {
		return hospitalZipCode;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public String getHospitalContactName() {
		return hospitalContactName;
	}

	public String getHospitalContactPhone() {
		return hospitalContactPhone;
	}

	public Integer getXrayCount() {
		return xrayCount;
	}

	public Integer getCtCount() {
		return ctCount;
	}

	public Integer getMrCount() {
		return mrCount;
	}

	public Integer getMgCount() {
		return mgCount;
	}

	public String getHospitalMemo() {
		return hospitalMemo;
	}

}
