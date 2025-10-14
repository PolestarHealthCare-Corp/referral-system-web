package com.xray21.refsys.web.service;

import com.xray21.refsys.web.domain.Referral;
import com.xray21.refsys.web.dto.response.ReferralResponse;
import com.xray21.refsys.web.repository.ReferralRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReferralService {

    private final ReferralRepository referralRepository;

    public ReferralService(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    public ReferralResponse findByReferralId(Long referralId) {

        Referral findReferral = referralRepository.findById(referralId)
                .orElseThrow(() -> new IllegalArgumentException("referralId(" + referralId + ") not found"));
        return ReferralResponse.from(findReferral);
    }
}
