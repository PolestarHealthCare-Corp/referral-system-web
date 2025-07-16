package com.refsys.adminweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberUpdateRequest {

	private String memberUsername;
	private Integer memberRole;
	private boolean memberIsActive;

}
