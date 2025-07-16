package com.refsys.adminweb.dto.response;

import com.refsys.adminweb.domain.Member;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberUpdateResponse {

	private String memberPhone; //01012345678
	private String memberUsername;
	private int memberRole; //ADMIN(0), USER(1)
	private boolean memberIsActive; //FALSE(0), TRUE(1)
	private LocalDateTime memberCreatedAt;

	public static MemberUpdateResponse from(Member member) {
		return new MemberUpdateResponse(member.getMemberPhone(), member.getMemberUsername(), member.getMemberRole(), member.isMemberIsActive(), member.getMemberCreatedAt());
	}

}
