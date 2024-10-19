package com.example.hh

import java.util.UUID

data class Vacancy(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val companyTitle: String,
    val city: String,
    val experience: String,
    val date: String,
    val description: String
)
