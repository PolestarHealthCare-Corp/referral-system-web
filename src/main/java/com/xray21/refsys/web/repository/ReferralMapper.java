package com.xray21.refsys.web.repository;

import com.xray21.refsys.web.domain.Referral;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReferralMapper {

    void save(Referral referral);

    int existsByUserPhoneAndHospitalName(String userPhone, String hospitalName);

    Referral findById(Long id);

    void update(Referral referral);


}
