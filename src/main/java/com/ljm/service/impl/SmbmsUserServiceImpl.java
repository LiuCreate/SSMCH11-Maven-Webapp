package com.ljm.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljm.dao.SmbmsUserMapper;
import com.ljm.entity.SmbmsUser;
import com.ljm.service.SmbmsUserService;

@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {
	@Autowired
	private SmbmsUserMapper mapper;

	public List<SmbmsUser> getSmbmsUsersList() {
		return mapper.getSmbmsUsersList();
	}

	public List<SmbmsUser> getSmbmsUserListByUserName(String userName) {
		return mapper.getSmbmsUserListByUserName(userName);
	}

	public List<SmbmsUser> getSmbmsUsersListByUserNameAndUserRole(SmbmsUser user) {
		return mapper.getSmbmsUsersListByUserNameAndUserRole(user);
	}

	public int addSmbmsUser(SmbmsUser user) {
		return mapper.addSmbmsUser(user);
	}

	public int updateSmbmsUserById(SmbmsUser user) {
		return mapper.updateSmbmsUserById(user);
	}

	public int updatePwd(@Param("id") Integer id,
			@Param("userPassword") String userPassword) {
		return mapper.updatePwd(id, userPassword);
	}

	public int delSmbmsUserById(Integer id) {
		return mapper.delSmbmsUserById(id);
	}

	public List<SmbmsUser> getSmbmsUsersListByRoleId(Integer roleId) {
		return mapper.getSmbmsUsersListByRoleId(roleId);
	}

	public SmbmsUser login(SmbmsUser user) {
		return mapper.login(user);
	}

}
