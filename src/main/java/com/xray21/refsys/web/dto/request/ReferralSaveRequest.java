package com.xray21.refsys.web.dto.request;

import com.xray21.refsys.web.util.PasswordValid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ReferralSaveRequest {

	@Size(max = 10)
	private String userDepartment;
	@NotBlank
	@Size(max = 5)
	private String userName;
	@NotBlank
	@Pattern(regexp = "^(0(2|3[1-3]|4[1-4]|5[1-5]|6[1-4]|70|80|10|11|16|17|18|19))$")
	private String userPhoneFront;
	@NotBlank
	@Pattern(regexp = "^\\d{3,4}$")
	private String userPhoneMiddle;
	@NotBlank
	@Pattern(regexp = "^\\d{4}$")
	private String userPhoneBack;
	@NotBlank
	@Pattern(regexp = "^\\d{4}$")
	@PasswordValid
	private String userPassword;
	@NotBlank
	@Size(max = 28)
	private String hospitalName;
	@NotBlank
	@Size(max = 5)
	private String hospitalZipCode;
	@NotBlank
	@Size(max = 200)
	private String hospitalAddress;
	@NotBlank
	@Size(max = 5)
	private String hospitalContactName;
	@NotBlank
	@Pattern(regexp = "^(0(2|3[1-3]|4[1-4]|5[1-5]|6[1-4]|70|80|10|11|16|17|18|19))$")
	private String hospitalContactPhoneFront;
	@NotBlank
	@Pattern(regexp = "^\\d{3,4}$")
	private String hospitalContactPhoneMiddle;
	@NotBlank
	@Pattern(regexp = "^\\d{4}$")
	private String hospitalContactPhoneBack;
	@Max(30)
	private Integer xrayCount;
	@Max(30)
	private Integer ctCount;
	@Max(30)
	private Integer mrCount;
	@Max(30)
	private Integer mgCount;
	@Size(max = 500)
	private String hospitalMemo;
	private String agreePersonalInfo = "원격판독센터 ‘21세기영상의학과의원’(http://www.xray21.com, 이하 ‘센터’) 홈페이지는 고객님의 개인정보를 소중하게 생각하며, 고객님의 개인정보를 보호하기 위하여 항상 최선을 다해 노력하고 있습니다.\n"
			+ "\n"
			+ "센터는 이를 위해 개인정보보호 관련 주요 법률인 「정보통신망 이용촉진 및 정보보호에 관한 법률」, 「개인정보보호법」을 준수하고 있습니다. 센터는 개인정보취급방침을 제정하여 이를 사이트 내에 공개하고 고객님이 언제나 용이하게 열람할 수 있도록 함으로써, 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되는지에 대하여 알려드립니다.\n"
			+ "\n"
			+ "센터의 개인정보취급방침은 관련 법률 및 지침의 변경 또는 내부 운영 방침의 변경에 따라 변경될 수 있습니다.\n"
			+ "고객님께서는 센터 홈페이지에 방문하셔서 개인정보취급방침을 수시로 확인하여 주시기 바랍니다.\n"
			+ "\n"
			+ "이 개인정보처리방침의 순서는 다음과 같습니다.\n"
			+ "\n"
			+ "1.수집하는 개인정보 항목 및 수집방법\n"
			+ "2.개인정보의 수집 및 이용목적\n"
			+ "3.개인정보의 보유 및 이용기간\n"
			+ "4.개인정보의 파기절차 및 방법\n"
			+ "5.수집한 개인정보의 위탁\n"
			+ "6.제3자에게의 개인정보 제공\n"
			+ "7.이용자 및 법정대리인의 권리와 그 행사방법\n"
			+ "8.개인정보 자동수집 장치의 설치, 운영 및 그 거부에 관한 사항\n"
			+ "9.기타 개인정보 취급에 관한 방침\n"
			+ "10.개인정보 관리책임자 및 상담ㆍ신고\n"
			+ "11.개인정보 처리방침 변경\n"
			+ "\n"
			+ "○ 본 방침은 2014년 12월 22일부터 시행됩니다.\n"
			+ "\n"
			+ "1. 수집하는 개인정보 항목 및 수집방법\n"
			+ "\n"
			+ "(1) 수집하는 개인정보의 항목\n"
			+ "센터는 상담, 서비스 신청 등을 위해 이용자로부터 아래와 같은 개인정보를 수집하고 있습니다.\n"
			+ "\n"
			+ "수집항목 : 성명, 기관명, 부서명, 직급명, 직장 전화번호, 휴대 전화번호, 이메일 주소\n"
			+ "또한, 서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 생성되어 수집될 수 있습니다.\n"
			+ "\n"
			+ "서비스 이용기록, 접속로그, 쿠키\n"
			+ "※ 센터는 이용자의 사생활을 현저히 침해할 우려가 있는 민감정보(사상·신념, 노동조합·정당의 가입·탈퇴, 정치적 견해, 건강, 성생활 등에 관한 정보 등)는 수집하지 않습니다.\n"
			+ "\n"
			+ "※ 센터는 원칙적으로 이용자가 만 14세 미만자일 경우 개인정보를 수집하지 않습니다. 부득이 서비스 이용을 위하여 만 14세 미만자의 개인정보를 수집할 때에는, 사전에 법정대리인의 동의를 구하고 관련 업무가 종료됨과 동시에 정보를 지체 없이 파기토록 하겠으며 업무가 진행되는 동안 개인정보를 철저히 관리토록 하겠습니다.\n"
			+ "\n"
			+ "(2) 개인정보 수집방법\n"
			+ "홈페이지(문의 게시판 등), 서면양식, 팩스/전화/이메일 등을 통한 수집\n"
			+ "생성정보 수집 툴을 통한 수집\n"
			+ "※ 센터는 이용자께서 센터의 개인정보 수집•이용 동의서 각각의 내용에 대해 “동의” 또는 “동의하지 않음”을 선택할 수 있는 절차를 마련하고 있습니다.\n"
			+ "\n"
			+ "2. 개인정보의 수집 및 이용목적\n"
			+ "\n"
			+ "센터는 수집한 개인정보를 다음의 목적을 위해 활용합니다.\n"
			+ "\n"
			+ "(1) 고객관리\n"
			+ "불만처리 등 민원처리, 고지사항 전달\n"
			+ "(2) 서비스 제공\n"
			+ "서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 콘텐츠 제공\n"
			+ "(3) 마케팅 및 광고에 활용\n"
			+ "이벤트 등 광고성 정보 전달, 이벤트 당첨 시 물품배송\n"
			+ "신규 서비스 개발 및 특화, 인구통계학적 특성에 따른 서비스 제공 및 광고 게재\n"
			+ "접속 빈도 파악 또는 회원의 서비스 이용에 대한 통계\n"
			+ "\n"
			+ "3. 개인정보의 보유 및 이용기간\n"
			+ "\n"
			+ "원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한 기간 동안 회원정보를 보관합니다. 이 경우 회사는 해당 개인정보를 별도의 데이터베이스(DB)로 옮기거나 보관 장소를 달리하여 보존합니다.\n"
			+ "\n"
			+ "보존 항목: 신용정보의 수집/처리 및 이용 등에 관한 기록\n"
			+ "보존 근거: 신용정보의 이용 및 보호에 관한 법률\n"
			+ "보존 기간: 3년\n"
			+ "\n"
			+ "4. 개인정보의 파기절차 및 방법\n"
			+ "\n"
			+ "센터는 원칙적으로 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 파기절차 및 방법은 다음과 같습니다.\n"
			+ "\n"
			+ "(1) 파기절차\n"
			+ "이용자의 개인정보는 목적이 달성된 후 별도의 DB로 옮겨져(종이의 경우 별도의 서류함) 내부 방침 및 기타 관련 법령에 의한 정보보호 사유에 따라(보유 및 이용기간 참조) 일정 기간 저장된 후 파기됩니다. 별도 DB로 옮겨진 개인정보는 법률에 의한 경우가 아니고서는 보유되는 이외의 다른 목적으로 이용되지 않습니다.\n"
			+ "\n"
			+ "(2) 파기방법\n"
			+ "전자적 파일형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제합니다. 종이에 출력된 개인정보는 분쇄기로 분쇄하거나 소각을 통하여 파기합니다.\n"
			+ "\n"
			+ "5. 수집한 개인정보의 위탁\n"
			+ "\n"
			+ "센터는 서비스 이행을 위해 필요한 경우 아래와 같이 개인정보 처리 업무를 외부 전문업체에 위탁하여 처리할 수 있습니다. 개인정보 처리위탁은 개별 서비스 별로 그 이행을 위해 필요한 경우에 한해 각 위탁업체에 대해 이루어집니다.\n"
			+ "\n"
			+ "개인정보의 처리를 위탁하는 경우에는 개인정보 보호의 안전을 기하기 위하여 개인정보보호 관련 지시엄수, 개인정보에 대한 비밀유지, 제3자 제공의 금지 및 사고시의 책임부담, 위탁기간, 처리 종료 후의 개인정보의 반환 또는 파기 등을 명확히 규정하고, 위탁업체가 개인정보를 안전하게 처리하도록 감독합니다.\n"
			+ "\n"
			+ "업체, 위탁하는 업무의 내용이 변경될 경우, 웹사이트 공지사항(또는 서면•이메일•전화•SMS 등의 방법으로 개별공지)을 통하여 알려드리겠습니다.\n"
			+ "\n"
			+ "6. 제3자에게의 개인정보 제공\n"
			+ "\n"
			+ "센터는 이용자의 개인정보를 원칙적으로 외부에 제공하지 않습니다. 다만, 아래의 경우에는 예외로 합니다.\n"
			+ "\n"
			+ "법령의 규정에 의거하거나, 수사 목적으로 법령에 정해진 절차와 방법에 따라 수사기관의 요구가 있는 경우\n"
			+ "서비스 제공에 따른 요금 정산을 위하여 필요한 경우\n"
			+ "통계작성, 학술연구나 시장조사를 위해 특정 개인을 식별할 수 없는 형태로 가공하여 제공하는 경우\n"
			+ "이용자들이 사전에 동의한 경우\n"
			+ "\n"
			+ "7. 이용자 및 법정대리인의 권리와 그 행사방법\n"
			+ "\n"
			+ "이용자 및 법정대리인은 등록되어 있는 이용자 본인 혹은 당해 만 14세 미만자의 개인정보 관련하여, 언제든지 개인정보 열람/ 정정•삭제/ 처리정지/ 동의 철회를 요청할 수 있습니다.\n"
			+ "\n"
			+ "센터는 다음에 해당하는 경우에는 개인정보의 전부 또는 일부에 대하여 열람/ 정정•삭제를 거절할 수 있습니다.\n"
			+ "\n"
			+ "법률에 따라 열람이 금지되거나 제한되는 경우\n"
			+ "다른 사람의 생명•신체를 해할 우려가 있거나 다른 사람의 재산과 그 밖의 이익을 부당하게 침해할 우려가 있는 경우\n"
			+ "이용자가 개인정보의 오류에 대한 정정을 요청하신 경우에는 정정을 완료하기 전까지 당해 개인정보를 이용 또는 제3자에게 제공하지 않습니다. 또한 잘못된 개인정보를 제3자에게 이미 제공한 경우에는 정정 처리결과를 제3자에게 지체 없이 통지하겠습니다.\n"
			+ "\n"
			+ "센터는 이용자 혹은 법정대리인의 요청에 의해 삭제/ 처리정지된 개인정보는 “3. 개인정보의 보유 및 이용기간”에 명시된 바에 따라 처리하고 그 외의 용도로 열람 또는 이용할 수 없도록 처리하고 있습니다.\n"
			+ "\n"
			+ "8. 개인정보 자동수집 장치의 설치, 운영 및 그 거부에 관한 사항\n"
			+ "\n"
			+ "센터는 이용자의 정보를 수시로 저장하고 찾아내는 ‘쿠키(cookie)’ 등을 운용합니다. 쿠키란 센터의 웹사이트를 운영하는데 이용되는 서버가 이용자의 브라우저에 보내는 아주 작은 텍스트 파일로, 이용자의 컴퓨터 하드디스크에 저장됩니다.\n"
			+ "\n"
			+ "(1) 쿠키 등 사용 목적\n"
			+ "접속 빈도나 방문 시간 등을 분석, 이용자의 취향과 관심분야를 파악 및 자취 추적, 방문 회수 파악 등을 통한 타겟 마케팅\n"
			+ "\n"
			+ "(2) 쿠키 설정 거부 방법\n"
			+ "이용자는 쿠키 설치에 대한 선택권을 가지고 있습니다. 따라서 웹브라우저에서 옵션을 설정함으로써 모든 쿠키를 허용하거나, 쿠키가 저장될 때마다 확인을 거치거나, 아니면 모든 쿠키의 저장을 거부할 수도 있습니다.\n"
			+ "단, 이용자께서 쿠키 설치를 거부하였을 경우 서비스 제공에 어려움이 있을 수 있습니다.\n"
			+ "\n"
			+ "쿠키설정 방법 (인터넷 익스플로러8.0을 사용하고 있는 경우) : 「도구」메뉴에서「인터넷옵션」을 선택합니다.「개인정보 탭」을 클릭합니다. 「설정」을 이용하여 본인에게 맞는 쿠키허용 수준을 설정하시면 됩니다.\n"
			+ "받은 쿠키를 보는 방법 (익스플로러8.0을 사용하고 있는 경우) : 「도구」 메뉴에서 「인터넷옵션」 을 선택합니다. 「일반」 탭을 클릭하여 ‘검색기록’ 의 「설정」 으로 들어가서, 「파일보기」 를 통해 확인합니다.\n"
			+ "쿠키 설정 거부 방법 (인터넷 익스플로어 8.0 사용하고 있는 경우 : 「도구」 메뉴에서 「인터넷옵션」 을 선택합니다. 「개인정보 탭」 을 클릭합니다. 「설정」 을 이용하여 상위레벨로 하여 “모든 쿠키차단” 으로 설정하시면 됩니다.\n"
			+ "\n"
			+ "9. 기타 개인정보 취급에 관한 방침\n"
			+ "\n"
			+ "(1) 개인정보의 안전성 확보 조치\n"
			+ "센터는 이용자의 개인정보를 취급함에 있어 개인정보가 분실, 도난, 누출, 변조 또는 훼손되지 않도록 안전성 확보를 위하여 다음과 같은 대책을 강구하고 있습니다.\n"
			+ "\n"
			+ "내부관리계획의 수립 및 시행\n"
			+ "센터는 개인정보의 안전한 처리를 위하여 내부관리계획을 수립하고 시행하고 있습니다.\n"
			+ "센터는 사내 개인정보보호 전담기구 등을 통해 개인정보보호조치의 이행사항 및 담당자의 준수여부를 확인하여 문제 발견 시 즉시 시정 조치하도록 하고 있습니다.\n"
			+ "개인정보 취급 직원의 최소화 및 교육개인정보를 취급하는 직원을 지정하고 담당자에 한정시켜 최소화 하여 개인정보를 관리하는 대책을 시행하고 있습니다.\n"
			+ "접근통제장치의 설치 및 운영\n"
			+ "센터는 침입차단시스템을 이용하여 외부로부터 무단 접근을 통제하고 있으며, 기타 시스템적으로 보안성을 확보하기 위하여 가능한 모든 기술적 장치를 갖추려 노력하고 있습니다.\n"
			+ "(2) 이메일 무단수집 거부 방침\n"
			+ "센터는 게시된 이메일 주소가 전자우편 수집 프로그램이나 그 밖의 기술적 장치를 이용하여 무단 수집되는 것을 거부합니다. 이를 위반 시 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」등에 의해 처벌 받을 수 있습니다.\n"
			+ "\n"
			+ "10. 개인정보 관리책임자 및 상담ㆍ신고\n"
			+ "\n"
			+ "센터는 이용자의 개인정보를 보호하고 개인정보와 관련한 불만을 처리하기 위하여 아래와 같이 관련 부서 및 개인정보관리책임자를 지정하고 있습니다.\n"
			+ "\n"
			+ "(1) 개인정보 보호책임자\n"
			+ "성명 : 윤여동\n"
			+ "직급 : 대표원장\n"
			+ "연락처 : 02-582-6383\n"
			+ "이메일 : privacy@polestarhc.com\n"
			+ "팩스 : 02-521-4821\n"
			+ "\n"
			+ "(2) 개인정보 보호 담당부서\n"
			+ "부서명 : 원격판독사업팀\n"
			+ "담당자 : 최학수 과장\n"
			+ "연락처 : 02-582-6383\n"
			+ "이메일 : privacy@polestarhc.com\n"
			+ "팩스 : 02-521-4821\n"
			+ "\n"
			+ "고객님께서 위 고객서비스 담당부서 또는 개인정보관리책임자에게 센터의 개인정보보호 처리 사항에 관한 의견 또는 불만을 제기하실 경우, 센터는 신속하고 성실하게 조치하여 문제가 해결될 수 있도록 노력하겠습니다.\n"
			+ "\n"
			+ "(3) 기타 기관\n"
			+ "기타 개인정보침해에 대한 신고나 상담이 필요하신 경우에는 아래 기관에 문의하시기 바랍니다.\n"
			+ "\n"
			+ "개인정보침해신고센터 (www.118.or.kr / 118)\n"
			+ "대검찰청 인터넷범죄수사센터 (www.spo.go.kr / 02-3480-2000)\n"
			+ "경찰청 사이버테러대응센터 (www.netan.go.kr/ 1566-0112)\n"
			+ "\n"
			+ "11. 개인정보 처리방침 변경\n"
			+ "\n"
			+ "이 개인정보처리방침은 시행일로부터 적용되며, 법령 및 방침에 따른 변경내용의 추가, 삭제 및 정정이 있는 경우에는 변경사항의 시행 7일 전부터 공지사항을 통하여 고지할 것입니다.\n"
			+ "\n"
			+ "공고일자 : 2014년 12월 15일\n"
			+ "시행일자 : 2014년 12월 22일";
	@AssertTrue
	private Boolean agreePersonalInfoCheck;

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneFront() {
		return userPhoneFront;
	}

	public void setUserPhoneFront(String userPhoneFront) {
		this.userPhoneFront = userPhoneFront;
	}

	public String getUserPhoneMiddle() {
		return userPhoneMiddle;
	}

	public void setUserPhoneMiddle(String userPhoneMiddle) {
		this.userPhoneMiddle = userPhoneMiddle;
	}

	public String getUserPhoneBack() {
		return userPhoneBack;
	}

	public void setUserPhoneBack(String userPhoneBack) {
		this.userPhoneBack = userPhoneBack;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalZipCode() {
		return hospitalZipCode;
	}

	public void setHospitalZipCode(String hospitalZipCode) {
		this.hospitalZipCode = hospitalZipCode;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getHospitalContactName() {
		return hospitalContactName;
	}

	public void setHospitalContactName(String hospitalContactName) {
		this.hospitalContactName = hospitalContactName;
	}

	public String getHospitalContactPhoneFront() {
		return hospitalContactPhoneFront;
	}

	public void setHospitalContactPhoneFront(String hospitalContactPhoneFront) {
		this.hospitalContactPhoneFront = hospitalContactPhoneFront;
	}

	public String getHospitalContactPhoneMiddle() {
		return hospitalContactPhoneMiddle;
	}

	public void setHospitalContactPhoneMiddle(String hospitalContactPhoneMiddle) {
		this.hospitalContactPhoneMiddle = hospitalContactPhoneMiddle;
	}

	public String getHospitalContactPhoneBack() {
		return hospitalContactPhoneBack;
	}

	public void setHospitalContactPhoneBack(String hospitalContactPhoneBack) {
		this.hospitalContactPhoneBack = hospitalContactPhoneBack;
	}

	public Integer getXrayCount() {
		return xrayCount;
	}

	public void setXrayCount(Integer xrayCount) {
		this.xrayCount = xrayCount;
	}

	public Integer getCtCount() {
		return ctCount;
	}

	public void setCtCount(Integer ctCount) {
		this.ctCount = ctCount;
	}

	public Integer getMrCount() {
		return mrCount;
	}

	public void setMrCount(Integer mrCount) {
		this.mrCount = mrCount;
	}

	public Integer getMgCount() {
		return mgCount;
	}

	public void setMgCount(Integer mgCount) {
		this.mgCount = mgCount;
	}

	public String getHospitalMemo() {
		return hospitalMemo;
	}

	public void setHospitalMemo(String hospitalMemo) {
		this.hospitalMemo = hospitalMemo;
	}

	public String getAgreePersonalInfo() {
		return agreePersonalInfo;
	}

	public void setAgreePersonalInfo(String agreePersonalInfo) {
		this.agreePersonalInfo = agreePersonalInfo;
	}

	public Boolean getAgreePersonalInfoCheck() {
		return agreePersonalInfoCheck;
	}

	public void setAgreePersonalInfoCheck(Boolean agreePersonalInfoCheck) {
		this.agreePersonalInfoCheck = agreePersonalInfoCheck;
	}
}
