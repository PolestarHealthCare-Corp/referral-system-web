package com.xray21.refsys.web.dto.request;

import com.xray21.refsys.web.util.PasswordValid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ReferralSaveRequest {

	@Size(max = 10)
	private String userDepartment;
	@NotBlank //이건 그냥 trim 처리하는게 어떤가
	@Size(max = 5)
	private String userName;
	@NotBlank
	@Pattern(regexp = "^(0(2|3[1-3]|4[1-4]|5[1-5]|6[1-4]|70|80|10|11|16|17|18|19))$")
	private String userPhoneFront;
	@NotBlank
	@Pattern(regexp = "^\\d{3,4}$")
	private String userPhoneMiddle;
	@NotBlank
	@Pattern(regexp = "^\\d{4}$")
	private String userPhoneBack;
	@NotBlank
	@Pattern(regexp = "^\\d{4}$")
	@PasswordValid
	private String userPassword;
	@NotBlank
	@Size(max = 28)
	private String hospitalName;
	@NotBlank
	@Size(max = 5)
	//주소는 사용자가 직접 입력하지 않고 카카오api 사용할거임
	private String hospitalZipCode;
	@NotBlank
	@Size(max = 200)
	//주소는 사용자가 직접 입력하지 않고 카카오api 사용할거임
	private String hospitalAddress;
	@NotBlank
	@Size(max = 5)
	private String hospitalContactName;
	@NotBlank
	@Pattern(regexp = "^(0(2|3[1-3]|4[1-4]|5[1-5]|6[1-4]|70|80|10|11|16|17|18|19))$")
	private String hospitalContactPhoneFront;
	@NotBlank
	@Pattern(regexp = "^\\d{3,4}$")
	private String hospitalContactPhoneMiddle;
	@NotBlank
	@Pattern(regexp = "^\\d{4}$")
	private String hospitalContactPhoneBack;
	@Max(30)
	private Integer xrayCount;
	@Max(30)
	private Integer ctCount;
	@Max(30)
	private Integer mrCount;
	@Max(value = 30)
	private Integer mgCount;
	@Size(max = 500)
	private String hospitalMemo;

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneFront() {
		return userPhoneFront;
	}

	public void setUserPhoneFront(String userPhoneFront) {
		this.userPhoneFront = userPhoneFront;
	}

	public String getUserPhoneMiddle() {
		return userPhoneMiddle;
	}

	public void setUserPhoneMiddle(String userPhoneMiddle) {
		this.userPhoneMiddle = userPhoneMiddle;
	}

	public String getUserPhoneBack() {
		return userPhoneBack;
	}

	public void setUserPhoneBack(String userPhoneBack) {
		this.userPhoneBack = userPhoneBack;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalZipCode() {
		return hospitalZipCode;
	}

	public void setHospitalZipCode(String hospitalZipCode) {
		this.hospitalZipCode = hospitalZipCode;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getHospitalContactName() {
		return hospitalContactName;
	}

	public void setHospitalContactName(String hospitalContactName) {
		this.hospitalContactName = hospitalContactName;
	}

	public String getHospitalContactPhoneFront() {
		return hospitalContactPhoneFront;
	}

	public void setHospitalContactPhoneFront(String hospitalContactPhoneFront) {
		this.hospitalContactPhoneFront = hospitalContactPhoneFront;
	}

	public String getHospitalContactPhoneMiddle() {
		return hospitalContactPhoneMiddle;
	}

	public void setHospitalContactPhoneMiddle(String hospitalContactPhoneMiddle) {
		this.hospitalContactPhoneMiddle = hospitalContactPhoneMiddle;
	}

	public String getHospitalContactPhoneBack() {
		return hospitalContactPhoneBack;
	}

	public void setHospitalContactPhoneBack(String hospitalContactPhoneBack) {
		this.hospitalContactPhoneBack = hospitalContactPhoneBack;
	}

	public Integer getXrayCount() {
		return xrayCount;
	}

	public void setXrayCount(Integer xrayCount) {
		this.xrayCount = xrayCount;
	}

	public Integer getCtCount() {
		return ctCount;
	}

	public void setCtCount(Integer ctCount) {
		this.ctCount = ctCount;
	}

	public Integer getMrCount() {
		return mrCount;
	}

	public void setMrCount(Integer mrCount) {
		this.mrCount = mrCount;
	}

	public Integer getMgCount() {
		return mgCount;
	}

	public void setMgCount(Integer mgCount) {
		this.mgCount = mgCount;
	}

	public String getHospitalMemo() {
		return hospitalMemo;
	}

	public void setHospitalMemo(String hospitalMemo) {
		this.hospitalMemo = hospitalMemo;
	}
}
