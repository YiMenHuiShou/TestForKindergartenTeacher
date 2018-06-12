package com.example.feibinbin.testdemo;

import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @author feibinbin
 * @date 2018/6/12 20:28
 * @describle TODO
 */

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, MultipleItemQuickAdapter.MyViewHolder> {


    public MultipleItemQuickAdapter(List data) {
        super(data);
        addItemType(MultipleItem.TYPE1, R.layout.type01);
        addItemType(MultipleItem.TYPE2, R.layout.type02);
        addItemType(MultipleItem.TYPE3, R.layout.type03);
        addItemType(MultipleItem.TYPE4, R.layout.type4);
    }

    @Override
    protected void convert(MyViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TYPE1:
                //helper.setImageUrl(R.id.tv, item.getContent());
                break;
            case MultipleItem.TYPE2:
                //helper.setImageUrl(R.id.iv, item.getContent());
                break;
            case MultipleItem.TYPE3:
                //helper.setImageUrl(R.id.iv, item.getContent());
                break;
            case MultipleItem.TYPE4:
                //helper.setImageUrl(R.id.iv, item.getContent());
                break;
        }
    }

    public static class MyViewHolder extends BaseViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
