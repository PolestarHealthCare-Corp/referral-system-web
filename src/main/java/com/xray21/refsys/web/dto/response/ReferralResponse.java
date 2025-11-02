package com.xray21.refsys.web.dto.response;

import com.xray21.refsys.web.domain.Referral;

import java.time.LocalDateTime;

public class ReferralResponse {

    private Long referralId;
    private String userDepartment;
    private String userName;
    private String userPhoneFront;
    private String userPhoneMiddle;
    private String userPhoneBack;
    private String hospitalName;
    private String hospitalZipCode;
    private String hospitalAddress;
    private String hospitalContactName;
    private String hospitalContactPhoneFront;
    private String hospitalContactPhoneMiddle;
    private String hospitalContactPhoneBack;
    private Integer xrayCount;
    private Integer ctCount;
    private Integer mrCount;
    private Integer mgCount;
    private String hospitalMemo;
    private String approvalType; //10(접수), 20(담당자확인), 31(계약성공), 32(계약보류)
    private LocalDateTime createDateTime;

    public static ReferralResponse from(Referral referral) {
        return new ReferralResponse(
                referral.getReferralId(), referral.getUserDepartment(), referral.getUserName(),
                splitPhoneNumber(referral.getUserPhone()).front, splitPhoneNumber(referral.getUserPhone()).middle,
                splitPhoneNumber(referral.getUserPhone()).back, referral.getHospitalName(),
                referral.getHospitalZipCode(), referral.getHospitalAddress(),
                referral.getHospitalContactName(), splitPhoneNumber(referral.getHospitalContactPhone()).front,
                splitPhoneNumber(referral.getHospitalContactPhone()).middle, splitPhoneNumber(referral.getHospitalContactPhone()).back,
                referral.getXrayCount(), referral.getCtCount(), referral.getMrCount(), referral.getMgCount(),
                referral.getHospitalMemo(), referral.getApprovalType(), referral.getCreateDateTime()
        );
    }

    public ReferralResponse(Long referralId, String userDepartment, String userName,
            String userPhoneFront, String userPhoneMiddle, String userPhoneBack,
            String hospitalName,
            String hospitalZipCode, String hospitalAddress, String hospitalContactName,
            String hospitalContactPhoneFront, String hospitalContactPhoneMiddle,
            String hospitalContactPhoneBack, Integer xrayCount, Integer ctCount, Integer mrCount,
            Integer mgCount, String hospitalMemo, String approvalType,
            LocalDateTime createDateTime) {
        this.referralId = referralId;
        this.userDepartment = userDepartment;
        this.userName = userName;
        this.userPhoneFront = userPhoneFront;
        this.userPhoneMiddle = userPhoneMiddle;
        this.userPhoneBack = userPhoneBack;
        this.hospitalName = hospitalName;
        this.hospitalZipCode = hospitalZipCode;
        this.hospitalAddress = hospitalAddress;
        this.hospitalContactName = hospitalContactName;
        this.hospitalContactPhoneFront = hospitalContactPhoneFront;
        this.hospitalContactPhoneMiddle = hospitalContactPhoneMiddle;
        this.hospitalContactPhoneBack = hospitalContactPhoneBack;
        this.xrayCount = xrayCount;
        this.ctCount = ctCount;
        this.mrCount = mrCount;
        this.mgCount = mgCount;
        this.hospitalMemo = hospitalMemo;
        this.approvalType = approvalType;
        this.createDateTime = createDateTime;
    }

    private static PhoneParts splitPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("전화번호가 비어 있습니다.");
        }

        // 유효성 체크
        if (phoneNumber.length() < 7 || phoneNumber.length() > 11) {
            throw new IllegalArgumentException("전화번호 형식이 올바르지 않습니다: " + phoneNumber);
        }

        String front;
        String middle;
        String back;

        // 자릿수에 따라 분리 방식 결정
        if (phoneNumber.startsWith("02")) { // 서울 번호 (2자리 지역번호)
            front = phoneNumber.substring(0, 2);
            if (phoneNumber.length() == 9) { // 02-XXX-XXXX
                middle = phoneNumber.substring(2, 5);
                back = phoneNumber.substring(5);
            } else { // 02-XXXX-XXXX
                middle = phoneNumber.substring(2, 6);
                back = phoneNumber.substring(6);
            }
        } else { // 휴대폰 또는 3자리 지역번호
            front = phoneNumber.substring(0, 3);
            if (phoneNumber.length() == 10) { // 010-XXX-XXXX
                middle = phoneNumber.substring(3, 6);
                back = phoneNumber.substring(6);
            } else { // 010-XXXX-XXXX (11자리)
                middle = phoneNumber.substring(3, 7);
                back = phoneNumber.substring(7);
            }
        }

        return new PhoneParts(front, middle, back);
    }

    public static class PhoneParts {
        private final String front;
        private final String middle;
        private final String back;

        public PhoneParts(String front, String middle, String back) {
            this.front = front;
            this.middle = middle;
            this.back = back;
        }

        public String getFront() { return front; }
        public String getMiddle() { return middle; }
        public String getBack() { return back; }
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

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}
