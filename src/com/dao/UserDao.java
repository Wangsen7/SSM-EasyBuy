package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
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
	 * 查询所有用户信息
	 * @return
	 */
	int selTotalCount();
	/**
	 * 查询每页用户信息集合
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<User> selByCurrentPageNoAndPageSize(int currentPageNo,int pageSize);
	/**
	 * 通过Id查询User
	 * @param id
	 * @return
	 */
	User selById(int id);
	/**
	 * 修改页面
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
	/**
	 * 模糊查询以name为条件所有用户信息
	 * @return
	 */
	int selTotalCountAndLoginName(String loginName);
	/**
	 * 模糊查询以name为条件每页用户信息集合
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<User> selByCurrentPageNoAndPageSizeAndLoginName(int currentPageNo,int pageSize,String loginName);
}
