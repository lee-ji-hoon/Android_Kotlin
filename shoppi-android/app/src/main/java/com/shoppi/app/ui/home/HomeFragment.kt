package com.shoppi.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shoppi.app.*
import com.shoppi.app.ui.common.ViewModelFactory

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/18
 * @desc
 */

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // false로 할당함으로써 fagment는 host가 되는 activity위에 layout이 올라오는 것이기 때문에 activty가 올라온 이후
        // 생섬돼야 하므로 false로 lazy처럼 호출
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbarHomeTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

        viewModel.title.observe(viewLifecycleOwner) { title ->
            toolbarHomeTitle.text = title.text
            Glide.with(this)
                .load(title.iconUrl)
                .into(toolbarIcon)
        }
        viewPager.adapter = HomeBannerAdapter().apply {
            viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                submitList(banners)
            }
        }
        val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
        val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
        val screenWidth = resources.displayMetrics.widthPixels
        val offset = screenWidth - pageWidth - pageMargin

        viewPager.offscreenPageLimit = 3
        viewPager.setPageTransformer { page, position ->
            page.translationX = position * -offset
        }

        TabLayoutMediator(viewpagerIndicator, viewPager) { tab, position ->

        }.attach()
    }
}