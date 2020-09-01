package web_study_09.dao;

import java.util.List;

import web_study_09.dto.Member;

public interface MemberDao {
	List<Member> selectMemberByAll();
	
	int insertMember(Member member);
	
	int updateMember(Member member);
	
	int deleteMember(Member member);

	Member selectMemberByUserId(Member member);
	
	
}
