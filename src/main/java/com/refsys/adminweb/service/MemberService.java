package com.refsys.adminweb.service;

import com.refsys.adminweb.domain.Member;
import com.refsys.adminweb.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

//	public Member saveMember(MemberSaveRequest request) {
//		Member member = new Member();
//		member.setMemberPhone(request.);
//		memberRepository.save();
//	}

}
