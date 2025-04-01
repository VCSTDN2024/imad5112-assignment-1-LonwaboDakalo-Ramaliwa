package com.example.food

import android.content.Intent
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
    private lateinit var btnfoodplcs : Button
    private lateinit var btnExit : Button






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        foodTxt = findViewById(R.id.foodTxt)
        btnMeal = findViewById(R.id.btnMeal)
        btnClear = findViewById(R.id.btnClear)
        foodDisp = findViewById(R.id.foodDisp)
        btnfoodplcs = findViewById(R.id.btnfoodplcs)
        btnExit = findViewById(R.id.btnExit)

        btnMeal.setOnClickListener{ //code will be connected below//
            handlebtnMealClick()
        }

        btnClear.setOnClickListener{
            handleBtnClearClick()
        }

        btnfoodplcs.setOnClickListener{
            val intent = Intent( this, Foodplace::class.java) //Takes to second page: Food Place //
            startActivity(intent)

        }

        btnExit.setOnClickListener{
            finishAffinity()
            exitProcess(0)//Simplified version of the exit function//
        }

    }
    private fun isNotEmpty(): Boolean {
        var b = true
        if (foodTxt?.text.toString().trim().isEmpty()) {
            foodTxt?.error = "input required.Enter: Dawn/ Morning/ Afternoon/ Dusk/ Evening/ Snack" //Prevents textbox from being left empty//
            b = false
        }
        return b

    }


    private fun handlebtnMealClick() {

        if (isNotEmpty()) {
            val mealInput = foodTxt.text.toString().trim().lowercase() //Accepts the correct text whether Capital or Lowercase//
            if (mealInput.isNotEmpty()) {


                when (mealInput) {// /n separates text and starts the next text on a new line //
                    "dawn" -> foodDisp.text = "1.Fruit Salad \n \n 2.Cereal\n\n 3.Fruit Smoothie"// 3 Food Options//

                    "morning" -> foodDisp.text =
                        "1.Cheese Sandwich \n\n 2.Bacon and Egg Omelette \n\n 3.Pancakes"

                    "afternoon" -> foodDisp.text =
                        "1.Burger \n\n 2.Boerewors Rolls \n\n 3.Rice and Curry"

                    "dusk" -> foodDisp.text = "1.Pizza \n\n 2.Tacos \n\n 3.Hot Chips "

                    "evening" -> foodDisp.text =
                        "1.Mash potatoes and salmon \n\n 2.Samp Beans and Chicken\n\n 3.Spaghetti Bolognese"

                    "snack" -> foodDisp.text =
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
        foodDisp.text = "" ////
        Toast.makeText(this, "Enter: Dawn/ Morning/ Afternoon/ Dusk/ Evening/ Snack", Toast.LENGTH_LONG).show()// Toast displays input that must be entered//
    }






}