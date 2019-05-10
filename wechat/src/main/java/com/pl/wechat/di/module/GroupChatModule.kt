package com.pl.wechat.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.pl.wechat.mvp.contract.GroupChatContract
import com.pl.wechat.mvp.model.GroupChatModel


@Module
//构建GroupChatModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class GroupChatModule(private val view: GroupChatContract.View) {
    @ActivityScope
    @Provides
    fun provideGroupChatView(): GroupChatContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideGroupChatModel(model: GroupChatModel): GroupChatContract.Model {
        return model
    }
}
