package com.natthakun.fristapp_again

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natthakun.fristapp_again.ContactDB.ContactDAO
import com.natthakun.fristapp_again.databinding.FragmentContactBinding

class ContactViewModelFactory (
    private val dataSource: ContactDAO,
    private val binding: FragmentContactBinding,
    private val application: Application
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(dataSource, binding, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}