package com.xray21.refsys.web.service;

import com.xray21.refsys.web.domain.Referral;
import com.xray21.refsys.web.dto.request.ReferralSaveRequest;
import com.xray21.refsys.web.dto.request.ReferralSearchCond;
import com.xray21.refsys.web.dto.response.ReferralListResponse;
import com.xray21.refsys.web.dto.response.ReferralResponse;
import com.xray21.refsys.web.dto.response.ReferralSaveResponse;
import com.xray21.refsys.web.repository.ReferralRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xray21.refsys.web.dto.request.ReferralUpdateRequest;

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

    //소개 등록
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

    //소개 단건 조회
    public ReferralResponse findByReferralId(Long referralId) {

        Referral findReferral = referralRepository.findById(referralId)
                .orElseThrow(() -> new IllegalArgumentException("referralId(" + referralId + ") not found"));
        return ReferralResponse.from(findReferral);
    }

    //최신 등록된 소개 10개 리스트 조회
    public List<ReferralListResponse> findInitialReferrals() {

        ReferralSearchCond referralSearchCond = ReferralSearchCond.createReferralSearchCond("", "", null, 10);

        List<Referral> referrals = referralRepository.findAllByCondition(referralSearchCond);
//        log.info("조회 결과 : ID:{} 부터 {}건", cond.getLastId(), referrals.size());
        return referrals.stream()
                .map(ReferralListResponse::from)
                .collect(Collectors.toList());
    }


    //소개 조건 검색
    public List<ReferralListResponse> findAllByCondition(String userName, String userPhone, Long lastId, int limit) {

        ReferralSearchCond referralSearchCond = ReferralSearchCond.createReferralSearchCond(userName, userPhone, lastId, limit);

        List<Referral> referrals = referralRepository.findAllByCondition(referralSearchCond);
//        log.info("조회 결과 : ID:{} 부터 {}건", cond.getLastId(), referrals.size());
        return referrals.stream()
                .map(ReferralListResponse::from)
                .collect(Collectors.toList());
    }

    // 소개 수정
    @Transactional
    public ReferralResponse updateReferral(ReferralUpdateRequest request, Long id) {
        log.debug("서비스 시작");

        //requst 파라미터를 Referral 객체로 변경
        Referral referral = referralRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 소개가 없습니다."));

        //실제 db에서 update 실행
        Referral savedReferral = referralRepository.updateReferral(referral);

        //Referral 객체를 ReferralResponse Dto로 변환
        ReferralResponse from = ReferralResponse.from(savedReferral);

        return from;
    }

}
