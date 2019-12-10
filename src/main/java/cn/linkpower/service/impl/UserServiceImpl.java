package cn.linkpower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import cn.linkpower.dao.IUserMapper;
import cn.linkpower.service.IUserService;
import cn.linkpower.vo.Usrs;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserMapper userMapper;
	
	@Transactional
	@Override
	public int addUser(Usrs user) {
		userMapper.addUser(user);
		return 0;
	}
	
	@Transactional
	@Override
	public int addUser2(Usrs user) {
		userMapper.addUser(user);
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		return 0;
	}

}
