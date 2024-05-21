package com.android.maria.componentes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.android.maria.ui.theme.Black
import com.android.maria.ui.theme.Light_Pink
import com.android.maria.ui.theme.ShapeEditText
import com.android.maria.ui.theme.White

@Composable
fun CaixaDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
){
    androidx.compose.material.OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            androidx.compose.material.Text(text = label)
            //passando o texto atraves da propriedade label
        },
        maxLines = maxLines,
        colors = androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors(
            textColor = Black,
            focusedBorderColor = Light_Pink,
            focusedLabelColor = Light_Pink,
            backgroundColor = White,
            cursorColor = Light_Pink
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}


//Visualizar em tempo real a caixa de texto criada
