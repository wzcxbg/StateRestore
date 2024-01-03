package com.sliver.staterestore

import android.util.Log
import com.sliver.staterestore.base.BaseFragment
import com.sliver.staterestore.databinding.FragmentMainBinding


class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun initView() {
        var count = 0
        binding.clickMe.setOnClickListener {
            binding.count.text = "${++count}"
        }
    }

    companion object {
        fun newInstance(): MainFragment {
            Log.e("TAG", "newInstance: MainFragment")
            return MainFragment()
        }
    }
}