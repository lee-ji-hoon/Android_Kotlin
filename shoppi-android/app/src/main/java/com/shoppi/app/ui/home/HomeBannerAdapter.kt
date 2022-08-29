package com.shoppi.app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.app.model.Banner
import com.shoppi.app.databinding.ItemHomeBannerBinding

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/27
 * @desc
 */

class HomeBannerAdapter(private val viewModel: HomeViewModel) :
    ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallback()) {

    private lateinit var binding: ItemHomeBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeBannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: Banner) {
            binding.banner = banner
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>() {
//    - 기존의 객체와 새로운 객체를 비교할때 어떤 식별자를 사용할지 알려줘야 한다.
//    - productDetail의 productId를 식별자로 지정!
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }
//    - `areItemsTheSame()` 이 동일하다면 호출이 된다.
//    - 두 객체 자체를 비교해주면 된다.
    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }
    // 만약의 나머지 프로퍼티중 일부 중 다른 것을 가지고 있다면 다른 것으로 인식하고, 기존에 그려졌던 UI가 있다면 업데이트 하게 된다.
}