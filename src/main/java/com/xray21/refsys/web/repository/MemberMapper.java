package com.xray21.refsys.web.repository;

import com.xray21.refsys.web.domain.Member;
import com.xray21.refsys.web.dto.request.MemberSearchCond;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	void save(Member member);

	int countByPhone(String phone);

	Member findByPhone(String phone);

	List<Member> findAll(MemberSearchCond cond);

	void update(Member member);

}
