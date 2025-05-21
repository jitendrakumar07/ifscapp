package com.example.ifscapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var ifscInput: EditText
    private lateinit var fetchButton: Button
    private lateinit var loadingIndicator: ProgressBar

    private lateinit var bankName: TextView
    private lateinit var branchName: TextView
    private lateinit var city: TextView
    private lateinit var state: TextView
    private lateinit var address: TextView
    private lateinit var contactNumber: TextView
    private lateinit var footerNote: TextView

    private lateinit var bankDetailsLayout: LinearLayout
    private lateinit var viewModel: BankViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ifscInput = findViewById(R.id.ifscInput)
        fetchButton = findViewById(R.id.fetchButton)
        loadingIndicator = findViewById(R.id.loadingIndicator)

        bankName = findViewById(R.id.bankName)
        branchName = findViewById(R.id.branchName)
        city = findViewById(R.id.city)
        state = findViewById(R.id.state)
        address = findViewById(R.id.address)
        contactNumber = findViewById(R.id.contactNumber)
        footerNote = findViewById(R.id.footerNote)

        bankDetailsLayout = findViewById(R.id.bankDetailsLayout)

        viewModel = ViewModelProvider(this)[BankViewModel::class.java]

        fetchButton.setOnClickListener {
            val ifsc = ifscInput.text.toString().trim().uppercase()
            if (ifsc.isEmpty()) {
                Toast.makeText(this, "Please enter IFSC code", Toast.LENGTH_SHORT).show()
            } else if (ifsc.length != 11) {
                Toast.makeText(this, "IFSC code must be 11 characters", Toast.LENGTH_SHORT).show()
            } else {
                loadingIndicator.visibility = View.VISIBLE
                clearBankDetails()
                bankDetailsLayout.visibility = View.GONE
                viewModel.fetchBankDetails(ifsc)
            }
        }

        viewModel.bankDetails.observe(this, Observer { details ->
            loadingIndicator.visibility = View.GONE

            if (details != null) {
                bankDetailsLayout.visibility = View.VISIBLE

                bankName.text = details.BANK ?: "N/A"
                branchName.text = "Branch: ${details.BRANCH ?: "N/A"}"
                city.text = "City: ${details.CITY ?: "N/A"}"
                state.text = "State: ${details.STATE ?: "N/A"}"
                address.text = "Address: ${details.ADDRESS ?: "N/A"}"
                contactNumber.text = "Contact: ${details.CONTACT ?: "N/A"}"
                footerNote.text = "Data fetched from Razorpay IFSC API"
            } else {
                Toast.makeText(this, "No data found for this IFSC code.", Toast.LENGTH_LONG).show()
                clearBankDetails()
                bankDetailsLayout.visibility = View.GONE
            }
        })
    }

    private fun clearBankDetails() {
        bankName.text = ""
        branchName.text = ""
        city.text = ""
        state.text = ""
        address.text = ""
        contactNumber.text = ""
        footerNote.text = ""
    }
}
