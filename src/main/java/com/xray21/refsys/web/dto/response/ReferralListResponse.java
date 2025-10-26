package com.xray21.refsys.web.dto.response;

import com.xray21.refsys.web.domain.Referral;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ReferralListResponse {

	private Long referralId;
	private String hospitalName;
	private String hospitalAddress;
	private List<String> equipmentList;
	private String elapsedTime;

	public static ReferralListResponse from(Referral referral) {
		return new ReferralListResponse(
				referral.getReferralId(), maskedHospitalName(referral.getHospitalName()), createAddress(referral),
				createEquipmentList(referral), calculateElapsedTime(referral.getCreateDateTime())
		);
	}
	public ReferralListResponse(Long referralId, String hospitalName, String hospitalAddress,
			List<String> equipmentList, String elapsedTime) {
		this.referralId = referralId;
		this.hospitalName = hospitalName;
		this.hospitalAddress = hospitalAddress;
		this.equipmentList = equipmentList;
		this.elapsedTime = elapsedTime;
	}

	private static String maskedHospitalName(String hospitalName) {
		if (hospitalName == null || hospitalName.isBlank()) return "";
		String trimmed = hospitalName.trim();
		int len = trimmed.length();
		if (len <= 1) return trimmed;
		if (len == 2) return trimmed.charAt(0) + "*";
		StringBuilder sb = new StringBuilder();
		sb.append(trimmed.charAt(0));
		for (int i = 0; i < len - 2; i++) sb.append("*");
		sb.append(trimmed.charAt(len - 1));
		return sb.toString();
	}

	private static String createAddress(Referral referral) {
		String address = referral.getHospitalAddress();
		if (address != null && !address.isBlank()) {
			address = address.split("\\s+")[0];
		}
		else {
			//예외처리 필요한가?
		}
		return address;
	}

	private static List<String> createEquipmentList(Referral referral) {
		List<String> equipmentList = new ArrayList<>();
		if (referral.getXrayCount() != null && referral.getXrayCount() > 0) equipmentList.add("X-ray");
		if (referral.getCtCount() != null && referral.getCtCount() > 0) equipmentList.add("CT");
		if (referral.getMrCount() != null && referral.getMrCount() > 0) equipmentList.add("MR");
		if (referral.getMgCount() != null && referral.getMgCount() > 0) equipmentList.add("MG");

		return equipmentList;
	}

	private static String calculateElapsedTime(LocalDateTime created) {
		if (created == null) return "";

		LocalDateTime now = LocalDateTime.now();
		Duration duration = Duration.between(created, now);
		long minutes = duration.toMinutes();
		long hours = duration.toHours();
		long days = duration.toDays();

		if (minutes < 60) {
			return minutes <= 0 ? "방금 전" : minutes + "분 전";
		} else if (hours < 24) {
			return hours + "시간 전";
		} else if (days < 7) {
			return days + "일 전";
		} else if (days < 30) {
			long weeks = days / 7;
			return weeks + "주 전";
		} else {
			Period period = Period.between(created.toLocalDate(), now.toLocalDate());
			if (period.getYears() >= 1) {
				return period.getYears() + "년 전";
			} else {
				return period.getMonths() + "개월 전";
			}
		}
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public List<String> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<String> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public String getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
}
