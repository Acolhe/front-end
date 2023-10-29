package com.acolhe.app.utils;

import com.acolhe.app.model.Humor;

import java.time.LocalDate;
import java.util.Comparator;

public class HumorComparator implements Comparator<Humor> {
    @Override
    public int compare(Humor humor, Humor t1) {
        if(humor.getDataAvaliacao().isAfter(t1.getDataAvaliacao())) {
            return -1;
        } else if (humor.getDataAvaliacao().isEqual(t1.getDataAvaliacao())) {
            return 0;
        }else {
            return 1;
        }
    }
}
