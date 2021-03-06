package com.xjx.helper.test

import android.content.Intent
import android.view.View
import com.xjx.helper.R
import com.xjx.helper.base.CommonBaseTitleActivity
import com.xjx.helper.enums.PlaceholderStatus

/**
 * 测试的集合类
 */
class TestMapActivity : CommonBaseTitleActivity() {
    
    override fun getTitleLayout(): Int {
        return R.layout.activity_test_map
    }
    
    override fun initView() {
        super.initView()
        SwitchLoadingStatus(PlaceholderStatus.NONE)
        setTitleContent("测试页面的集合")
        
        
        setOnClick(R.id.tv_test_kotlin, R.id.tv_test_input, R.id.tv_test_custom_view)
    }
    
    override fun onClick(v: View?) {
        super.onClick(v)
        val intent = Intent()
        when (v?.id) {
            R.id.tv_test_kotlin -> {
                startActivity(intent, TestKotlin::class.java)
            }
            R.id.tv_test_input -> {
                startActivity(intent, TestInputActivity::class.java)
            }
            R.id.tv_test_custom_view -> {
                startActivity(intent, TestCustomViewActivity::class.java)
            }
        }
    }
}