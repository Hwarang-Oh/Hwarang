package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.HouseDealVo;
import com.ssafy.model.dto.HouseInfoDto;
import com.ssafy.model.dto.houseDealDto;

public interface MapService {
	public List<HouseInfoDto> getHouseInfoList(String lngFrom, String lngTo, String latFrom, String latTo) throws SQLException;
	public List<HouseDealVo> getHouseDealVoList(String lngFrom, String lngTo, String latFrom, String latTo) throws SQLException;
	public List<houseDealDto> getHouseDealList(Long aptCode) throws SQLException;
}
