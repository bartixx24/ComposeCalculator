package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

     companion object {
         private const val MAX_NUM_LENGTH = 8
     }

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Number -> number(action.Number)
            is CalculatorAction.Clear -> clearCal()
            is CalculatorAction.Delete -> deleteCal()
            is CalculatorAction.Decimal -> decimal()
            is CalculatorAction.Calculate -> calculate()
            is CalculatorAction.Operation -> operation(action.operation)
        }
    }

    private fun operation(operation: CalculatorOperation) {
        if(state.num1.isNotBlank()) {
            state = state.copy( operation = operation )
        }
    }

    private fun calculate() {

        val number1 = state.num1.toDoubleOrNull()
        val number2 = state.num2.toDoubleOrNull()

        if(number1 != null && number2 != null) {

            val result = when(state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return
            }

            state = state.copy(
                num1 = result.toString().take(15),
                num2 = "",
                operation = null
            )

        }

    }

    private fun decimal() {

        if(state.operation == null && !state.num1.contains(".") && state.num1.isNotBlank()) {
            state = state.copy ( num1 = state.num1 + "." )
        }
        else if (state.operation != null && !state.num2.contains(".") && state.num2.isNotBlank()) {
            state = state.copy ( num2 = state.num2 + "." )
        }

    }

    private fun deleteCal() {
        if(state.num2.isNotBlank()) {
            state = state.copy( num2 = state.num2.dropLast(1) )
        }

        else if(state.operation != null) {
            state = state.copy( operation = null )
        }

        else if(state.num1.isNotBlank()) {
            state = state.copy( num1 = state.num1.dropLast(1) )
        }

    }

    private fun clearCal() {
        state = CalculatorState()
    }

    private fun number(num: Int) {

        if(state.operation == null) {
            if(state.num1.length < MAX_NUM_LENGTH)   {
                state = state.copy(
                    num1 = state.num1 + num
                )
            } else return
        }

        else {
            if(state.num2.length < MAX_NUM_LENGTH) {
                state = state.copy(
                    num2 = state.num2 + num
                )
            } else return
        }

    }

}