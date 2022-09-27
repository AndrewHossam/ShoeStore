package com.udacity.shoestore.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.isValid

class ShoeDetailFragment : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        binding.viewModel = shoeViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        shoeViewModel.clearInputs()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            btnCancel.setOnClickListener {
                findNavController().popBackStack()
            }
            btnSave.setOnClickListener {
                if (
                    etName.isValid()
                    && etCompany.isValid()
                    && etSize.isValid()
                    && etDesc.isValid()
                ) {
                    shoeViewModel.addShoeItem()
                    findNavController().popBackStack()
                }
            }
        }
    }
}