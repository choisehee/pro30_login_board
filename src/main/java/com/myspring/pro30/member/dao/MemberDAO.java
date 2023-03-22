package com.myspring.pro30.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.member.vo.MemberVO;

public interface MemberDAO {
	public List selectAllMembers() throws DataAccessException;

	public int insertMember(MemberVO memberVO) throws DataAccessException;

	public int removeMember(String id) throws DataAccessException;

//	public int modMember(MemberVO memberVO)throws DataAccessException;
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;

}
