package com.hzit.mapper;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;
import com.hzit.entity.Ordermain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrdermainMapper {

	void insertOrdermain(Ordermain ordermain);

	void deleteOrdermainByOrdermainId(Integer ordermainId);

	void updateOrdermain(Ordermain ordermain);

	Page<Ordermain> searchOrdermainByParams(@Param("map") Map<String, String> map, Pageable pageable);

	List<Ordermain> searchOrdermainByParams(@Param("map") Map<String, String> map);

} 
