package com.xray21.refsys.web.repository;

import com.xray21.refsys.web.domain.Referral;
import com.xray21.refsys.web.dto.request.ReferralSearchCond;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReferralMapper {

    void save(Referral referral);

    int existsByUserPhoneAndHospitalName(String userPhone, String hospitalName);

    Referral findById(Long id);

    List<Referral> findAllByCondition(ReferralSearchCond cond);

    void update(Referral referral);


}
