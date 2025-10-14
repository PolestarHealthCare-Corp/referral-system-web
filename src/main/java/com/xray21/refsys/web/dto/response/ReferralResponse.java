package com.xray21.refsys.web.dto.response;

import com.xray21.refsys.web.domain.Referral;

import java.time.LocalDateTime;

public class ReferralResponse {

    private Long referralId;
    private String userDepartment;
    private String userName;
    private String userPhone;
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
    private LocalDateTime createDateTime;

    public static ReferralResponse from(Referral referral) {
        return new ReferralResponse(
                referral.getReferralId(), referral.getUserDepartment(), referral.getUserName(), referral.getUserPhone(),
                referral.getHospitalName(), referral.getHospitalZipCode(), referral.getHospitalAddress(),
                referral.getHospitalContactName(), referral.getHospitalContactPhone(),
                referral.getXrayCount(), referral.getCtCount(), referral.getMrCount(), referral.getMgCount(),
                referral.getHospitalMemo(), referral.getApprovalType(), referral.getCreateDateTime()
        );
    }

    public ReferralResponse(Long referralId, String userDepartment, String userName, String userPhone, String hospitalName, String hospitalZipCode, String hospitalAddress, String hospitalContactName, String hospitalContactPhone, Integer xrayCount, Integer ctCount, Integer mrCount, Integer mgCount, String hospitalMemo, String approvalType, LocalDateTime createDateTime) {
        this.referralId = referralId;
        this.userDepartment = userDepartment;
        this.userName = userName;
        this.userPhone = userPhone;
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
        this.createDateTime = createDateTime;
    }

    public Long getReferralId() {
        return referralId;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
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

    public String getApprovalType() {
        return approvalType;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

}
