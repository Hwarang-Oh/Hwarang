package com.ssafy.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorter<T> implements Sorter<T> {

	private Comparator<T> comparator;

    public MergeSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }
    
	@Override
	public List<T> sort(List<T> list) {
		ArrayList<T> sorted = new ArrayList<T>(list.size());
		for (int i = 0; i < list.size(); i++) {
			sorted.add(null);
		}

		merge_sort(sorted, list, 0, list.size() - 1);

		return list;
	}

	private void merge(List<T> sorted, List<T> list, int l, int m, int r) {
		int i = l;
		int j = m + 1;
		int k = l;

		while (i <= m && j <= r) {
			if (comparator.compare(list.get(i), list.get(j)) <= 0)
				sorted.set(k++, list.get(i++));
			else
				sorted.set(k++, list.get(j++));
		}

		if (i > m) {
			for (int a = j; a <= r; a++)
				sorted.set(k++, list.get(a));
		} else {
			for (int a = i; a <= m; a++)
				sorted.set(k++, list.get(a));
		}

		for (int a = l; a <= r; a++)
			list.set(a, sorted.get(a));
	}

	private void merge_sort(List<T> sorted, List<T> list, int l, int r) {
		int mid;
		if (l < r) {
			mid = (l + r) / 2;
			merge_sort(sorted, list, l, mid);
			merge_sort(sorted, list, mid + 1, r);
			merge(sorted, list, l, mid, r);
		}
	}

}
