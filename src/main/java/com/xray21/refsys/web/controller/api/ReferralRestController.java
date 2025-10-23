package com.xray21.refsys.web.controller.api;

import com.xray21.refsys.web.dto.Response;
import com.xray21.refsys.web.dto.request.ReferralSaveRequest;
import com.xray21.refsys.web.dto.request.ReferralSearchCond;
import com.xray21.refsys.web.dto.request.ReferralUpdateRequest;
import com.xray21.refsys.web.dto.response.ReferralResponse;
import com.xray21.refsys.web.dto.response.ReferralSaveResponse;
import com.xray21.refsys.web.service.ReferralService;
import java.net.URI;

import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/referrals")
@Slf4j
public class ReferralRestController {

    private final ReferralService referralService;

    public ReferralRestController(ReferralService referralService) {
        this.referralService = referralService;
    }

    //병원소개 등록
    @PostMapping
    public ResponseEntity<Response<ReferralSaveResponse>> saveReferral(@RequestBody ReferralSaveRequest request) {

        ReferralSaveResponse result = referralService.saveReferral(request);
        return ResponseEntity.created(URI.create("/api/v1/referrals/"+ result.getReferralId())).body(Response.success(result));
    }

    //병원소개 단건조회
    @GetMapping("/{id}")
    public ResponseEntity<Response<ReferralResponse>> findByReferralId(@PathVariable Long id) {

        ReferralResponse result = referralService.findByReferralId(id);
        return ResponseEntity.ok().body(Response.success(result));
    }

    //병원소개 조건검색
    @GetMapping
    public ResponseEntity<Response<List<ReferralResponse>>> findReferrals(@RequestBody ReferralSearchCond cond) {
        //Slice 도 추가

        List<ReferralResponse> results = referralService.findAllByCondition(cond);
        return ResponseEntity.ok().body(Response.success(results));

    }

    // 병원소개 수정
    @PostMapping("/{id}")
    public ResponseEntity<Response<ReferralResponse>> updateReferral(@Valid @PathVariable Long id, @RequestBody ReferralUpdateRequest request) {

        ReferralResponse result = referralService.updateReferral(request, id);
        return ResponseEntity.ok().body(Response.success(result));
    }
    
}
