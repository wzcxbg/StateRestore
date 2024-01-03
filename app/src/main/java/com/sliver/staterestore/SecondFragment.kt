package com.sliver.staterestore

import com.sliver.staterestore.base.BaseFragment
import com.sliver.staterestore.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>() {
    override fun initView() {
        var count = 0
        binding.clickMe.setOnClickListener {
            binding.count.text = "${++count}"
        }
    }

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}