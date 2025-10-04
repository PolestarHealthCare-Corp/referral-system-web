package com.xray21.refsys.web.domain;

import java.time.LocalDateTime;

/** 첨부파일 **/
public class File {

	private Long file_id;
	private Long referral_id;
	private String file_name;
	private String file_path;
	private String file_type;
	private String use_yn;
	private LocalDateTime created_date_time;
	private String created_by;
	private LocalDateTime update_date_time;
	private String updated_by;

	public File() {
	}

	public File(Long file_id, Long referral_id, String file_name, String file_path,
			String file_type,
			String use_yn, LocalDateTime created_date_time, String created_by,
			LocalDateTime update_date_time, String updated_by) {
		this.file_id = file_id;
		this.referral_id = referral_id;
		this.file_name = file_name;
		this.file_path = file_path;
		this.file_type = file_type;
		this.use_yn = use_yn;
		this.created_date_time = created_date_time;
		this.created_by = created_by;
		this.update_date_time = update_date_time;
		this.updated_by = updated_by;
	}

	public Long getFile_id() {
		return file_id;
	}

	public void setFile_id(Long file_id) {
		this.file_id = file_id;
	}

	public Long getReferral_id() {
		return referral_id;
	}

	public void setReferral_id(Long referral_id) {
		this.referral_id = referral_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public LocalDateTime getCreated_date_time() {
		return created_date_time;
	}

	public void setCreated_date_time(LocalDateTime created_date_time) {
		this.created_date_time = created_date_time;
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
