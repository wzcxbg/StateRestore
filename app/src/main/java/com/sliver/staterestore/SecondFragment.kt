package com.sliver.staterestore

import android.os.Bundle
import com.sliver.staterestore.base.BaseFragment
import com.sliver.staterestore.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>() {
    private var count = 0

    override fun initView() {
        binding.clickMe.setOnClickListener {
            binding.count.text = "${++count}"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        count = savedInstanceState?.getInt("count") ?: 0
        binding.count.text = "$count"
    }

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}