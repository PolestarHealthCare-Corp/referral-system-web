package com.xray21.refsys.web.domain;

import java.time.LocalDateTime;

/** 관리자 상태 변경 이력 **/
public class StatusHistory {

	private Long statusId;
	private Long referralId;
	private String approvalType; //10(접수), 20(담당자확인), 31(계약성공), 32(계약보류)
	private String comment;
	private String useYn; //Y, N
	private LocalDateTime createdDateTime;
	private String createdBy; //변경자 ID
	private String created_by_name; //변경자 이름

	public StatusHistory() {
	}

	public StatusHistory(Long statusId, Long referralId, String approvalType, String comment,
						 String useYn, String created_by_name, LocalDateTime createdDateTime,
						 String createdBy) {
		this.statusId = statusId;
		this.referralId = referralId;
		this.approvalType = approvalType;
		this.comment = comment;
		this.useYn = useYn;
		this.created_by_name = created_by_name;
		this.createdDateTime = createdDateTime;
		this.createdBy = createdBy;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}

	public String getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getCreated_by_name() {
		return created_by_name;
	}

	public void setCreated_by_name(String created_by_name) {
		this.created_by_name = created_by_name;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
