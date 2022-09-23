package com.syedmohammedyousuf.movies_app.adapter

import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.syedmohammedyousuf.movies_app.R
import com.syedmohammedyousuf.movies_app.databinding.ActivityMainBinding.inflate
import com.syedmohammedyousuf.movies_app.models.Search

class MyAdapter : RecyclerView.Adapter<MainViewHolder>(){

    var movies = mutableListOf<Search>()

    fun setMovieList(movies: List<Search>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.movieTitle.setText(movie.Title)
        Glide.with(holder.itemView.context)
            .load(movie.Poster)
            .placeholder(R.drawable.placeholder)
            .into(holder.binding.moviePoster)

    }

    override fun getItemCount(): Int {
        return movies.size
    }


}


class MainViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root)  {

}
