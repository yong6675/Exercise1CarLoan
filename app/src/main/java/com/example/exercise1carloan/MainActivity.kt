package com.example.exercise1carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calButton: Button = findViewById(R.id.buttonCalculate)
        calButton.setOnClickListener { carloan() }

        val resetButton: Button = findViewById(R.id.buttonReset)
        resetButton.setOnClickListener{reset()}
    }

    private fun carloan() {
        //input value
        val loan:EditText = findViewById(R.id.editTextLoanPeriod)
        val down: EditText = findViewById(R.id.editTextDownPayment)
        val interest: EditText = findViewById(R.id.editTextInterestRate)
        val price: EditText = findViewById(R.id.editTextCarPrice)
        //output
        val loan1: TextView = findViewById(R.id.textViewLoan)
        val interest1: TextView = findViewById(R.id.textViewInterest)
        val monthly: TextView = findViewById(R.id.textViewMonthlyRepayment)
        //get
        val edit1 = loan.text.toString().toDouble()
        val edit2 = down.text.toString().toDouble()
        val edit3 = interest.text.toString().toDouble()
        val edit4 = price.text.toString().toDouble()

        val loan2: Double = edit4 - edit2
        val interest2: Double = loan2*edit3*edit1
        val monthly1: Double = (loan2+interest2)/edit1/12

        val loan3 = String.format("%.2f",loan2)
        val interest3 = String.format("%.2f",interest2)
        val monthly2 = String.format("%.2f",monthly1)

        loan1.setText("Loan : RM"+String.format(loan3))
        interest1.setText("Interest : RM"+String.format(interest3))
        monthly.setText("Monthly Repayment : RM"+String.format(monthly2))

    }

    private fun reset() {
        val edit1: EditText = findViewById(R.id.editTextCarPrice)
        val edit2: EditText = findViewById(R.id.editTextDownPayment)
        val edit3: EditText = findViewById(R.id.editTextLoanPeriod)
        val edit4: EditText = findViewById(R.id.editTextInterestRate)
        val text1: TextView = findViewById(R.id.textViewLoan)
        val text2: TextView = findViewById(R.id.textViewInterest)
        val text3: TextView = findViewById(R.id.textViewMonthlyRepayment)

        edit1.text.clear()
        edit2.text.clear()
        edit3.text.clear()
        edit4.text.clear()
        text1.text = "Loan :"
        text2.text = "Interest :"
        text3.text = "Monthly Repayment :"
    }
}
