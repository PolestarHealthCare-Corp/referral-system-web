package com.refsys.adminweb.dto.request;

import lombok.Getter;

@Getter
public class MemberUpdateRequest {

	private String memberUsername;
	private int memberRole;
	private boolean memberIsActive;

}
