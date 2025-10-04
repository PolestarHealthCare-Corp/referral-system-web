package com.xray21.refsys.web.domain;

import java.time.LocalDateTime;

/** 병원 소개글 변경이력 **/
public class ReferralHistory {

	private Long history_id;
	private Long referral_id;
	private String updated_fields;
	private LocalDateTime create_date_time;
	private String created_by;

	public ReferralHistory() {
	}

	public ReferralHistory(Long history_id, Long referral_id, String updated_fields,
			LocalDateTime create_date_time, String created_by) {
		this.history_id = history_id;
		this.referral_id = referral_id;
		this.updated_fields = updated_fields;
		this.create_date_time = create_date_time;
		this.created_by = created_by;
	}

	public Long getHistory_id() {
		return history_id;
	}

	public void setHistory_id(Long history_id) {
		this.history_id = history_id;
	}

	public Long getReferral_id() {
		return referral_id;
	}

	public void setReferral_id(Long referral_id) {
		this.referral_id = referral_id;
	}

	public String getUpdated_fields() {
		return updated_fields;
	}

	public void setUpdated_fields(String updated_fields) {
		this.updated_fields = updated_fields;
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
}
