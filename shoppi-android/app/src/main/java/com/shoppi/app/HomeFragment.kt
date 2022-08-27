package com.shoppi.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
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
        /*val button = view.findViewById<Button>(R.id.btn_enter_product_detail)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_product_detail)
        }*/

        val assetLoader = AssetLoader()
        // context로 바로 접근하면 null일수도 있으므로 requireContext로 접근
        val homeData = assetLoader.getJsonString(requireContext(), "home.json")
<<<<<<< HEAD

        if (!homeData.isNullOrEmpty()) {
            Log.d("homeData", homeData ?: "NULL")
=======
        Log.d("homeData", homeData ?: "NULL")

        if (!homeData.isNullOrEmpty()) {
>>>>>>> 9094658154e4f99d32a8765aa510569fbe028237
            val jsonObject = JSONObject(homeData)
            val title = jsonObject.getJSONObject("title")
            val text = title.getString("text")
            val iconUrl = title.getString("icon_url")
            val titleValue = Title(text, iconUrl)
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 9094658154e4f99d32a8765aa510569fbe028237

            val toolbarHomeTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
            val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)

            toolbarHomeTitle.text = titleValue.text
            Glide.with(this)
                .load(iconUrl)
                .into(toolbarIcon)

<<<<<<< HEAD
=======
=======
>>>>>>> dc4b83568ac0e82c38366a70499e7fdc410f1193
=======
>>>>>>> dc4b83568ac0e82c38366a70499e7fdc410f1193
>>>>>>> 9094658154e4f99d32a8765aa510569fbe028237
        }
    }
}
