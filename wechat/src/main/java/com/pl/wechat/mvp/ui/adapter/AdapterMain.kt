package com.pl.wechat.mvp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.pl.wechat.R
import com.pl.wechat.mvp.model.entity.WeChatEntity
import kotlinx.android.synthetic.main.item_main.view.*

class AdapterMain(private val context: Context,private val arrayList: ArrayList<WeChatEntity>) : RecyclerView.Adapter<AdapterMain.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        arrayList[position].let {
            viewHolder.itemView.apply {
                Glide.with(context).load(it.img_path).into(main_img)
                main_tv.text = it.title
            }
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
