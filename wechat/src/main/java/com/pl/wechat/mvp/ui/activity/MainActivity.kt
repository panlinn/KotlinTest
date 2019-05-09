package com.pl.wechat.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.pl.wechat.di.component.DaggerMainComponent
import com.pl.wechat.di.module.MainModule
import com.pl.wechat.mvp.contract.MainContract
import com.pl.wechat.mvp.presenter.MainPresenter

import com.pl.wechat.R
import com.pl.wechat.mvp.model.entity.WeChatEntity
import com.pl.wechat.mvp.ui.adapter.AdapterMain
import kotlinx.android.synthetic.main.activity_main.*


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 05/09/2019 17:50
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
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
class MainActivity : BaseActivity<MainPresenter>(), MainContract.View {
    var data :ArrayList<WeChatEntity> = ArrayList()
    lateinit var adapterMain: AdapterMain
    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .mainModule(MainModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        data.add(WeChatEntity("微信单聊",R.mipmap.weixin))
        data.add(WeChatEntity("微信群聊",R.mipmap.qunliao))
        adapterMain = AdapterMain(this,data)
        myRecyclerView.let {
            it.layoutManager = GridLayoutManager(this,3)
            it.adapter = adapterMain
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
}
