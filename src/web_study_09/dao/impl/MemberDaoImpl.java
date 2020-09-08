package web_study_09.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import web_study_09.ds.JdbcUtil;
import web_study_09.dao.MemberDao;
import web_study_09.dto.Member;

public class MemberDaoImpl implements MemberDao {
	private static final MemberDaoImpl instance = new MemberDaoImpl();
	
	private MemberDaoImpl() {};
	
	public static MemberDaoImpl getInstance() {
		return instance;
	}
	
	private Member getMember(ResultSet rs) throws SQLException {
		Member member = new Member();
		//rs얻어서 set
		try {
			member.setName(rs.getString("NAME"));
			member.setUserId(rs.getString("USERID"));
			member.setPwd(rs.getString("PWD"));
			member.setEmail(rs.getString("EMAIL"));
			member.setPhone(rs.getString("PHONE"));
			member.setAdmin(rs.getInt("ADMIN"));
			member.setJoinDate(rs.getTimestamp("JOINDATE"));
		} catch (SQLException e) {

		}
		return member;
	}

	@Override
	public List<Member> selectMemberByAll() {
		String sql = "SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN, JOINDATE FROM MEMBER";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Member> list = new ArrayList<>();
				do {
					list.add(getMember(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;

	}


	@Override
	public Member selectMemberByUserId(Member member) {
		String sql = "SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN,JOINDATE FROM MEMBER WHERE USERID= ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, member.getUserId());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getMember(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;

	}

	@Override
	public int insertMember(Member member) {
		String sql = "INSERT INTO MEMBER(NAME, USERID, PWD, EMAIL, PHONE, ADMIN) VALUES(?, ?, ?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getUserId());
			pstmt.setString(3, member.getPwd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setInt(6, member.getAdmin());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateMember(Member member) {
		String sql = "UPDATE MEMBER SET NAME = ?, PWD = ?, EMAIL = ?, PHONE = ?, ADMIN = ?, JOINDATE = sysdate WHERE USERID= ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getPhone());
			pstmt.setInt(5, member.getAdmin());
			//pstmt.setTimestamp(6, new java.sql.Timestamp(member.getJoinDate().getTime()));
			pstmt.setString(6, member.getUserId());
			
			
			return pstmt.executeUpdate(); 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteMember(Member member) {
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getUserId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}

}
