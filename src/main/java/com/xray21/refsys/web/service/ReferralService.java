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
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import com.xray21.refsys.web.dto.request.ReferralUpdateRequest;

import java.util.Optional;
import org.springframework.transaction.support.DefaultTransactionDefinition;


/**
 *
 * saveReferral         : 소개 등록
 * findByReferralId     : 소개 단건 조회
 * findInitialReferrals : 최신 등록된 병원소개 10개 리스트 조회
 * updateReferral       : 소개 수정
 *
 */


@Service
@Slf4j
public class ReferralService {
    

    private final PlatformTransactionManager transactionManager;
    private final ReferralRepository referralRepository;

    public ReferralService(PlatformTransactionManager transactionManager, ReferralRepository referralRepository) {
        this.transactionManager = transactionManager;
        this.referralRepository = referralRepository;
    }

    //소개 등록
    public ReferralSaveResponse saveReferral(ReferralSaveRequest request) {

        //병원소개 생성
        Referral referral = Referral.createReferral(request);

        //작성자가 이미 등록한 병원인지 중복체크 //국립중앙의료원_전국 병·의원 찾기 서비스 사용 고려중
        int exists = existsByUserAndHospital(referral.getUserPhone(), request.getHospitalName());

        if (exists == 1) {
            //중복된 병원 체크 -> 소개이력 확인 안내
            ReferralSaveResponse response = ReferralSaveResponse.from(referral);
            response.DuplicatedUserAndHospital();
            return response;
        }

        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {

            //병원소개 저장
            Referral savedReferral = referralRepository.saveReferral(referral);

            transactionManager.commit(status);
            return ReferralSaveResponse.from(savedReferral);

        } catch (DataAccessException e) {
            log.error("DB 접근 실패: {}", e.getMessage());
            transactionManager.rollback(status);
            throw new RuntimeException("데이터베이스 오류가 발생했습니다.", e);

        } catch (IllegalArgumentException e) {
            log.warn("입력값 오류: {}", e.getMessage());
            transactionManager.rollback(status);
            throw new RuntimeException("입력값이 올바르지 않습니다.", e);

        } catch (Exception e) {
            log.error("병원소개 저장 중 알 수 없는 에러 발생");
            transactionManager.rollback(status);
            throw new RuntimeException("시스템 오류가 발생했습니다. 관리자에게 문의하세요.", e);
        }

    }
    private int existsByUserAndHospital(String userPhone, String hospitalName) {
        int exists = referralRepository.existsByUserPhoneAndHospitalName(userPhone, hospitalName);
        return exists;
    }

    //소개 단건 조회
    public ReferralResponse findByReferralId(Long referralId) {

        try {
            //병원소개 단건 조회
            Referral findReferral = referralRepository.findById(referralId)
                    .orElseThrow(() -> new NotFoundException("등록되지 않은 소개(" + referralId + ") 입니다."));
            return ReferralResponse.from(findReferral);

        } catch (NotFoundException e) {
            log.error("등록되지 않은 병원소개 조회: {}", e.getMessage());
            throw new RuntimeException(e.getMessage(), e);

        } catch (DataAccessException e) {
            log.error("DB 접근 실패: {}", e.getMessage());
            throw new RuntimeException("데이터베이스 오류가 발생했습니다.", e);

        } catch (Exception e) {
            log.error("병원소개 단건 조회 중 알 수 없는 에러 발생");
            throw new RuntimeException("시스템 오류가 발생했습니다. 관리자에게 문의하세요.", e);
        }

    }

    //최신 등록된 병원소개 10개 리스트 조회
    public List<ReferralListResponse> findInitialReferrals() {

        try {
            //검색 조건 생성
            ReferralSearchCond referralSearchCond = ReferralSearchCond.createReferralSearchCond("", "", null, 10);

            //병원소개 리스트 조회
            List<Referral> referrals = referralRepository.findAllByCondition(referralSearchCond);
            return referrals.stream()
                    .map(ReferralListResponse::from)
                    .collect(Collectors.toList());

        } catch (IllegalArgumentException e) {
            log.error("병원소개 리스트 조회 실패: {}", e.getMessage());
            throw new RuntimeException(e.getMessage(), e);

        } catch (DataAccessException e) {
            log.error("DB 접근 실패: {}", e.getMessage());
            throw new RuntimeException("데이터베이스 오류가 발생했습니다.", e);

        } catch (Exception e) {
            log.error("병원소개 리스트조회 중 알 수 없는 에러 발생");
            throw new RuntimeException("시스템 오류가 발생했습니다. 관리자에게 문의하세요.", e);
        }

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
