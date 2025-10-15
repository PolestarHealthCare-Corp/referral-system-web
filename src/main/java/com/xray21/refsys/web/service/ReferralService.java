package com.xray21.refsys.web.service;

import com.xray21.refsys.web.domain.Referral;
import com.xray21.refsys.web.dto.request.ReferralSaveRequest;
import com.xray21.refsys.web.dto.response.ReferralResponse;
import com.xray21.refsys.web.dto.response.ReferralSaveResponse;
import com.xray21.refsys.web.repository.ReferralRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
public class ReferralService {

    private final ReferralRepository referralRepository;

    public ReferralService(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    @Transactional
    public ReferralSaveResponse saveReferral(ReferralSaveRequest request) {

        //작성자가 이미 소개한 병원인지 확인
        existsByUserAndHospital(request);

        Referral referral = Referral.createReferral(request);

        Referral savedReferral = referralRepository.saveReferral(referral);
        return ReferralSaveResponse.from(savedReferral);
    }

    private void existsByUserAndHospital(ReferralSaveRequest request) {
        int exists = referralRepository.existsByUserPhoneAndHospitalName(request.getUserPhone(),
                request.getHospitalName());
        if (exists == 1) {
            log.error("작성자({}) 이미 소개한 병원({})입니다.", request.getUserPhone(), request.getHospitalName());
            throw new IllegalStateException("이미 소개해주신 병원입니다. 소개 작성 내역을 확인해주세요.");
        }
    }

    public ReferralResponse findByReferralId(Long referralId) {

        Referral findReferral = referralRepository.findById(referralId)
                .orElseThrow(() -> new IllegalArgumentException("referralId(" + referralId + ") not found"));
        return ReferralResponse.from(findReferral);
    }
}
