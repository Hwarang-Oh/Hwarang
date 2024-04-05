package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.HouseInfoDto;
import com.ssafy.util.DBUtil;

public class HouseInfoDao implements HouseInfo {
	public List<HouseInfoDto> selectHouseInfos(String lngFrom, String lngTo, String latFrom, String latTo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT \r\n"
				+ "    aptCode,\r\n"
				+ "    buildYear,\r\n"
				+ "    roadName,\r\n"
				+ "    roadNameBonbun,\r\n"
				+ "    roadNameBubun,\r\n"
				+ "    roadNameSeq,\r\n"
				+ "    roadNameBasementCode,\r\n"
				+ "    roadNameCode,\r\n"
				+ "    dong,\r\n"
				+ "    bonbun,\r\n"
				+ "    bubun,\r\n"
				+ "    sigunguCode,\r\n"
				+ "    eubmyundongCode,\r\n"
				+ "    dongCode,\r\n"
				+ "    landCode,\r\n"
				+ "    apartmentName,\r\n"
				+ "    jibun,\r\n"
				+ "    lng,\r\n"
				+ "    lat\r\n"
				+ "FROM \r\n"
				+ "    houseinfo "
				+ "where lng between ? and ? and "
				+ "lat between ? and ?";
		ResultSet rs = null;
		List<HouseInfoDto> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lngFrom);
			pstmt.setString(2, lngTo);
			pstmt.setString(3, latFrom);
			pstmt.setString(4, latTo);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HouseInfoDto houseInfo = new HouseInfoDto();
				houseInfo.setAptCode(rs.getLong("aptCode"));
				houseInfo.setBuildYear(rs.getInt("buildYear"));
				houseInfo.setRoadName(rs.getString("roadName"));
				houseInfo.setRoadNameBonbun(rs.getString("roadNameBonbun"));
				houseInfo.setRoadNameBubun(rs.getString("roadNameBubun"));
				houseInfo.setRoadNameSeq(rs.getString("roadNameSeq"));
				houseInfo.setRoadNameBasementCode(rs.getString("roadNameBasementCode"));
				houseInfo.setRoadNameCode(rs.getString("roadNameCode"));
				houseInfo.setDong(rs.getString("dong"));
				houseInfo.setBonbun(rs.getString("bonbun"));
				houseInfo.setBubun(rs.getString("bubun"));
				houseInfo.setSigunguCode(rs.getString("sigunguCode"));
				houseInfo.setEubmyundongCode(rs.getString("eubmyundongCode"));
				houseInfo.setDongCode(rs.getString("dongCode"));
				houseInfo.setLandCode(rs.getString("landCode"));
				houseInfo.setApartmentName(rs.getString("apartmentName"));
				houseInfo.setJibun(rs.getString("jibun"));
				houseInfo.setLng(rs.getString("lng"));
				houseInfo.setLat(rs.getString("lat"));
				
				list.add(houseInfo);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}
}
