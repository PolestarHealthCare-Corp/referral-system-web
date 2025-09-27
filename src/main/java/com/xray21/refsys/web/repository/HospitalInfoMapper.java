package com.xray21.refsys.web.repository;

import com.xray21.refsys.web.domain.HospitalInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalInfoMapper {

	void save(HospitalInfo hospitalInfo);

	List<HospitalInfo> findByMemberPhone(String phone);

	HospitalInfo findById(Long id);

	List<HospitalInfo> findAll(); //TODO 파라미터를 넘겨서 동적 검색 구현
	//List<HospitalInfo> findAll(@Param("cond") HospitalInfoSearchCondition cond);

	void update(HospitalInfo hospitalInfo); //TODO 변경이 없는 컬럼도 무조건 업데이트가 되는건지 JPA 의 변경감지와 차이점 확인, <set><if>로 null 체크 후 부분 업데이트 필요

}
