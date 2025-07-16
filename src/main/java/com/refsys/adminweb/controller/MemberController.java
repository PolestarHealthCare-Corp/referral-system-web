package com.refsys.adminweb.controller;

import com.refsys.adminweb.dto.request.MemberJoinRequest;
import com.refsys.adminweb.dto.request.MemberUpdateRequest;
import com.refsys.adminweb.dto.response.MemberResponse;
import com.refsys.adminweb.service.MemberService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/new")
	public String createForm(Model model) {

		model.addAttribute("form", new MemberJoinRequest());
		return "members/createMemberForm";
	}

	@PostMapping("/new")
	public String create(@Valid MemberJoinRequest request, BindingResult result) {

		if (result.hasErrors()) {
			return "members/createMemberForm";
		}
		memberService.joinMember(request);
		log.info("회원번호 {}이 가입되었습니다.", request.getMemberPhone());
		return "redirect:/";
	}

	@GetMapping
	public String list(Model model) {

		List<MemberResponse> members = memberService.findAll();
		model.addAttribute("members", members);
		return "members/memberList";
	}

	@GetMapping("/{phone}/edit")
	public String updateMemberForm(@PathVariable("phone") String phone, Model model) {

		MemberResponse form = memberService.findByMemberPhone(phone);
		model.addAttribute("form", form);
		return "members/updateMemberForm";
	}

	@PostMapping("/{phone}/edit")
	public String updateMember(@ModelAttribute("form") MemberUpdateRequest request, @PathVariable("phone") String phone) {

		memberService.updateMember(phone, request);
		log.info("회원번호 {}이 수정되었습니다.", phone);
		return "redirect:/members";
	}

}