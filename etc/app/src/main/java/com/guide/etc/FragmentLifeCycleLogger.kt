package com.guide.fruitcardgame.utils

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentLifeCycleLogger : FragmentManager.FragmentLifecycleCallbacks() {
    override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
        Log.d(f::class.java.simpleName, "onCreate")
    }

    override fun onFragmentViewCreated(
        fm: FragmentManager,
        f: Fragment,
        v: View,
        savedInstanceState: Bundle?
    ) {
        Log.d(f::class.java.simpleName, "onCreateView")
    }

    override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
        Log.d(f::class.java.simpleName, "onStart")
    }

    override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
        Log.d(f::class.java.simpleName, "onResume")
    }

    override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
        Log.d(f::class.java.simpleName, "onPause")
    }

    override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
        Log.d(f::class.java.simpleName, "onStop")
    }

    override fun onFragmentSaveInstanceState(fm: FragmentManager, f: Fragment, outState: Bundle) {
        Log.d(f::class.java.simpleName, "onSaveInstanceState")
    }

    override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
        Log.d(f::class.java.simpleName, "onDestroyView")
    }

    override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
        Log.d(f::class.java.simpleName, "onDestroy")
    }
}