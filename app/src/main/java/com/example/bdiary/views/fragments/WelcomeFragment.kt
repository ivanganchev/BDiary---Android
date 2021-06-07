package com.example.bdiary.views.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.bdiary.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?)
    : View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        val dumbbell = view.findViewById<ImageView>(R.id.welcomeImage)

        val bounce: Animation = AnimationUtils.loadAnimation(context, R.anim.bounce)
        val zoom: Animation = AnimationUtils.loadAnimation(context, R.anim.scale_up)
        zoom.startOffset = 2000
        val fadeOut: Animation = AnimationUtils.loadAnimation(context, R.anim.fade_out)
        fadeOut.startOffset = 1500


        val animationSet = AnimationSet(false)
        animationSet.addAnimation(bounce)
        animationSet.addAnimation(fadeOut)
        animationSet.addAnimation(zoom)

        dumbbell.startAnimation(animationSet)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_welcomeFragment_to_authFragment)
        }, 2400)

        return view
    }

}