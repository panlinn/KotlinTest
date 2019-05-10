package com.pl.wechat.mvp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pl.wechat.R
import com.pl.wechat.mvp.model.entity.GroupChatEntity

/**
 * Created by zbc on 2019/5/10 0010.
 * description：
 */
class AdapterGroupChat(private val context: Context, private var data: ArrayList<GroupChatEntity>) :
    RecyclerView.Adapter<AdapterGroupChat.ViewHolder>() {

    private val TYPE1 = 1
    private val TYPE2 = 2

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        with(this) {

        }
    }

    override fun getItemViewType(position: Int): Int {
        if (data[position].type == 1) {
            return TYPE1
        }
        return TYPE2
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}