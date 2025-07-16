package com.refsys.adminweb.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class ThymeleafFormatter {

	public static String formatPhone(String phone) {
		if (phone == null || phone.length() != 11) return phone;
		return phone.replaceFirst("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
	}

	public String formatIsActive(boolean isActive) {
		return isActive ? "사용중" : "비활성";
	}

	public String formatRole(int role) {
		return switch (role) {
			case 0 -> "관리자";
			case 1 -> "일반회원";
			default -> "알 수 없음";
		};
	}

	public String formatDateTime(LocalDateTime time) {
		if (time == null) return "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a HH시 mm분 ss초");
		return time.format(formatter);
	}
}
