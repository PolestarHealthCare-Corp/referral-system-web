package com.refsys.adminweb.repository;

import com.refsys.adminweb.domain.HospitalInfo;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HospitalInfoRepository {

	private final HospitalInfoMapper mapper;

	public void save(HospitalInfo hospitalInfo) {
		mapper.save(hospitalInfo);
	} //TODO save 시 생성시간 null 로 들어감 스프링에서 시간을 입력해야하나


	public List<HospitalInfo> findByMemberPhone(String phone) {
		return mapper.findByMemberPhone(phone);
	}

	//TODO Optional 동작 테스트 필요
	public Optional<HospitalInfo> findById(Long id) {
		return Optional.ofNullable(mapper.findById(id)); //TODO Null 예외 처리 필요
	}

	public List<HospitalInfo> findAll() {
		return mapper.findAll();
	}

	public void update(HospitalInfo hospitalInfo) {
		mapper.update(hospitalInfo);
	}

}
