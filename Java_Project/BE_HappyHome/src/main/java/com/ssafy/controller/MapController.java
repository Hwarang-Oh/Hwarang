package com.ssafy.controller;

import java.util.List;

import com.ssafy.model.HouseDealVo;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.houseDealDto;
import com.ssafy.model.service.MapService;
import com.ssafy.model.service.MapServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MapController implements Controller {
	private MapService mapService = new MapServiceImpl();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String aciton = request.getParameter("action");
		switch (aciton) {
		case "map/rest/list": {
			System.out.println("MapController : action : map/rest/list");
			String lngFrom = request.getParameter("lngFrom");
			String lngTo = request.getParameter("lngTo");
			String latFrom = request.getParameter("latFrom");
			String latTo = request.getParameter("latTo");
			
			List<HouseDealVo> list = mapService.getHouseDealVoList(lngFrom, lngTo, latFrom, latTo);
			
			return new DataInfo("application/json", list);
		}
		case "map/rest/aptList": {
			Long aptCode = Long.parseLong(request.getParameter("aptCode"));
			
			List<houseDealDto> list = mapService.getHouseDealList(aptCode);
			
			return new DataInfo("application/json", list); 
		}
		default:
			return null;
		}
	}
	
}
