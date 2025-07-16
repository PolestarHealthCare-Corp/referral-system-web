package com.refsys.adminweb.service;

import com.refsys.adminweb.domain.HospitalInfo;
import com.refsys.adminweb.dto.request.HospitalInfoSaveRequest;
import com.refsys.adminweb.repository.HospitalInfoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HospitalInfoService {

	private final HospitalInfoRepository hospitalInfoRepository;

	//TODO 반환타입 DTO 로 변경, 예외처리, 검증

	@Transactional
	public HospitalInfo save(HospitalInfoSaveRequest request) {
		HospitalInfo info = new HospitalInfo();
		info.setMemberPhone(request.getMemberPhone());
		info.setHospitalInfoName(request.getHospitalInfoName());
		info.setHospitalInfoAddress(request.getHospitalInfoAddress());
		info.setHospitalInfoContactName(request.getHospitalInfoContactName());
		info.setHospitalInfoContactPhone(request.getHospitalInfoContactPhone());
		info.setHospitalInfoMemo(request.getHospitalInfoMemo());
		info.setHospitalInfoIsActive(true);
		hospitalInfoRepository.save(info);
		return info;

	}

	public List<HospitalInfo> findByMemberPhone(String phone) { //TODO 동적 검색 구현 예정
		return hospitalInfoRepository.findByMemberPhone(phone);
	}

	public HospitalInfo findById(Long id) {
		HospitalInfo findHospitalInfo = hospitalInfoRepository.findById(id).get();//TODO null 처리 예정
//		return hospitalInfoRepository.findByPhone(phone)
//				.orElseThrow(() -> new NoSuchElementException("해당 번호의 회원이 존재하지 않습니다: " + phone));

		return findHospitalInfo;
	}

	public List<HospitalInfo> findAll() { //TODO 동적 검색 구현 예정
		return hospitalInfoRepository.findAll();
	}

}
