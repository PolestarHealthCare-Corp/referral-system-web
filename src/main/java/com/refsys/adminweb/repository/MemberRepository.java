package com.refsys.adminweb.repository;

import com.refsys.adminweb.domain.Member;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	private final MemberMapper mapper;

	public void save(Member member) {
		mapper.save(member);
	}

	//TODO Optional 동작 테스트 필요
	public Optional<Member> findByPhone(String memberPhone) {
		return Optional.ofNullable(mapper.findByPhone(memberPhone)); //TODO Null 예외 처리 필요
	}

	public List<Member> findAll() {
		return mapper.findAll();
	}

	public void updateByMember(Member member) {
		mapper.update(member);
	}

}
