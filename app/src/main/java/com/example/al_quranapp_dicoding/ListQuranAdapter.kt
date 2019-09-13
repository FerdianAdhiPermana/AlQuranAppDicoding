package com.example.al_quranapp_dicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListQuranAdapter(val listQuran: ArrayList<Quran>) : RecyclerView.Adapter<ListQuranAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_quran, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listQuran.size
    }

    override fun onBindViewHolder(holder: ListQuranAdapter.ListViewHolder, position: Int) {
        val (name, jumlah, photo, overview, identity) = listQuran[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvJumlah.text = jumlah

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetails = Intent(mContext, detail_quran::class.java)
            moveDetails.putExtra(detail_quran.EXTRA_JUMLAH, jumlah)
            moveDetails.putExtra(detail_quran.EXTRA_NAME, name)
            moveDetails.putExtra(detail_quran.EXTRA_PHOTO, photo)
            moveDetails.putExtra(detail_quran.EXTRA_OVERVIEW, overview)
            moveDetails.putExtra(detail_quran.EXTRA_IDENTITY, identity)

            mContext.startActivity(moveDetails)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvJumlah: TextView = itemView.findViewById(R.id.tv_item_jumlah)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}