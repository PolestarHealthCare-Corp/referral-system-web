package com.xray21.refsys.web.dto.request;

public class ReferralSearchCond {

	private String userName;
	private String userPhone;

	//슬라이드 처리
	private Long lastId; // 마지막으로 본 referral_id
	private int limit = 10; // 기본 페이지 크기

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Long getLastId() {
		return lastId;
	}

	public void setLastId(Long lastId) {
		this.lastId = lastId;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
