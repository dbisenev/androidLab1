package com.example.hh

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hh.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: VacancyAdapter
    private lateinit var searchView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = VacancyAdapter(
            onVacancyClickListener = {
                val intent = Intent(this, VacancyDetails::class.java)
                intent.putExtra("title", it.title)
                intent.putExtra("description", it.description)
                intent.putExtra("experience", it.experience)
                intent.putExtra("companyTitle", it.companyTitle)

                startActivity(intent)
            }
        )

        binding.recyclerView.adapter = adapter
        adapter.setData(DataSource.vacancyList)
        searchView = findViewById(R.id.searchEditText)
        searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val newText = p0.toString().trim()
                searchList(newText)
            }

        })


    }
    private fun searchList(text : String) {
            val dataSearchList = ArrayList<Vacancy>()
            for (data in DataSource.vacancyList){
                if (data.title.lowercase(Locale.ROOT).contains(text)){
                    dataSearchList.add(data)
                }
            }
            if (dataSearchList.isEmpty()){
                Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show()
            }else{
                adapter.setData(dataSearchList)
            }

        
    }
}