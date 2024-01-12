package com.kishan.apidemo.apimodel

data class ApiData(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)