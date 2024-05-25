package com.android.maria.itemlista

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.maria.ui.theme.Light_Pink

@Composable
fun TarefaItem(

){
    androidx.compose.material.Card(
        backgroundColor = Light_Pink,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {

    }
}

@Composable
@Preview
private fun TaredaItemPreview(){
    TarefaItem()
}