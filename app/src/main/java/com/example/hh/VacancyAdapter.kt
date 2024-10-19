package com.example.hh

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hh.databinding.ItemVacancyBinding

class VacancyAdapter (
    private val onVacancyClickListener: (Vacancy) -> Unit
): RecyclerView.Adapter<VacancyAdapter.ViewHolder>() {
    private val vacancyList = ArrayList<Vacancy>()

    fun setData(randomList: ArrayList<Vacancy>){
        vacancyList.clear()
        vacancyList.addAll(randomList)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemVacancyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = vacancyList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(vacancyList[position])
    }

    inner class ViewHolder(
        private val binding: ItemVacancyBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(vacancy: Vacancy){
            with(binding){
                vacancyTitle.text = vacancy.title
                vacancyCompanyTitle.text = vacancy.companyTitle
                vacancyCity.text = vacancy.city
                vacancyExperience.text = "Требуемый опыт: от ${vacancy.experience} лет"
                vacancyDate.text = vacancy.date

                root.setOnClickListener{
                    onVacancyClickListener(vacancy)
                }
            }
        }
    }
}