package cn.linkpower.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import cn.linkpower.vo.Usrs;

@Mapper
public interface IUserMapper {
	
	@Insert({"insert into users (username,pwd) values (#{username},#{pwd})"})
	public int addUser(Usrs user);
}
