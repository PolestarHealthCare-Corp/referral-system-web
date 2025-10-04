package com.xray21.refsys.web.domain;

import java.time.LocalDateTime;

/** 병원 소개 **/
public class Referral {

	private Long referral_id;
	private String user_department;
	private String user_name;
	private String user_phone;
	private String user_password;
	private String hospital_name;
	private String hospital_zip_code;
	private String hospital_address;
	private String hospital_contact_name;
	private String hospital_contact_phone;
	private Integer xray_count;
	private Integer ct_count;
	private Integer mr_count;
	private Integer mg_count;
	private String hospital_memo;
	private String approval_type; //enum 변경 고려
	private String use_yn; //enum 변경 고려
	private LocalDateTime create_date_time;
	private String created_by;
	private LocalDateTime update_date_time;
	private String updated_by;

	public Referral() {
	}

	public Referral(Long referral_id, String user_department, String user_name, String user_phone,
			String user_password, String hospital_name, String hospital_zip_code,
			String hospital_address, String hospital_contact_name, String hospital_contact_phone,
			Integer xray_count, Integer ct_count, Integer mr_count, Integer mg_count,
			String hospital_memo, String approval_type, String use_yn,
			LocalDateTime create_date_time,
			String created_by, LocalDateTime update_date_time, String updated_by) {
		this.referral_id = referral_id;
		this.user_department = user_department;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_password = user_password;
		this.hospital_name = hospital_name;
		this.hospital_zip_code = hospital_zip_code;
		this.hospital_address = hospital_address;
		this.hospital_contact_name = hospital_contact_name;
		this.hospital_contact_phone = hospital_contact_phone;
		this.xray_count = xray_count;
		this.ct_count = ct_count;
		this.mr_count = mr_count;
		this.mg_count = mg_count;
		this.hospital_memo = hospital_memo;
		this.approval_type = approval_type;
		this.use_yn = use_yn;
		this.create_date_time = create_date_time;
		this.created_by = created_by;
		this.update_date_time = update_date_time;
		this.updated_by = updated_by;
	}

	public Long getReferral_id() {
		return referral_id;
	}

	public void setReferral_id(Long referral_id) {
		this.referral_id = referral_id;
	}

	public String getUser_department() {
		return user_department;
	}

	public void setUser_department(String user_department) {
		this.user_department = user_department;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getHospital_zip_code() {
		return hospital_zip_code;
	}

	public void setHospital_zip_code(String hospital_zip_code) {
		this.hospital_zip_code = hospital_zip_code;
	}

	public String getHospital_address() {
		return hospital_address;
	}

	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}

	public String getHospital_contact_name() {
		return hospital_contact_name;
	}

	public void setHospital_contact_name(String hospital_contact_name) {
		this.hospital_contact_name = hospital_contact_name;
	}

	public String getHospital_contact_phone() {
		return hospital_contact_phone;
	}

	public void setHospital_contact_phone(String hospital_contact_phone) {
		this.hospital_contact_phone = hospital_contact_phone;
	}

	public Integer getXray_count() {
		return xray_count;
	}

	public void setXray_count(Integer xray_count) {
		this.xray_count = xray_count;
	}

	public Integer getCt_count() {
		return ct_count;
	}

	public void setCt_count(Integer ct_count) {
		this.ct_count = ct_count;
	}

	public Integer getMr_count() {
		return mr_count;
	}

	public void setMr_count(Integer mr_count) {
		this.mr_count = mr_count;
	}

	public Integer getMg_count() {
		return mg_count;
	}

	public void setMg_count(Integer mg_count) {
		this.mg_count = mg_count;
	}

	public String getHospital_memo() {
		return hospital_memo;
	}

	public void setHospital_memo(String hospital_memo) {
		this.hospital_memo = hospital_memo;
	}

	public String getApproval_type() {
		return approval_type;
	}

	public void setApproval_type(String approval_type) {
		this.approval_type = approval_type;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public LocalDateTime getCreate_date_time() {
		return create_date_time;
	}

	public void setCreate_date_time(LocalDateTime create_date_time) {
		this.create_date_time = create_date_time;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public LocalDateTime getUpdate_date_time() {
		return update_date_time;
	}

	public void setUpdate_date_time(LocalDateTime update_date_time) {
		this.update_date_time = update_date_time;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
}