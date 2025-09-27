package com.xray21.refsys.web.controller.api;

import com.xray21.refsys.web.domain.HospitalInfo;
import com.xray21.refsys.web.dto.request.HospitalInfoSaveRequest;
import com.xray21.refsys.web.service.HospitalInfoService;
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
@RequestMapping("/hospitals")
public class HospitalInfoRestController {

	private final HospitalInfoService hospitalInfoService;

	//TODO ResponseEntity 로 반환, 반환타입 DTO 로 한번더 감싸기.

	@PostMapping("/add")
	public HospitalInfo save(@RequestBody HospitalInfoSaveRequest hospitalInfo) {
		return hospitalInfoService.save(hospitalInfo);
	}
//	@PostMapping("/add")
//	public ResponseEntity<HospitalInfoResponse> save(@RequestBody HospitalInfoSaveRequest request) {
//		HospitalInfoResponse response = hospitalInfoService.saveHospitalInfo(request);
//		return ResponseEntity.ok(response); // 200 OK
//	}

	@GetMapping("/phone/{phone}")
	public List<HospitalInfo> findByMemberPhone(@PathVariable("phone") String phone) {
		return hospitalInfoService.findByMemberPhone(phone);
	}

	@GetMapping("/{id}")
	public HospitalInfo findById(@PathVariable("id") Long id) {
		return hospitalInfoService.findById(id);
	}

	@GetMapping
	public List<HospitalInfo> findAll() {
		return hospitalInfoService.findAll();
	}

}
