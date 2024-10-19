package com.example.hh

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hh.databinding.ActivityDetailsBinding

class VacancyDetails: AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)){ v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val vacancyTitle = intent.getStringExtra("title")
        val vacancyDescription = intent.getStringExtra("description")
        val vacancyExperience = intent.getStringExtra("experience")
        val vacancyCompanyTitle = intent.getStringExtra("companyTitle")
        Log.d("VacancyDetails", "Description: $vacancyDescription")
        Log.d("VacancyDetails", "Experience: $vacancyExperience")
        binding.vacancyTitle.text= vacancyTitle
        binding.vacancyDescription.text = vacancyDescription
        binding.vacancyExperience.text = "Требуемый опыт: от ${vacancyExperience} лет"
        binding.vacancyCompanyTitle.text = vacancyCompanyTitle
    }
}