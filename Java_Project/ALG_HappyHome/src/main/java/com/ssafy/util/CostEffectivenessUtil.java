package com.ssafy.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ssafy.model.HouseDealVo;

public class CostEffectivenessUtil {
	private Sorter sorter;
	
	public CostEffectivenessUtil(Sorter<HouseDealVo> sorter) {
		this.sorter = sorter;
	}
	
	public List<HouseDealVo> sortByCostEffectivness(List<HouseDealVo> list) {
		return sorter.sort(list);
	}
	
	private static class CostComparator implements Comparator<HouseDealVo> {
        @Override
        public int compare(HouseDealVo o1, HouseDealVo o2) {
            return Float.compare(getCostEffectiveness(o2), getCostEffectiveness(o1));
        }
    }
    public static Comparator<HouseDealVo> getCostComparator() {
        return (o1, o2) -> Float.compare(getCostEffectiveness(o2), getCostEffectiveness(o1));
    }
	
	public static Float getCostEffectiveness(HouseDealVo o) {
		return Float.parseFloat(o.getArea()) / Float.parseFloat(o.getDealAmount().replaceAll(",", ""))*10000;
	}
}
