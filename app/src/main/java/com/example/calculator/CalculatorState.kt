package com.example.calculator

data class CalculatorState(
    val num1: String = "",
    var num2: String = "",
    val operation: CalculatorOperation? = null
)
