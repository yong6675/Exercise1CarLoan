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
        val edit1 = loan.text.toString().toInt()
        val edit2 = down.text.toString().toInt()
        val edit3 = interest.text.toString().toInt()
        val edit4 = price.text.toString().toInt()

        val loan2: Int = edit4 - edit2
        val interest2: Int = loan2*edit3*edit1
        val monthly1: Int = (loan2+interest2)/edit1/12

        loan1.setText("Loan : RM"+Integer.toString(loan2))
        interest1.setText("Interest : RM"+Integer.toString(interest2))
        monthly.setText("Monthly Repayment : RM"+Integer.toString(monthly1))

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
