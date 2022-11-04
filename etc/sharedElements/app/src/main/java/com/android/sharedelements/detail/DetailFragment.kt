package com.android.sharedelements.detail

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.transition.TransitionInflater
import com.android.sharedelements.R
import com.android.sharedelements.list.Sports
import com.google.android.material.transition.MaterialContainerTransform
import java.util.concurrent.TimeUnit


class DetailFragment : Fragment() {

    private lateinit var sportsArgs: Sports

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        sportsArgs = DetailFragmentArgs.fromBundle(args).modelArgs
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment
            duration = 600L
            scrimColor = Color.TRANSPARENT
        }
        postponeEnterTransition(250, TimeUnit.MILLISECONDS)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val banner: ImageView = view.findViewById(R.id.detail_image_view)
        val title: TextView = view.findViewById(R.id.title_detail_text_view)
        val about: TextView = view.findViewById(R.id.about_detail_text_view)

        banner.setImageResource(sportsArgs.banner)
        title.text = sportsArgs.title
        about.text = sportsArgs.about

        banner.transitionName = sportsArgs.banner.toString()
        title.transitionName = sportsArgs.title
    }
}