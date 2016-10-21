package com.hzit.mapper;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;
import com.hzit.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

	int insertUser(User user);

	void deleteUserByUserId(Integer userId);

	void updateUser(User user);

	Page<User> searchUserByParams(@Param("map") Map<String, String> map, Pageable pageable);

	List<User> searchUserByParams(@Param("map") Map<String, String> map);

} 
