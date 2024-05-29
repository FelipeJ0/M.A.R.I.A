package com.android.maria.tarefasview

import  android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.maria.componentes.Botao
import com.android.maria.componentes.CaixaDeTexto
import com.android.maria.constantes.Constantes
import com.android.maria.repositorio.TarefasRepositorio
import com.android.maria.ui.theme.PinkTP
import com.android.maria.ui.theme.Radio_Button_Green_Disabled
import com.android.maria.ui.theme.Radio_Button_Green_Selected
import com.android.maria.ui.theme.Radio_Button_Red_Disabled
import com.android.maria.ui.theme.Radio_Button_Red_Selected
import com.android.maria.ui.theme.Radio_Button_Yellow_Disabled
import com.android.maria.ui.theme.Radio_Button_Yellow_Selected
import com.android.maria.ui.theme.White
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SalvarTarefas(navController: NavController){

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val tarefasRepositorio = TarefasRepositorio()

    androidx.compose.material.Scaffold(
        topBar = {
            androidx.compose.material.TopAppBar(
                backgroundColor = PinkTP,
                title = {
                    Text(
                        text = "Salvar Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White)
                }
            )
        }
    ){
       //estado do titulo da terefa
       var tituloTerefa by remember {
           mutableStateOf("")
       }

       var descricaoTarefa by remember {
           mutableStateOf("")
       }

       var semPrioridadeTarefa by remember {
           mutableStateOf(false)
       }

        var prioridadeBaixaTarefa by remember {
            mutableStateOf(false)
        }

        var prioridadeMediaTarefa by remember {
            mutableStateOf(false)
        }

        var prioridadeAltaTarefa by remember {
            mutableStateOf(false)
        }




        Column(
           modifier = Modifier

               .fillMaxSize()
               .verticalScroll(rememberScrollState())
       ) {
           //título da terefa
            CaixaDeTexto(
                value = tituloTerefa ,
                onValueChange = {
                   tituloTerefa = it
                }, //recebe o texto digitado e passa para a variavel tituloTerefa
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Título da tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

           CaixaDeTexto(
               value = descricaoTarefa ,
               onValueChange = {
                   descricaoTarefa = it
               }, //recebe o texto digitado e passa para a variavel tituloTerefa
               modifier = Modifier
                   .fillMaxWidth()
                   .height(150.dp)
                   .padding(20.dp, 10.dp, 20.dp, 0.dp),
               label = "Descrição",
               maxLines = 5,
               keyboardType = KeyboardType.Text
           )
           Row (
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Center,
               modifier = Modifier.fillMaxWidth()
           ){
                Text(text = "Nivel de prioridade")
               
               RadioButton(
                   selected = prioridadeBaixaTarefa,
                   onClick = {
                        prioridadeBaixaTarefa = !prioridadeBaixaTarefa
                   },
                   colors = androidx.compose.material.RadioButtonDefaults.colors(
                       unselectedColor = Radio_Button_Green_Disabled,
                       selectedColor = Radio_Button_Green_Selected
                   )
                   )

               RadioButton(
                   selected = prioridadeMediaTarefa,
                   onClick = {
                       prioridadeMediaTarefa = !prioridadeMediaTarefa
                   },
                   colors = androidx.compose.material.RadioButtonDefaults.colors(
                       unselectedColor = Radio_Button_Yellow_Disabled,
                       selectedColor = Radio_Button_Yellow_Selected
                   )
               )

               RadioButton(
                   selected = prioridadeAltaTarefa,
                   onClick = {
                       prioridadeAltaTarefa = !prioridadeAltaTarefa
                   },
                   colors = androidx.compose.material.RadioButtonDefaults.colors(
                       unselectedColor = Radio_Button_Red_Disabled,
                       selectedColor = Radio_Button_Red_Selected
                   )
               )

           }

            Botao(
                onClick = {

                    var mensagem = true

                    scope.launch(Dispatchers.IO){
                        if(tituloTerefa.isEmpty()){
                            mensagem = false
                        }
                        else if (tituloTerefa.isNotEmpty() && descricaoTarefa.isNotEmpty() && prioridadeBaixaTarefa){
                            tarefasRepositorio.salvarTarefa(tituloTerefa, descricaoTarefa, Constantes.PRIORIDADE_BAIXA)
                            mensagem = true
                        }
                    }

                    scope.launch(Dispatchers.Main){
                        if(mensagem){
                            Toast.makeText(context, "Sucesso ao salvar a tarefa!", Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        }
                        else{
                            Toast.makeText(context, "Título da tarefa é obrigatório", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp),
                texto = "Salvar")
       }
    }
}