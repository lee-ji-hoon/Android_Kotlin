package com.shoppi.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import org.json.JSONObject

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/18
 * @desc
 */

class HomeFragment : Fragment() {
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

        val assetLoader = AssetLoader()
        // context로 바로 접근하면 null일수도 있으므로 requireContext로 접근
        val homeJsonString = assetLoader.getJsonString(requireContext(), "home.json")

        if (!homeJsonString.isNullOrEmpty()) {
            Log.d("homeData", homeJsonString)

            if (!homeJsonString.isNullOrEmpty()) {
                val gson = Gson()
                val homeData = gson.fromJson(homeJsonString, HomeData::class.java)

                val text = homeData.title.text
                val iconUrl = homeData.title.iconUrl

                toolbarHomeTitle.text = text
                Glide.with(this)
                    .load(iconUrl)
                    .into(toolbarIcon)

                viewPager.adapter = HomeBannerAdapter().apply {
                    submitList(homeData.topBanners)
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
    }
}
