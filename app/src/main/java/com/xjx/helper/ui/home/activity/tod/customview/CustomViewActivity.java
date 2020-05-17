package com.xjx.helper.ui.home.activity.tod.customview;

import android.content.Intent;
import android.view.View;

import com.xjx.helper.R;
import com.xjx.helper.base.CommonBaseTitleActivity;
import com.xjx.helper.enums.PlaceholderStatus;

/**
 * 自定义view的集合
 */
public class CustomViewActivity extends CommonBaseTitleActivity {

    @Override
    protected int getTitleLayout() {
        return R.layout.activity_custom_view2;
    }

    @Override
    protected void initListener() {
        super.initListener();

        setTitleContent("自定义View的集合");
        SwitchLoadingStatus(PlaceholderStatus.NONE);

        setOnClick(R.id.tv1, R.id.tv2, R.id.tv_3);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.tv_1:// 自定义drawableTextView
                intent.setClass(mContext, DrawableTextViewActivity.class);
                break;
            case R.id.tv_2:// 自定义RecycleView布局
                intent.setClass(mContext, CustomRecycleViewActivity.class);
                break;
            case R.id.tv_3:// 自定义RecycleView布局
                intent.setClass(mContext, ViewPagerGirdViewActivity.class);
                break;
        }

        startActivity(intent);
    }
}
