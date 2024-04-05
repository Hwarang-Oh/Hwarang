package com.ssafy.util;

import java.util.List;

public interface Sorter<T> {
    List<T> sort(List<T> list);
}