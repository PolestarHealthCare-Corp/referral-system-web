package com.refsys.adminweb.repository;

import com.refsys.adminweb.domain.Member;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	void save(Member member);

	Member findByPhone(String phone);

	List<Member> findAll(); //TODO 파라미터를 넘겨서 동적 검색 구현
	//List<Member> findAll(@Param("cond") MemberSearchCondition cond);

	void update(Member member); //TODO 변경이 없는 컬럼도 무조건 업데이트가 되는건지 JPA 의 변경감지와 차이점 확인, <set><if>로 null 체크 후 부분 업데이트 필요

}
