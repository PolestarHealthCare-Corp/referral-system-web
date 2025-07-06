package com.refsys.adminweb.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Member {

	private String memberPhone; //01012345678
	private String memberUsername;
	private int memberRole; //ADMIN(0), USER(1)
	private boolean memberIsActive; //FALSE(0), TRUE(1)
	private LocalDateTime memberCreatedAt;

}
