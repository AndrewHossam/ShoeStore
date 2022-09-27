package com.udacity.shoestore.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {

            viewModel.shoeLiveData.observe(viewLifecycleOwner) {
                it?.let {
                    for (shoe in it) {
                        addShoeToList(shoe)
                    }
                }
            }

            fab.setOnClickListener {
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
            }
        }
    }

    private fun addShoeToList(shoe: Shoe) {
        val itemBinding = ShoeItemBinding.inflate(LayoutInflater.from(context))
        itemBinding.apply {
            tvName.text = shoe.name
            tvCompany.text = shoe.company
            tvSize.text = shoe.size.toString()
            tvDesc.text = shoe.description
        }
        binding.llShoeList.addView(itemBinding.root)

    }
}