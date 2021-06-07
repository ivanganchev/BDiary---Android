package com.example.bdiary.views.fragments.authentication

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.bdiary.R
import com.example.bdiary.models.User
import com.example.bdiary.util.Resource

import com.example.bdiary.viewmodels.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    lateinit var user: User
    private val viewModel: RegisterViewModel by viewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_register, container, false)
        val layout: FrameLayout = view.findViewById(R.id.registerButton)
        val regButton: FrameLayout = layout.findViewById(R.id.regButton)
        val doneImage: ImageView = layout.findViewById(R.id.doneImage)
        val signInText: TextView = layout.findViewById(R.id.buttonText)
        val username: EditText = view.findViewById(R.id.userNameRegister)
        val password: EditText = view.findViewById(R.id.passwordRegister)
        val email: EditText = view.findViewById(R.id.emailRegister)

        val transition: TransitionDrawable = regButton.background as TransitionDrawable
        val drawable: Drawable = doneImage.drawable

        regButton.setOnClickListener(View.OnClickListener {
            user = User(username.text.toString(), password.text.toString(), email.text.toString())
            viewModel.setUser(user)

            viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
                when(dataState.status) {
                    Resource.Status.SUCCESS-> {
                        if(dataState.data?.token == null) {
                            Toast.makeText(context, dataState.data?.info, Toast.LENGTH_LONG).show()
                        } else {
                            transition.startTransition(500)
                            signInText.visibility = View.GONE
                            doneImage.visibility = View.VISIBLE
                            val avd: AnimatedVectorDrawable = drawable as AnimatedVectorDrawable
                            avd.start()
                            Toast.makeText(context, dataState.data?.info, Toast.LENGTH_LONG).show()
                        }
                    }
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.ERROR -> {
//                        Toast.makeText(context, dataState.data?.info, Toast.LENGTH_LONG).show()
                    }
                }
            })
        })

        return view
    }
}