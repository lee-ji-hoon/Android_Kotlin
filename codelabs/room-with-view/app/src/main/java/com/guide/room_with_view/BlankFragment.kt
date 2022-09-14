package com.guide.room_with_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.guide.room_with_view.databinding.FragmentBlankBinding

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/09/15
 * @desc
 */

class BlankFragment : Fragment() {
    private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vmUser = ViewModelProvider(requireActivity())[UserViewModel::class.java]
        binding.lifecycleOwner = viewLifecycleOwner
    }
}