package com.alexlianardo.moviecatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexlianardo.moviecatalogue.activity.DetailActivity
import com.alexlianardo.moviecatalogue.data.Model
import com.alexlianardo.moviecatalogue.databinding.ListItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var list = ArrayList<Model>()

    fun setList(list : List<Model>?) {
        if (list == null) return
        this.list.clear()
        this.list.addAll(list)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = list[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int = list.size

    class ListViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Model){
            with(binding){
                title.text = model.title
                description.text = model.description
                Glide.with(itemView.context)
                    .load(model.poster)
                    .apply(RequestOptions().override(250, 400))
                    .into(poster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, model.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, model.category)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}