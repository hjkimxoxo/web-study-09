package web_study_09.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_09.dao.impl.MemberDaoImpl;
import web_study_09.dto.Member;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {
	private MemberDao dao;
	
	@Before
	public void setUp() throws Exception {
		dao = MemberDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}
	
	@Test
	public void testSelectMemberByAll() {
		System.out.println("testSelectMemberByAll()");
		List<Member> list = dao.selectMemberByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void testSelectMemberByNo() {
		System.out.printf("%s()%n", "SelectMemberById()");
		Member select = dao.selectMemberByUserId(new Member("somi"));
		Assert.assertNotNull(select);
		System.out.println(select);
		System.out.println();
	}

	@Test
	public void test01InsertMember() {
		System.out.printf("%s()%n", "test01InsertMember");
		System.out.println("김혜진삽입");
		
		Date now = new Date();
		
		Member newMember = new Member("감혜진", "pipi", "1234", "pjt@gmail.com", "010-5656-5656", 1);
		
		int res = dao.insertMember(newMember);
		Assert.assertEquals(1, res);
		System.out.println("--------확인--------");
		List<Member> list = dao.selectMemberByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test03DeleteMember() {
		
		System.out.printf("%s()%n", "test02DeleteMember");
		System.out.println("pipi삭제");
		Member deleteMember = new Member("pipi");
		int res = dao.deleteMember(deleteMember);
		Assert.assertEquals(1, res);
		
		System.out.println("--------확인--------");
		List<Member> list = dao.selectMemberByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
		
	}

	@Test
	public void test02UpdateMember() {
		System.out.printf("%s()%n", "test02updateMember");
		
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(2010, 12, 19);
		
		Member member = dao.selectMemberByUserId(new Member("pipi"));
		
		member.setName("김변경");
		member.setPwd("변경");
		member.setEmail("변경");
		member.setPhone("변경");
		member.setAdmin(0);
		member.setJoinDate(c.getTime());
		System.out.println(member);
		int res = dao.updateMember(member);
		Assert.assertEquals(1, res);
		
		
		System.out.println("--------확인--------");
		List<Member> list = dao.selectMemberByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
		
	}
}
