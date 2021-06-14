package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_0.setOnClickListener { addInputText("0") }
        button_1.setOnClickListener { addInputText("1") }
        button_2.setOnClickListener { addInputText("2") }
        button_3.setOnClickListener { addInputText("3") }
        button_4.setOnClickListener { addInputText("4") }
        button_5.setOnClickListener { addInputText("5") }
        button_6.setOnClickListener { addInputText("6") }
        button_7.setOnClickListener { addInputText("7") }
        button_8.setOnClickListener { addInputText("8") }
        button_9.setOnClickListener { addInputText("9") }

        button_dot.setOnClickListener { addInputText(".") }

        button_plus.setOnClickListener { addInputText("+") }
        button_minus.setOnClickListener { addInputText("-") }
        button_multiply.setOnClickListener { addInputText("x") }
        button_separation.setOnClickListener { addInputText("/") }

        button_bracket_left.setOnClickListener { addInputText("(") }
        button_bracket_right.setOnClickListener { addInputText(")") }


        button_clear.setOnClickListener {
            val str = textView_input.text.toString()

            if(!str.isEmpty())
                textView_input.text = str.substring(0, str.length-1)

            textView_result.text = ""
        }

        button_clear.setOnLongClickListener {
            textView_input.text = ""
            textView_result.text = ""

            true
        }

        button_equals.setOnClickListener {
            try {

                val result = ExpressionBuilder(textView_input.text.toString()).build()
                val output = result.evaluate()
                val longOutput = output.toLong()

                if(output == longOutput.toDouble())
                    textView_result.text = longOutput.toString()
                else
                    textView_result.text = output.toString()

            } catch (e: Exception){
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun addInputText(str: String){
        textView_input.append(str)
    }
}