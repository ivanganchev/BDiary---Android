package com.example.bdiary.views.fragments.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.bdiary.R
import com.example.bdiary.adapters.AuthViewPagerAdapter

class AuthFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_auth, container, false)
        val scrollableImage: HorizontalScrollView = view.findViewById(R.id.scrollableImage)
        val dumbbellBackground: ImageView = view.findViewById(R.id.dumbbellBackground)
        val authViewPager: ViewPager2 = view.findViewById(R.id.authViewPager)
        (authViewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val fragmentList = arrayListOf<Fragment>(
                LoginFragment(),
                RegisterFragment()
        )

        val authAdapter = AuthViewPagerAdapter(
                fragmentList,
                requireActivity().supportFragmentManager,
                lifecycle
        )

        authViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                val x = ((authViewPager.getWidth() * position + positionOffsetPixels) * computeFactor()).toInt()
                scrollableImage.scrollTo(x, 0)
            }

            private fun computeFactor(): Float {
                return (dumbbellBackground.width - authViewPager.width) /
                        (authViewPager.width * (authViewPager.adapter!!.getItemCount() - 1)).toFloat()
            }
        })

        authViewPager.adapter = authAdapter

        return view
    }


}