package lib.tool.com.tool_lib.views.calendarview.listener;

import android.view.View;

import lib.tool.com.tool_lib.views.calendarview.bean.DateBean;


/**
 * 日期点击接口
 */
public interface OnSingleChooseListener {
    /**
     * @param view
     * @param date
     */
    void onSingleChoose(View view, DateBean date);
}
