package com.xray21.refsys.web.domain;

import com.xray21.refsys.web.dto.request.ReferralSaveRequest;
import java.time.LocalDateTime;

/** 병원 소개 **/
public class Referral {

	private Long referralId;
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
	private String approvalType; //10(접수), 20(담당자확인), 31(계약성공), 32(계약보류)
	private String useYn; //Y, N
	private LocalDateTime createDateTime;
	private String createdBy;
	private LocalDateTime updateDateTime;
	private String updatedBy;

	//생성메서드
	public static Referral createReferral(ReferralSaveRequest request) {
		return new Referral(request);
	}
	public Referral(ReferralSaveRequest request) {
		this.userDepartment = request.getUserDepartment();
		this.userName = request.getUserName();
		this.userPhone = request.getUserPhone();
		this.userPassword = request.getUserPassword();
		this.hospitalName = request.getHospitalName();
		this.hospitalZipCode = request.getHospitalZipCode();
		this.hospitalAddress = request.getHospitalAddress();
		this.hospitalContactName = request.getHospitalContactName();
		this.hospitalContactPhone = request.getHospitalContactPhone();
		this.xrayCount = request.getXrayCount();
		this.ctCount = request.getCtCount();
		this.mrCount = request.getMrCount();
		this.mgCount = request.getMgCount();
		this.hospitalMemo = request.getHospitalMemo();
		this.approvalType = AppConstants.RECEIVED;
		this.useYn = AppConstants.USE;
		this.createDateTime = LocalDateTime.now();
		this.createdBy = request.getUserPhone();
		this.updateDateTime = null;
		this.updatedBy = null;
	}

	//생성자
	public Referral() {
	}

	public Referral(Long referralId, String userDepartment, String userName, String userPhone,
			String userPassword, String hospitalName, String hospitalZipCode,
			String hospitalAddress,
			String hospitalContactName, String hospitalContactPhone, Integer xrayCount,
			Integer ctCount,
			Integer mrCount, Integer mgCount, String hospitalMemo, String approvalType,
			String useYn,
			LocalDateTime createDateTime, String createdBy, LocalDateTime updateDateTime,
			String updatedBy) {
		this.referralId = referralId;
		this.userDepartment = userDepartment;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.hospitalName = hospitalName;
		this.hospitalZipCode = hospitalZipCode;
		this.hospitalAddress = hospitalAddress;
		this.hospitalContactName = hospitalContactName;
		this.hospitalContactPhone = hospitalContactPhone;
		this.xrayCount = xrayCount;
		this.ctCount = ctCount;
		this.mrCount = mrCount;
		this.mgCount = mgCount;
		this.hospitalMemo = hospitalMemo;
		this.approvalType = approvalType;
		this.useYn = useYn;
		this.createDateTime = createDateTime;
		this.createdBy = createdBy;
		this.updateDateTime = updateDateTime;
		this.updatedBy = updatedBy;
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}

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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
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

	public String getHospitalContactPhone() {
		return hospitalContactPhone;
	}

	public void setHospitalContactPhone(String hospitalContactPhone) {
		this.hospitalContactPhone = hospitalContactPhone;
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

	public String getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}