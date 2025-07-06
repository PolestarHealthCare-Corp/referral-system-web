package com.refsys.adminweb.service;

import com.refsys.adminweb.domain.Member;
import com.refsys.adminweb.dto.request.MemberSaveRequest;
import com.refsys.adminweb.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	private final MemberRepository memberRepository;

	//TODO 반환타입 DTO 로 변경, 예외처리, 검증

	@Transactional
	public Member saveMember(MemberSaveRequest request) {
		Member member = new Member(); //TODO 생성자 작성 예정
		member.setMemberPhone(request.getMemberPhone());
		member.setMemberUsername(request.getMemberUsername());
		member.setMemberRole(1);
		member.setMemberIsActive(true);
		memberRepository.save(member);
		return member;
	}

	public Member findByPhone(String phone) {
		Member findMember = memberRepository.findByPhone(phone).get(); //TODO null 처리 예정
//		return memberRepository.findByPhone(phone)
//				.orElseThrow(() -> new NoSuchElementException("해당 번호의 회원이 존재하지 않습니다: " + phone));

		return findMember;
	}

	public List<Member> findAll() { //TODO 동적 검색 구현 예정
		return memberRepository.findAll();
	}

}
