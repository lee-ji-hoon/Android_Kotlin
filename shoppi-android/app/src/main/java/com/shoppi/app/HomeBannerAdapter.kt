package com.shoppi.app

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.DecimalFormat
import kotlin.math.roundToInt

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/27
 * @desc
 */

class HomeBannerAdapter :
    ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_banner, parent, false)
        return HomeBannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeBannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val bannerImageView = view.findViewById<ImageView>(R.id.iv_banner_image)
        private val bannerBadgeTextView = view.findViewById<TextView>(R.id.tv_banner_badge)
        private val bannerTitleTextView = view.findViewById<TextView>(R.id.tv_banner_title)
        private val bannerDetailThumbImageView = view.findViewById<ImageView>(R.id.iv_banner_thumbnail)
        private val bannerDetailBrandLabelTextView = view.findViewById<TextView>(R.id.tv_banner_brand_label)
        private val bannerDetailProductLabelTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_label)
        private val bannerDetailDiscountPriceTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_price)
        private val bannerDetailDiscountRateTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_rate)
        private val bannerDetailPriceTextView = view.findViewById<TextView>(R.id.tv_banner_product_price)

        fun bind(banner: Banner) {
            loadImage(banner.backgroundImageUrl, bannerImageView)
            bannerBadgeTextView.text = banner.badge.label
            bannerBadgeTextView.background = ColorDrawable(Color.parseColor(banner.badge.backgroundColor))
            bannerTitleTextView.text = banner.label
            loadImage(banner.productDetail.thumbnailImageUrl, bannerDetailThumbImageView)
            bannerDetailBrandLabelTextView.text = banner.productDetail.brandName
            bannerDetailProductLabelTextView.text = banner.productDetail.label
            bannerDetailDiscountRateTextView.text = "${banner.productDetail.discountRate}%"
            calculateDiscountAmount(
                bannerDetailDiscountPriceTextView,
                banner.productDetail.discountRate,
                banner.productDetail.price
            )
            applyPriceFormat(bannerDetailPriceTextView, banner.productDetail.price)

        }

        private val calculateDiscountAmount: (TextView, Int, Int) -> Unit = {
            view, discountRate, price ->
            val discountPrice = (((100 - discountRate) / 100.0) * price).roundToInt()
            applyPriceFormat(view, discountPrice)
        }

        private val applyPriceFormat: (TextView, Int) -> Unit = { view, price ->
            val decimalFormat = DecimalFormat("#,###")
            view.text = decimalFormat.format(price) + "원"
        }

        private fun loadImage(urlString: String, imageView: ImageView) {
            Glide.with(itemView)
                .load(urlString)
                .into(imageView)
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