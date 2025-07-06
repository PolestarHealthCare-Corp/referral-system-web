package com.refsys.adminweb.controller;

import com.refsys.adminweb.domain.Member;
import com.refsys.adminweb.dto.request.MemberSaveRequest;
import com.refsys.adminweb.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

	private final MemberService memberService;

	//TODO ResponseEntity 로 반환, 반환타입 DTO 로 한번더 감싸기.

	@PostMapping("/add")
	public Member save(@RequestBody MemberSaveRequest request) {
		return memberService.saveMember(request);
	}
//	@PostMapping("/add")
//	public ResponseEntity<MemberResponse> save(@RequestBody MemberSaveRequest request) {
//		MemberResponse response = memberService.saveMember(request);
//		return ResponseEntity.ok(response); // 200 OK
//	}

	@GetMapping("/{phone}")
	public Member findByPhone(@PathVariable("phone") String phone) {
		return memberService.findByPhone(phone);
	}

	@GetMapping
	public List<Member> findAll() {
		return memberService.findAll();
	}

}
