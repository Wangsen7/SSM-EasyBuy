package com.service.impl;

import java.util.ArrayList;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.News;
import com.entity.User;
import com.service.UserService;
import com.util.NewsPage;
import com.util.UserPage;

public class UserServiceImpl implements UserService {
	private UserDao userDao=new UserDaoImpl();

	public User selByLoginNameAndPassword(String loginName, String password) {
		// TODO Auto-generated method stub
		return userDao.selByLoginNameAndPassword(loginName, password);
	}
	
	public int addByUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addByUser(user);
	}
	
	public int selUserCountByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userDao.selUserCountByLoginName(loginName);
	}
	
	public UserPage selByCurrentPageNo(int currentPageNo) {
		UserPage userPage=new UserPage();
		if(currentPageNo<1){
			currentPageNo=1;
		}
		userPage.setCurrentPageNo(currentPageNo);
		int totalCount=userDao.selTotalCount();
		if(totalCount<1){
			userPage.setList(new ArrayList<User>());
		}else{
			userPage.setList(userDao.selByCurrentPageNoAndPageSize(userPage.getCurrentPageNo(),userPage.getPageSize()));
		}
		userPage.setTotalCount(totalCount);
		// TODO Auto-generated method stub
		return userPage;
	}
	
	public User selById(int id) {
		// TODO Auto-generated method stub
		return userDao.selById(id);
	}
	
	public int updateUserByUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserByUser(user);
	}
	
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteById(id);
	}
	
	public UserPage selByCurrentPageNoAndLoginName(int currentPageNo,
			String loginName) {
		UserPage userPage=new UserPage();
		if(currentPageNo<1){
			currentPageNo=1;
		}
		userPage.setCurrentPageNo(currentPageNo);
		int totalCount=userDao.selTotalCountAndLoginName(loginName);
		if(totalCount<1){
			userPage.setList(new ArrayList<User>());
		}else{
			userPage.setList(userDao.selByCurrentPageNoAndPageSizeAndLoginName(userPage.getCurrentPageNo(),userPage.getPageSize(), loginName));
		}
		userPage.setTotalCount(totalCount);
		// TODO Auto-generated method stub
		return userPage;
	}
	
	
	

}
