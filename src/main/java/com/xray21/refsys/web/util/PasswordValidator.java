package com.xray21.refsys.web.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValid, String> {

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		if (password == null || !password.matches("\\d{4}")) {
			return false; // 4자리 숫자만 허용
		}

		// 모두 같은 숫자인 경우 (1111, 0000 등)
		if (password.chars().distinct().count() == 1) return false;

		// 순차 증가 or 감소
		if (isSequential(password, true)) return false;
		if (isSequential(password, false)) return false;

		return true;
	}

	private boolean isSequential(String pwd, boolean ascending) {
		for (int i = 0; i < pwd.length() - 1; i++) {
			int cur = pwd.charAt(i) - '0';
			int next = pwd.charAt(i + 1) - '0';
			if (ascending) {
				if (next - cur != 1) return false;
			} else {
				if (cur - next != 1) return false;
			}
		}
		return true;
	}
}
