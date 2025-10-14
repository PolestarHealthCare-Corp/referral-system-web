package com.xray21.refsys.web.repository;

import com.xray21.refsys.web.domain.Referral;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ReferralRepository {

    private final ReferralMapper mapper;

    public ReferralRepository(ReferralMapper mapper) {
        this.mapper = mapper;
    }

    public Optional<Referral> findById(long id) {
        return Optional.ofNullable(mapper.findById(id));
    }

}
