package com.android.maria.componentes

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.android.maria.ui.theme.PinkTP
import com.android.maria.ui.theme.White

@Composable
fun Botao(
    onClick:() -> Unit,
    modifier: Modifier,
    texto: String
){

    androidx.compose.material.Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PinkTP,
            contentColor = White
        )
    ) {
        Text(
            text = texto,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}