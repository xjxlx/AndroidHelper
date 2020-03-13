package com.xjx.helper.utils.recyeliview;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xjx.helper.utils.LogUtil;

/**
 * recycleview类型中GridLayoutManager的分割线
 */
public class RecycleViewGridLayoutDivider extends RecyclerView.ItemDecoration {

    private int mMarginTop;  // 上边的边距
    private int mMarginBottom; // 下面的边距
    private int mMargin;// 左右两侧的边距
    private int mDivderWidth; //  左右中间的边距
    private int mDividerHeight;// 默认分割线的高度
    private int mRowCount;// 显示的行数

    private int rightRow;  // 最右侧的列数
    private int bottomLine = -1;//最下面的行数

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getAdapter() == null) {
            throw new IllegalArgumentException("Adapter cannot be null！");
        }

        // 求出最后一行
        if (bottomLine == -1) {
            bottomLine = (parent.getAdapter().getItemCount()) / mRowCount;
            LogUtil.e("最后一行为：" + bottomLine);
        }

        // 当前的position
        int childAdapterPosition = parent.getChildAdapterPosition(view);

        // 求出当前应该在第几列
        int row = childAdapterPosition % mRowCount;

        LogUtil.e("当前的position：" + childAdapterPosition + " --->当前的列：" + row);
        // 求出行数
        int line = childAdapterPosition / mRowCount;

//        if (line == 0) {
//            // 第一行
//            outRect.top = mMarginTop;
//            outRect.bottom = 0;
//        } else if (line == bottomLine) {
//            // 最后一行
//            outRect.top = 0;
//            outRect.bottom = mMarginBottom;
//        } else {
//            // 其他行
//            outRect.top = 0;
//            outRect.bottom = mDividerHeight;
//        }

        if (row == 0) {
            // 最左侧的列
            outRect.left = mMargin;
        } else if (row == rightRow) {
            // 最右侧的列
            outRect.right = mMargin;
            outRect.left = mDivderWidth;
        } else {
            // 中间的列
            outRect.left = mDivderWidth;
        }
    }

    /**
     * @param margin        左右的边距
     * @param top           上边的边距
     * @param bottom        下面的边距
     * @param dividerHeight 上下条目的间距
     * @param divderWidth   左右条目的边距
     * @param row           列数
     */
    public RecycleViewGridLayoutDivider(int margin, int top, int bottom, int dividerHeight, int divderWidth, int row) {
        this.mMargin = margin;
        this.mMarginTop = top;
        this.mMarginBottom = bottom;
        this.mDivderWidth = divderWidth;
        this.mDividerHeight = dividerHeight;
        this.mRowCount = row;

        // 求出最后一列
        rightRow = mRowCount - 1;
    }

}
