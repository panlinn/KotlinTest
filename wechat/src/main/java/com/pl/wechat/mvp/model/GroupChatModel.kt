package com.pl.wechat.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.pl.wechat.mvp.contract.GroupChatContract


@ActivityScope
class GroupChatModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), GroupChatContract.Model {
    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
