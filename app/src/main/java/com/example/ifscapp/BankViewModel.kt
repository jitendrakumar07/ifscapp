package com.example.ifscapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log


class BankViewModel : ViewModel() {

    // Private mutable LiveData
    private val _bankDetails = MutableLiveData<BankDetails?>()

    // Public immutable LiveData
    val bankDetails: LiveData<BankDetails?> get() = _bankDetails

    // Repository instance
    private val repository = BankRepository()

    // Fetch bank details using IFSC code
    fun fetchBankDetails(ifsc: String) {
        repository.getBankDetails(ifsc).enqueue(object : Callback<BankDetails> {
            override fun onResponse(call: Call<BankDetails>, response: Response<BankDetails>) {
                if (response.isSuccessful) {
                    _bankDetails.value = response.body()
                    Log.d("BankViewModel", "Bank details fetched successfully: ${response.body()}")
                } else {
                    _bankDetails.value = null
                    Log.e("BankViewModel", "Error response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<BankDetails>, t: Throwable) {
                Log.e("BANK_API_ERROR", "Failed to fetch: ${t.message}", t)
                _bankDetails.value = null
            }

        })
    }
}
