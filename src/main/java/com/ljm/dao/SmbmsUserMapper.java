package com.ljm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ljm.entity.SmbmsUser;

public interface SmbmsUserMapper {
	/**
	 * ��ѯ�û��б�
	 * 
	 * @return
	 */
	List<SmbmsUser> getSmbmsUsersList();

	/**
	 * �����û����Ʋ�ѯ�û��б�
	 * 
	 * @param userName
	 *            �û�����
	 * @return
	 */
	List<SmbmsUser> getSmbmsUserListByUserName(String userName);

	/**
	 * �����û������û���ɫ
	 * 
	 * @param user
	 * @return
	 */
	List<SmbmsUser> getSmbmsUsersListByUserNameAndUserRole(SmbmsUser user);

	/**
	 * ����û�
	 * 
	 * @param user
	 *            ����û�
	 * @return �ɹ�����1������-1
	 */
	int addSmbmsUser(SmbmsUser user);

	/**
	 * �����û�id�޸��û���Ϣ
	 * 
	 * @param user
	 *            �����û�id�޸��û���Ϣ
	 * @return �ɹ�����1������-1
	 */
	int updateSmbmsUserById(SmbmsUser user);

	/**
	 * �����û�id�޸�����
	 * 
	 * @param id
	 * @param userPassword
	 * @return
	 */
	int updatePwd(@Param("id") Integer id,
			@Param("userPassword") String userPassword);

	/**
	 * �����û�idɾ���û���Ϣ
	 * 
	 * @param id
	 *            �����û�idɾ���û���Ϣ
	 * @return �ɹ�����1������-1
	 */
	int delSmbmsUserById(Integer id);

	/**
	 * ���ݽ�ɫid��ѯ�û��б���Ϣ
	 * 
	 * @param roleId
	 * @return
	 */
	List<SmbmsUser> getSmbmsUsersListByRoleId(Integer userRole);

	/**
	 * ��½
	 * 
	 * @param user
	 * @return
	 */
	SmbmsUser login(SmbmsUser user);

}
