package com.example.food

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.food.R.id.foodTxt
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var foodTxt :EditText
    private lateinit var btnMeal : Button
    private lateinit var btnClear : Button
    private lateinit var foodDisp : TextView
    private lateinit var btnRst : Button
    private lateinit var btnExit : Button






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        foodTxt = findViewById(R.id.foodTxt)
        btnMeal = findViewById(R.id.btnMeal)
        btnClear = findViewById(R.id.btnClear)
        foodDisp = findViewById(R.id.foodDisp)
        btnRst = findViewById(R.id.btnRst)
        btnExit = findViewById(R.id.btnExit)

        btnMeal.setOnClickListener{
            handlebtnMealClick()
        }

        btnClear.setOnClickListener{
            handleBtnClearClick()
        }

        btnRst.setOnClickListener{
            handleBtnRstClick()
        }

        btnExit.setOnClickListener{
            finishAffinity()
            exitProcess(0)
        }

    }
    private fun isNotEmpty(): Boolean {
        var b = true
        if (foodTxt?.text.toString().trim().isEmpty()) {
            foodTxt?.error = "input required.Please enter the following values: Dawn, Morning, Afternoon, Dusk, Evening, Night "
            b = false
        }
        return b

    }


    private fun handlebtnMealClick() {

        if (isNotEmpty()) {
            val mealInput = foodTxt.text.toString().trim().lowercase()
            if (mealInput.isNotEmpty()) {


                when (mealInput) {
                    "dawn" -> foodDisp.text = "1.Fruit Salad \n \n 2.Cereal\n\n 3.Fruit Smoothie"

                    "morning" -> foodDisp.text =
                        "1.Cheese Sandwich \n\n 2.Bacon and Egg Omelette \n\n 3.Pancakes"

                    "afternoon" -> foodDisp.text =
                        "1.Burger \n\n 2.Boerewors Rolls \n\n 3.Rice and Curry"

                    "dusk" -> foodDisp.text = "1.Pizza \n\n 2.Tacos \n\n 3.Hot Chips "

                    "evening" -> foodDisp.text =
                        "1.Mash potatoes and salmon \n\n 2.Samp Beans and Chicken\n\n 3.Spaghetti Bolognese"

                    "night" -> foodDisp.text =
                        "1.Cake \n\n 2.Koeksusters \n\n 3.Vanilla Muffin \n\n 4.Malva Pudding"

                    else -> {
                        foodDisp.text = "Please enter a time period of a day."
                        Toast.makeText(this, "Please enter a time period of a day.", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun handleBtnClearClick(){
        foodTxt.text.clear()
        Toast.makeText(this, "Please enter the following values: Dawn, Morning, Afternoon, Dusk, Evening, Night", Toast.LENGTH_LONG).show()
    }

    private fun handleBtnRstClick(){
        foodTxt.text.clear()
        foodDisp.text = ""
        Toast.makeText(this, "Please enter the following values: Dawn, Morning, Afternoon, Dusk, Evening, Night", Toast.LENGTH_LONG).show()
    }





}