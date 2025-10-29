package com.xray21.refsys.web.service;

import com.xray21.refsys.web.domain.Referral;
import com.xray21.refsys.web.dto.request.ReferralSaveRequest;
import com.xray21.refsys.web.dto.response.ReferralResponse;
import com.xray21.refsys.web.dto.response.ReferralSaveResponse;
import com.xray21.refsys.web.repository.ReferralRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xray21.refsys.web.dto.request.ReferralUpdateRequest;

import java.time.LocalDateTime;
import java.util.Optional;


/**
 *
 * saveReferral     : 소개 작성
 * updateReferral   : 소개 수정
 *
 */


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

    // 소개 수정
    @Transactional
    public ReferralResponse updateReferral(Long id, ReferralUpdateRequest request) {
        log.debug("서비스 시작");

        // 1. 기존 Data 조회
        Referral referral = referralRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 병원 소개글이 존재하지 않습니다."));

        // 2. 수정로직 적용
        referral.setHospitalName(request.getHospitalName());
        referral.setHospitalAddress(request.getHospitalAddress());
        referral.setHospitalContactName(request.getHospitalContactName());
        referral.setHospitalContactPhone(request.getHospitalContactPhone());

        // 3. DB 반영
        referralRepository.updateReferral(referral);

        // 4. 수정된 data 다시 조회 후 DTO 변환
        Referral updatedReferral = referralRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정된 데이터를 조회할 수 없음."));

        return ReferralResponse.from(updatedReferral);
    }

}
