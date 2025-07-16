package com.refsys.adminweb.service;

import com.refsys.adminweb.domain.Member;
import com.refsys.adminweb.dto.request.MemberJoinRequest;
import com.refsys.adminweb.dto.request.MemberSearchCond;
import com.refsys.adminweb.dto.request.MemberUpdateRequest;
import com.refsys.adminweb.dto.response.MemberJoinResponse;
import com.refsys.adminweb.dto.response.MemberResponse;
import com.refsys.adminweb.dto.response.MemberUpdateResponse;
import com.refsys.adminweb.repository.MemberRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public MemberJoinResponse joinMember(MemberJoinRequest request) {

		checkDuplicatePhone(request.getMemberPhone());
		Member member = Member.createMember(request); //비밀번호가 없어서 암호화 과정 생략
		Member savedMember = memberRepository.saveMember(member);
		return MemberJoinResponse.from(savedMember);
	}

	public MemberResponse findByMemberPhone(String phone) {

		Member findMember = memberRepository.findByPhone(phone)
				.orElseThrow(() -> new NoSuchElementException("해당 번호의 회원이 존재하지 않습니다: " + phone));
		return MemberResponse.from(findMember);
	}

	//TODO 동적 검색 구현, MemberSearch 파라미터 전달, mapper, repository 변경 예정
	public List<MemberResponse> findAll(MemberSearchCond condition) {
		return memberRepository.findAll(condition).stream()
				.map(member -> MemberResponse.from(member))
				.collect(Collectors.toList());
	}

	@Transactional
	public MemberUpdateResponse updateMember(String phone, MemberUpdateRequest request) {

		//관리자만 회원의 정보를 수정할 수 있다. -> 로그인 phone == 변경 phone 일치여부 확인하지 않음.

		Member findMember = memberRepository.findByPhone(phone)
				.orElseThrow(() -> new NoSuchElementException("해당 번호의 회원이 존재하지 않습니다: " + phone));
		findMember.update(request);
		Member updatedMember = memberRepository.updateMember(findMember);
		return MemberUpdateResponse.from(updatedMember);
	}

	private void checkDuplicatePhone(String phone) {
		boolean exists = memberRepository.countByPhone(phone) > 0;
		if (exists) throw new IllegalStateException("이미 가입된 번호 입니다: " + phone);
	}
}
