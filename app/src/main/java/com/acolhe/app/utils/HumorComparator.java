package com.acolhe.app.utils;

import com.acolhe.app.model.HumorDTO;

import java.util.Comparator;

public class HumorComparator implements Comparator<HumorDTO> {
    @Override
    public int compare(HumorDTO humor, HumorDTO t1) {
        if(humor.getData().isAfter(t1.getData())) {
            return -1;
        } else if (humor.getData().isEqual(t1.getData())) {
            return 0;
        }else {
            return 1;
        }
    }
}
