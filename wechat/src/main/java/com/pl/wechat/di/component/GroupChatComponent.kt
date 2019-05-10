package com.pl.wechat.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.pl.wechat.di.module.GroupChatModule

import com.jess.arms.di.scope.ActivityScope
import com.pl.wechat.mvp.ui.activity.GroupChatActivity

@ActivityScope
@Component(modules = arrayOf(GroupChatModule::class), dependencies = arrayOf(AppComponent::class))
interface GroupChatComponent {
    fun inject(activity: GroupChatActivity)
}
