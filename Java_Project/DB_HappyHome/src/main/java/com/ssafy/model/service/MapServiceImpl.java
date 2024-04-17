package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.HouseDealVo;
import com.ssafy.model.dao.HouseDealDao;
import com.ssafy.model.dao.HouseInfoDao;
import com.ssafy.model.dto.HouseInfoDto;
import com.ssafy.model.dto.houseDealDto;
import com.ssafy.util.CostEffectivenessUtil;
import com.ssafy.util.MergeSorter;

public class MapServiceImpl implements MapService {
	private HouseInfoDao houseInfoDao = new HouseInfoDao();
	private HouseDealDao houseDealDao = new HouseDealDao();
	private CostEffectivenessUtil costUtil = new CostEffectivenessUtil(new MergeSorter<>(CostEffectivenessUtil.getCostComparator()));
	
	public List<HouseInfoDto> getHouseInfoList(String lngFrom, String lngTo, String latFrom, String latTo) throws SQLException {
		return houseInfoDao.selectHouseInfos(lngFrom, lngTo, latFrom, latTo);
	}
	
	public List<HouseDealVo> getHouseDealVoList(String lngFrom, String lngTo, String latFrom, String latTo) throws SQLException {
		List<HouseDealVo> list = houseDealDao.selectHouseDeals(lngFrom, lngTo, latFrom, latTo);
		return costUtil.sortByCostEffectivness(list);
	}
	
	public List<houseDealDto> getHouseDealList(Long aptCode) throws SQLException {
		return houseDealDao.selectHouseDeals(aptCode);
	}
}
