package com.ljm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ljm.entity.SmbmsUser;

public interface SmbmsUserService {
	/**
	 * 查询用户列表
	 * 
	 * @return
	 */
	List<SmbmsUser> getSmbmsUsersList();

	/**
	 * 根据用户名称查询用户列表
	 * 
	 * @param userName
	 *            用户名称
	 * @return
	 */
	List<SmbmsUser> getSmbmsUserListByUserName(String userName);

	/**
	 * 根据用户名和用户角色查询
	 * 
	 * @param user
	 * @return
	 */
	List<SmbmsUser> getSmbmsUsersListByUserNameAndUserRole(SmbmsUser user);

	/**
	 * 增加用户
	 * 
	 * @param user
	 *            添加用户
	 * @return
	 */
	int addSmbmsUser(SmbmsUser user);

	/**
	 * 根据用户id修改用户信息
	 * 
	 * @param user
	 *            根据用户id修改用户信息
	 * @return
	 */
	int updateSmbmsUserById(SmbmsUser user);

	/**
	 * 根据用户id修改密码
	 * 
	 * @param id
	 * @param userPassword
	 * @return
	 */
	int updatePwd(@Param("id") Integer id,
			@Param("userPassword") String userPassword);

	/**
	 * 根据用户id删除用户信息
	 * 
	 * @param id
	 *            根据用户id删除用户信息
	 * @return
	 */
	int delSmbmsUserById(Integer id);

	/**
	 * 根据角色id查询用户列表信息
	 * 
	 * @param roleId
	 * @return
	 */
	List<SmbmsUser> getSmbmsUsersListByRoleId(Integer roleId);

	/**
	 * 登陆
	 * 
	 * @param user
	 * @return
	 */
	SmbmsUser login(SmbmsUser user);

}
