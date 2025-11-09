package com.xray21.refsys.web.dto.response;

import com.xray21.refsys.web.domain.Referral;
import java.time.LocalDateTime;

public class ReferralSaveResponse {

	private Long referralId;
	private String userPhone;
	private String hospitalName;
	private LocalDateTime createDateTime;
	private boolean duplicatedHospital = false;

	public static ReferralSaveResponse from(Referral referral) {
		return new ReferralSaveResponse(referral.getReferralId(), referral.getUserPhone(), referral.getHospitalName(),
				referral.getCreateDateTime());
	}

	public ReferralSaveResponse(Long referralId, String userPhone, String hospitalName,
			LocalDateTime createDateTime) {
		this.referralId = referralId;
		this.userPhone = userPhone;
		this.hospitalName = hospitalName;
		this.createDateTime = createDateTime;
	}

	public void DuplicatedUserAndHospital() {
		this.duplicatedHospital = true;
	}

	public Long getReferralId() {
		return referralId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public boolean isDuplicatedHospital() {
		return duplicatedHospital;
	}
}
