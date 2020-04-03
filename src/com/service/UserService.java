package com.service;

import com.entity.User;
import com.util.UserPage;

public interface UserService {
	/**
	 * 根据用户名和密码登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	User selByLoginNameAndPassword(String loginName,String password);
	/**
	 * 注册新用户
	 * @param user
	 * @return
	 */
	int addByUser(User user);
	/**
	 * 查询该用户名是否存在
	 * @param loginName
	 * @return
	 */
	int selUserCountByLoginName(String loginName);
	/**
	 * 通过当前页获取UserPage
	 * @param currentPageNo
	 * @return
	 */
	UserPage selByCurrentPageNo(int currentPageNo);
	/**
	 * 通过Id查询User
	 * @param id
	 * @return
	 */
	User selById(int id);
	/**
	 * 修改信息
	 * @param user
	 * @return
	 */
	int updateUserByUser(User user);
	/**
	 * 删除该信息
	 * @param id
	 * @return
	 */
	int deleteById(int id);
	/**模糊查询以用户名为条件
	 * 通过当前页获取UserPage
	 * @param currentPageNo
	 * @return
	 */
	UserPage selByCurrentPageNoAndLoginName(int currentPageNo,String loginName);
	
	
	
	
}
