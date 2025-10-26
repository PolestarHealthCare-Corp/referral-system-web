package com.xray21.refsys.web.controller;

import com.xray21.refsys.web.dto.response.ReferralListResponse;
import com.xray21.refsys.web.service.ReferralService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ReferralController {

	private final ReferralService referralService;

	public ReferralController(ReferralService referralService) {
		this.referralService = referralService;
	}

	@RequestMapping("/")
	public String home(Model model) {

		//총 카운트 필요
		//새로 고침 누르면 아래의 서비스 로직
		List<ReferralListResponse> referrals = referralService.findInitialReferrals();
		model.addAttribute("referrals", referrals);
		return "/index";
//		return "/home";
	}

	@GetMapping("/referrals/new")
	public String createForm() {
		return "/referrals/createReferralForm";
	}

}
