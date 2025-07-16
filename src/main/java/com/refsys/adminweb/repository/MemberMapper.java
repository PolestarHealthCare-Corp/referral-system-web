package com.refsys.adminweb.repository;

import com.refsys.adminweb.domain.Member;
import com.refsys.adminweb.dto.request.MemberSearchCond;
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
