package com.xray21.refsys.web.repository;

import com.xray21.refsys.web.domain.Referral;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReferralMapper {

    Referral findById(Long id);
}
