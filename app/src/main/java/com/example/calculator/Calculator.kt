package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.LightGray
import com.example.calculator.ui.theme.MediumGray
import com.example.calculator.ui.theme.Orange

@Composable
fun Calculator(state: CalculatorState, modifier: Modifier = Modifier, buttonSpacing: Dp = 8.dp,
    functions: (CalculatorAction) -> Unit) {

    Box(modifier = modifier) {
        Column(

            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {

            Text(
                text = state.num1 + (state.operation?.symbol ?: "") + state.num2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                style = TextStyle(fontSize = 70.sp),
                //fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    text = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    function = { functions(CalculatorAction.Clear) }
                )

                CalculatorButton(
                    text = "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Delete) }
                )
                CalculatorButton(
                    text = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Operation(CalculatorOperation.Divide)) }
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                modifier = Modifier.fillMaxWidth()
            ) {

                CalculatorButton(
                    text = "1",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Number(1)) }
                )

                CalculatorButton(
                    text = "2",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Number(2)) }
                )

                CalculatorButton(
                    text = "3",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Number(3)) }
                )

                CalculatorButton(
                    text = "X",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Operation(CalculatorOperation.Multiply)) }
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                modifier = Modifier.fillMaxWidth()
            ) {

                CalculatorButton(
                    text = "4",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Number(4)) }
                )

                CalculatorButton(
                    text = "5",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Number(5)) }
                )

                CalculatorButton(
                    text = "6",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Number(6)) }
                )

                CalculatorButton(
                    text = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Operation(CalculatorOperation.Subtract)) }
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                modifier = Modifier.fillMaxWidth()
            ) {

                CalculatorButton(
                    text = "7",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Number(7)) }
                )

                CalculatorButton(
                    text = "8",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Number(8)) }
                )

                CalculatorButton(
                    text = "9",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Number(9)) }
                )

                CalculatorButton(
                    text = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Operation(CalculatorOperation.Add)) }
                )
            }
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                modifier = Modifier.fillMaxWidth()
            ) {

                CalculatorButton(
                    text = "0",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    function = { functions(CalculatorAction.Number(0)) }
                )

                CalculatorButton(
                    text = ".",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Decimal) }
                )

                CalculatorButton(
                    text = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    function = { functions(CalculatorAction.Calculate) }
                )
            }
            
        }
    }

}