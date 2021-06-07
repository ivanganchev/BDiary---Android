package com.example.bdiary.views.fragments.authentication

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.bdiary.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val fadeIn: Animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        view.visibility = View.VISIBLE
        view.startAnimation(fadeIn)

        val layout: FrameLayout = view.findViewById(R.id.loginButton)
        val regButton: FrameLayout = layout.findViewById(R.id.regButton)
        val doneImage: ImageView = layout.findViewById(R.id.doneImage)
        val signInText: TextView = layout.findViewById(R.id.buttonText)

        val transition: TransitionDrawable = regButton.background as TransitionDrawable
        val drawable: Drawable = doneImage.drawable

        regButton.setOnClickListener(View.OnClickListener {
            transition.startTransition(500)
            signInText.visibility = View.GONE
            doneImage.visibility = View.VISIBLE
            val avd: AnimatedVectorDrawable = drawable as AnimatedVectorDrawable
            avd.start()
        })

        return view
    }


}