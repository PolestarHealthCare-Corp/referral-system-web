package com.refsys.adminweb.domain;

import com.refsys.adminweb.dto.request.MemberJoinRequest;
import com.refsys.adminweb.dto.request.MemberUpdateRequest;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {

	private String memberPhone; //01012345678
	private String memberUsername;
	private int memberRole; //ADMIN(0), USER(1)
	private boolean memberIsActive; //FALSE(0), TRUE(1)
	private LocalDateTime memberCreatedAt;

	//생성메서드
	public static Member createMember(MemberJoinRequest request) {
		return new Member(request);
	}
	public Member(MemberJoinRequest request) {
		this.memberPhone = request.getMemberPhone();
		this.memberUsername = request.getMemberUsername();
		this.memberRole = 1;
		this.memberIsActive = true;
		this.memberCreatedAt = LocalDateTime.now(); //시간 자동 적용 전략 있던걸로 아는데 뭐지
	}

	public void update(MemberUpdateRequest request) {
		this.memberUsername = request.getMemberUsername();
		this.memberRole = request.getMemberRole();
		this.memberIsActive = request.isMemberIsActive();
	}
}
