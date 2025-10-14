package com.xray21.refsys.web.domain;

import java.time.LocalDateTime;

/** 첨부파일 **/
public class File {

	private Long fileId;
	private Long referralId;
	private String fileName;
	private String filePath;
	//TODO enum 변경 고려
	private String fileType; //10(JPG/JPEG), 11(PNG), 20(PDF), 30(DOC), 31(DOCX), 40(XLS), 41(XLSX), 50(PPT), 51(PPTX), 60(HWP), 99(ETC)
	//TODO enum 변경 고려
	private String useYn; //Y, N
	private LocalDateTime createdDateTime;
	private String createdBy;
	private LocalDateTime updateDateTime;
	private String updatedBy;

	public File() {
	}

	public File(Long fileId, Long referralId, String fileName, String filePath,
				String fileType,
				String useYn, LocalDateTime createdDateTime, String createdBy,
				LocalDateTime updateDateTime, String updatedBy) {
		this.fileId = fileId;
		this.referralId = referralId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileType = fileType;
		this.useYn = useYn;
		this.createdDateTime = createdDateTime;
		this.createdBy = createdBy;
		this.updateDateTime = updateDateTime;
		this.updatedBy = updatedBy;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
