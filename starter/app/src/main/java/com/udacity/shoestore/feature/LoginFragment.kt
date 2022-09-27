package com.udacity.shoestore.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.isValid

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {
            btnLogin.setOnClickListener {
                if (
                    etUserName.isValid()
                    && etPassword.isValid()
                )
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
            btnSignUp.setOnClickListener {
                if (
                    etUserName.isValid()
                    && etPassword.isValid()
                )
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
    }

}