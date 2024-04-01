package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.HouseInfoDto;

public interface HouseInfo {
	List<HouseInfoDto> selectHouseInfos(String lngFrom, String lngTo, String latFrom, String latTo) throws SQLException;
}
