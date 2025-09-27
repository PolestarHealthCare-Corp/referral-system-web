package com.xray21.refsys.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberUpdateRequest {

	private String memberUsername;
	private Integer memberRole;
	private Boolean memberIsActive;

}
