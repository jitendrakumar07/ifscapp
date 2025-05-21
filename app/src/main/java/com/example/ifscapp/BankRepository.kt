package com.example.ifscapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BankRepository {

    private val api: BankApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ifsc.razorpay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(BankApi::class.java)
    }

    fun getBankDetails(ifsc: String): Call<BankDetails> {
        return api.getBankDetails(ifsc)
    }
}
