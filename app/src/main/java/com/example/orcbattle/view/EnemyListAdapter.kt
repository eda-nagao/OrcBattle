package com.example.orcbattle.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orcbattle.R
import com.example.orcbattle.databinding.ItemEnemyListBinding

class EnemyListAdapter(
  data: List<String>,
  private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<EnemyListAdapter.ViewHolder>() {
  private val mutableData = data.toMutableList()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemEnemyListBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(parent.context, binding)
  }

  override fun getItemCount(): Int = mutableData.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(position, mutableData[position], onClick)
  }

  fun update(position: Int, src: String) {
    mutableData[position] = src
    notifyItemChanged(position)
  }

  class ViewHolder(
    private val context: Context,
    private val binding: ItemEnemyListBinding
  ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, label: String, onClick: (Int) -> Unit) {
      binding.index.text = context.resources.getString(R.string.index, position)
      binding.itemLabel.text = label
      binding.root.setOnClickListener { onClick(position) }
    }
  }
}