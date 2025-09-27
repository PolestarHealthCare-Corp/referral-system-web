package com.xray21.refsys.web.dto.request;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter @Setter
public class MemberSearchCond {

	private String memberPhone; //01012345678
	private String memberUsername;
	private Integer memberRole; //ADMIN(0), USER(1)
	private Boolean memberIsActive = true; //FALSE(0), TRUE(1)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createdAtStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createdAtEnd;
	private String sortBy;   // 예: "memberPhone"
	private String sortDir;  // "asc" 또는 "desc"
}
