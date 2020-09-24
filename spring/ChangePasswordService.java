package gradle_spring_autowired_study.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
	@Autowired
    private MemberDao memberDao;

	/*@Autowired 쓸꺼라서 주석
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */

    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        member.changePassword(oldPwd, newPwd);
        memberDao.update(member);
    }

}
