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
import kotlin.system.exitProcess

class Foodplace : AppCompatActivity() {

    private lateinit var foodplctxt : EditText
    private lateinit var btnFoodSuggest : Button
    private lateinit var foodPlcDisp : TextView
    private lateinit var btnReset : Button
    private lateinit var btnHome : Button
    private lateinit var btnExt : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_foodplace)

        foodplctxt = findViewById(R.id.foodplctxt)
        btnFoodSuggest = findViewById(R.id.btnFoodSuggest)
        foodPlcDisp = findViewById(R.id.foodPlcDisp)
        btnReset = findViewById(R.id.btnReset)
        btnHome = findViewById(R.id.btnHome)
        btnExt = findViewById(R.id.btnExt)

        val btnhome = findViewById<Button>(R.id.btnHome)

        btnFoodSuggest.setOnClickListener{
            handlebtnMealClick()
        }

        btnReset.setOnClickListener{
            handleBtnResetClick()
        }

        btnHome.setOnClickListener{
            val intent =  Intent( this, MainActivity::class.java)
                startActivity(intent)

        }

        btnExt.setOnClickListener{
            finishAffinity()
            exitProcess(0)
        }

    }
    private fun isNotEmpty(): Boolean {
        var b = true
        if (foodplctxt?.text.toString().trim().isEmpty()) {
            foodplctxt?.error = "input required.Please enter the following values: Dawn, Morning, Afternoon, Dusk, Evening, Night "
            b = false
        }
        return b

    }


    private fun handlebtnMealClick() {

        if (isNotEmpty()) {
            val mealInput = foodplctxt.text.toString().trim().lowercase()
            if (mealInput.isNotEmpty()) {


                when (mealInput) {
                    "dawn" -> foodPlcDisp.text = "1.McDonald's \n \n 2.KFC \n\n 3.Chicken Licken  "

                    "morning" -> foodPlcDisp.text =
                        "1.Wimpy \n\n 2.Mugg and Bean \n\n 3.Spur"

                    "afternoon" -> foodPlcDisp.text =
                        "1.Steers \n\n 2.RocoMamas \n\n 3.Shaheems"

                    "dusk" -> foodPlcDisp.text = "1.Pizza Hut \n\n 2.Mochachos \n\n 3.Fishaways "

                    "evening" -> foodPlcDisp.text =
                        "1.Turn 'n Tender \n\n 2.Ocean Basket \n\n 3.Tasha's"

                    "night" -> foodPlcDisp.text =
                        "1.Woolworths \n\n 2. KFC \n\n 3.Milky Lane \n\n 4.McDonald's "

                    else -> {
                        foodPlcDisp.text = "Please enter a time period of a day."
                        Toast.makeText(this, "Please enter a time period of a day.", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
    private fun handleBtnResetClick(){
        foodplctxt.text.clear()
        foodPlcDisp.text = ""
        Toast.makeText(this, "Please enter the following values: Dawn, Morning, Afternoon, Dusk, Evening, Night", Toast.LENGTH_LONG).show()
    }


}