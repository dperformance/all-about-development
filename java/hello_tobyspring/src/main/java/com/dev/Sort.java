package com.dev;

import java.util.List;

public class Sort {

    public List<String> sortByLength(List<String> list) {
        list.sort((a1, a2) -> a1.length() - a2.length());
        return list;
    }
}
