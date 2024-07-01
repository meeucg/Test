package com.example.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.test.Autos.Auto
import com.example.test.Autos.SUV
import com.example.test.databinding.ActivityMainBinding

@SuppressLint("SetTextI18n")
fun plusTextView(text: String, textView: android.widget.TextView)
{
    textView.text = textView.text.toString() + text
}

class MainActivity : AppCompatActivity() {

    var numberOfCars: Int = 0
    var viewBinding: ActivityMainBinding? = null

    fun initViewBinding()
    {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        viewBinding?.apply()
        {
            carsNumber.doOnTextChanged { text, start, before, count ->
                text.toString().toIntOrNull()?.let()
                {
                    if(it in 1..100)
                    {
                        raceBtn.isEnabled = true
                    }
                    numberOfCars = it
                } ?: run {
                    raceBtn.isEnabled = false
                }
            }

            raceBtn.setOnClickListener()
            {
                val contenders: MutableList<Auto> = mutableListOf()
                val log: (String) -> Unit = {text -> plusTextView(text, textView)}

                raceBtn.isEnabled = false

                for(i in 0..<numberOfCars)
                {
                    contenders.add(Auto())
                }
                val race = Race(contenders, log)

                //log("")
                do{}while(race.nextRound())

                raceBtn.isEnabled = true
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initViewBinding()
        setContentView(viewBinding?.root)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        print("Hello world!\t" + SUV())
    }
}