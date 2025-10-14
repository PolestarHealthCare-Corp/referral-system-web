package com.xray21.refsys.web.domain;

import java.time.LocalDateTime;

/** 병원 소개글 변경이력 **/
public class ReferralHistory {

	private Long historyId;
	private Long referralId;
	private String updatedFields;
	private LocalDateTime createDateTime;
	private String createdBy;

	public ReferralHistory() {
	}

	public ReferralHistory(Long historyId, Long referralId, String updatedFields,
						   LocalDateTime createDateTime, String createdBy) {
		this.historyId = historyId;
		this.referralId = referralId;
		this.updatedFields = updatedFields;
		this.createDateTime = createDateTime;
		this.createdBy = createdBy;
	}

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}

	public String getUpdatedFields() {
		return updatedFields;
	}

	public void setUpdatedFields(String updatedFields) {
		this.updatedFields = updatedFields;
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
}
