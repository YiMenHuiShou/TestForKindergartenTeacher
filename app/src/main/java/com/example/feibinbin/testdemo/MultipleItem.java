package com.example.feibinbin.testdemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author feibinbin
 * @date 2018/6/12 20:29
 * @describle TODO
 */

public class MultipleItem implements MultiItemEntity {

    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;
    public static final int TYPE4 = 4;
    private int itemType;

    public MultipleItem(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

}
