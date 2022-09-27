package com.udacity.shoestore.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeLiveData = MutableLiveData<List<Shoe>>()
    val shoeLiveData: LiveData<List<Shoe>>
        get() = _shoeLiveData
    private val shoesList = mutableListOf<Shoe>()

    var name: String = ""
    var size: String = ""
    var company: String = ""
    var description: String = ""

    fun addShoeItem() {
        shoesList.add(
            Shoe(
                name = name,
                size = size.toDouble(),
                company = company,
                description = description
            )
        )
        _shoeLiveData.value = shoesList
    }

    fun clearInputs() {
        name = ""
        size = ""
        company = ""
        description = ""
    }

}