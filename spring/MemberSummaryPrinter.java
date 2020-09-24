package gradle_spring_autowired_study.spring;

import org.springframework.beans.factory.annotation.Qualifier;

public class MemberSummaryPrinter extends MemberPrinter {

	@Override
	@Qualifier("summaryPrinter")
	public void print(Member member) {
		System.out.printf(
		"회원 정보: 이메일=%s, 이름=%s%n, ", member.getEmail(), member.getName());
	}
	
}
