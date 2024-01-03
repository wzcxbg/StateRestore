package com.sliver.staterestore

import android.util.Log
import com.sliver.staterestore.base.BaseActivity
import com.sliver.staterestore.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initView() {

        val mainFragmentTag = MainFragment::class.java.simpleName
        var mainFragment = supportFragmentManager.findFragmentByTag(mainFragmentTag)
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, mainFragment, mainFragmentTag)
                .show(mainFragment)
                .commit()
        }

        val secondFragmentTag = SecondFragment::class.java.simpleName
        var secondFragment = supportFragmentManager.findFragmentByTag(secondFragmentTag)
        if (secondFragment == null) {
            secondFragment = SecondFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, secondFragment, secondFragmentTag)
                .hide(secondFragment)
                .commit()
        }

        for (fragment in supportFragmentManager.fragments) {
            Log.e(TAG, "initView: ${fragment.tag} ${fragment.hashCode()}")
        }

        var count = 0
        binding.toggle.setOnClickListener {
            if (++count % 2 == 0) {
                supportFragmentManager.beginTransaction()
                    .show(mainFragment)
                    .hide(secondFragment)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .show(secondFragment)
                    .hide(mainFragment)
                    .commit()
            }
            binding.count.text = "$count"
        }
        binding.recreate.setOnClickListener {
            recreate()
        }
    }
}