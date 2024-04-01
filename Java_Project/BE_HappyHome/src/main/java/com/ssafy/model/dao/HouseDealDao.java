package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.HouseDealVo;
import com.ssafy.model.dto.houseDealDto;
import com.ssafy.util.DBUtil;

public class HouseDealDao {
	public List<HouseDealVo> selectHouseDeals(String lngFrom, String lngTo, String latFrom, String latTo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HouseDealVo> list = new ArrayList<>();
		
		String sql = "SELECT ranked.*\n"
				+ "FROM (\n"
				+ "    SELECT hd.*, hi.apartmentName, lng, lat,\n"
				+ "           ROW_NUMBER() OVER (PARTITION BY hd.aptCode ORDER BY hd.no DESC) AS row_num\n"
				+ "    FROM housedeal hd\n"
				+ "    INNER JOIN (\n"
				+ "        SELECT aptCode, apartmentName, lng, lat\n"
				+ "        FROM houseinfo\n"
				+ "        WHERE lng BETWEEN ? AND ? \n"
				+ "          AND lat BETWEEN ? AND ? \n"
				+ "        ORDER BY aptCode\n"
				+ "        LIMIT 10\n"
				+ "    ) hi ON hd.aptCode = hi.aptCode\n"
				+ ") ranked\n"
				+ "WHERE row_num = 1;\n";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lngFrom);
			pstmt.setString(2, lngTo);
			pstmt.setString(3, latFrom);
			pstmt.setString(4, latTo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HouseDealVo houseDeal = new HouseDealVo();
                houseDeal.setNo(rs.getLong("no"));
                houseDeal.setDealAmount(rs.getString("dealAmount"));
                houseDeal.setDealYear(rs.getInt("dealYear"));
                houseDeal.setDealMonth(rs.getInt("dealMonth"));
                houseDeal.setDealDay(rs.getInt("dealDay"));
                houseDeal.setArea(rs.getString("area"));
                houseDeal.setFloor(rs.getString("floor"));
                houseDeal.setCancelDealType(rs.getString("cancelDealType"));
                houseDeal.setAptCode(rs.getLong("aptCode"));
                houseDeal.setApartmentName(rs.getString("apartmentName"));
                houseDeal.setLng(rs.getString("lng"));
                houseDeal.setLat(rs.getString("lat"));
				list.add(houseDeal);
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
	public List<houseDealDto> selectHouseDeals(Long aptCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<houseDealDto> list = new ArrayList();
		ResultSet rs = null;
		
		String sql = "select *\n"
				+ "from houseDeal\n"
				+ "where aptCode = ?";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, aptCode);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				houseDealDto houseDeal = new houseDealDto();
				houseDeal.setNo(rs.getLong("no"));
                houseDeal.setDealAmount(rs.getString("dealAmount"));
                houseDeal.setDealYear(rs.getInt("dealYear"));
                houseDeal.setDealMonth(rs.getInt("dealMonth"));
                houseDeal.setDealDay(rs.getInt("dealDay"));
                houseDeal.setArea(rs.getString("area"));
                houseDeal.setFloor(rs.getString("floor"));
                houseDeal.setCancelDealType(rs.getString("cancelDealType"));
                houseDeal.setAptCode(rs.getLong("aptCode"));
                list.add(houseDeal);
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
}
