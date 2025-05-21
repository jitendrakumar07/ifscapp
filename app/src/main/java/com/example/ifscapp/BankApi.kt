package com.example.ifscapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BankApi {
    @GET("{ifsc}")
    fun getBankDetails(@Path("ifsc") ifsc: String): Call<BankDetails>
}
