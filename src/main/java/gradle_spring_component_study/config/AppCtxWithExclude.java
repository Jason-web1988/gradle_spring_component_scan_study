package gradle_spring_component_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import gradle_spring_component_study.spring.MemberPrinter;
import gradle_spring_component_study.spring.MemberSummaryPrinter;

@Configuration
/*
 * @ComponentScan(basePackages = {"gradle_spring_component_study.spring"},
 * excludeFilters = @Filter(type=FilterType.REGEX,
 * pattern="gradle_spring_component_study.spring\\..*Dao" ) )
 */
@ComponentScan(basePackages = {"gradle_spring_component_study.spring"},
excludeFilters = @Filter(type=FilterType.ASPECTJ, 
						pattern="gradle_spring_component_study.spring.*Dao"
		)
)

public class AppCtxWithExclude {

	/*
	 * @Bean public MemberDao memberDao() { return new MemberDao(); }
	 */

	/*
	 * @Bean public MemberRegisterService memberRegSvc() { return new
	 * MemberRegisterService(); }
	 */
	/*
	 * @Bean public ChangePasswordService changePwdSvc() { ChangePasswordService
	 * pwdSvc = new ChangePasswordService(); //
	 * pwdSvc.setMemberDao(memberDao()); @Autowired 애노테이션을 memberDao필드에
	 * 추가하였으므로 @Bean 설정 매서드에서 의존을 주입하는 코드를 삭제 return pwdSvc; }
	 */

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}

	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}

	/*
	 * @Bean public MemberListPrinter listPrinter() { return new MemberListPrinter(
	 * memberDao(), memberPrinter() ); }
	 */
	/*
	 * @Bean public MemberInfoPrinter infoPrinter() { MemberInfoPrinter infoPrinter
	 * = new MemberInfoPrinter(); infoPrinter.setMemberDao(memberDao());
	 * infoPrinter.setPrinter(memberPrinter1()); return infoPrinter; }
	 */
}
