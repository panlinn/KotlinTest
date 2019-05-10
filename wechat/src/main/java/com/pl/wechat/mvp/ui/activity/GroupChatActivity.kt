package com.pl.wechat.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.pl.wechat.R
import com.pl.wechat.app.utils.DialogUtils
import com.pl.wechat.di.component.DaggerGroupChatComponent
import com.pl.wechat.di.module.GroupChatModule
import com.pl.wechat.mvp.contract.GroupChatContract
import com.pl.wechat.mvp.presenter.GroupChatPresenter
import kotlinx.android.synthetic.main.activity_group_chat.*
import kotlinx.android.synthetic.main.dialog_group_chat_setting.*
import kotlinx.android.synthetic.main.include_title.*


/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class GroupChatActivity : BaseActivity<GroupChatPresenter>(), GroupChatContract.View, View.OnClickListener {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerGroupChatComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .groupChatModule(GroupChatModule(this))
            .build()
            .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_group_chat //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    override fun initData(savedInstanceState: Bundle?) {
        toolbar_title.text = "群聊"
        layout_bottom.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.layout_bottom -> showDialog()
            R.id.btn_setting -> {

            }
        }
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }

    private fun showDialog(){
        val dialog = DialogUtils.getBottomDialog(this)
        dialog.btn_setting.setOnClickListener(this)
        dialog.btn_add_text.setOnClickListener(this)
        dialog.btn_add_pic.setOnClickListener(this)
        if (!dialog.isShowing) {
            dialog.show()
        }
    }
}
