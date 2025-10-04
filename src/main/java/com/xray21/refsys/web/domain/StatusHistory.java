package com.xray21.refsys.web.domain;

import java.time.LocalDateTime;

/** 관리자 상태 변경 이력 **/
public class StatusHistory {

	private Long status_id;
	private Long referral_id;
	private String approval_type;
	private String comment;
	private String use_yn;
	private LocalDateTime created_date_time;
	private String created_by; //변경자 ID
	private String created_by_name; //변경자 이름

	public StatusHistory() {
	}

	public StatusHistory(Long status_id, Long referral_id, String approval_type, String comment,
			String use_yn, String created_by_name, LocalDateTime created_date_time,
			String created_by) {
		this.status_id = status_id;
		this.referral_id = referral_id;
		this.approval_type = approval_type;
		this.comment = comment;
		this.use_yn = use_yn;
		this.created_by_name = created_by_name;
		this.created_date_time = created_date_time;
		this.created_by = created_by;
	}

	public Long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}

	public Long getReferral_id() {
		return referral_id;
	}

	public void setReferral_id(Long referral_id) {
		this.referral_id = referral_id;
	}

	public String getApproval_type() {
		return approval_type;
	}

	public void setApproval_type(String approval_type) {
		this.approval_type = approval_type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getCreated_by_name() {
		return created_by_name;
	}

	public void setCreated_by_name(String created_by_name) {
		this.created_by_name = created_by_name;
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
}
