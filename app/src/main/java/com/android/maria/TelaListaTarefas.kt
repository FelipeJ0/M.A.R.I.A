package com.android.maria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.maria.tarefasview.ListaTarefas
import com.android.maria.tarefasview.SalvarTarefas
import com.android.maria.ui.theme.MARIATheme

class TelaListaTarefas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MARIATheme {


                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()


                //controla a navegação entre as telas

                NavHost(navController = navController, startDestination = "listaTarefa"){

                  composable(
                          //criada uma rota e atribuida um id a mesma
                          route = "listaTarefa"
                  ){
                      ListaTarefas(navController)
                  }

                  composable(
                          //criada uma rota e atribuida um id a mesma
                          route = "salvarTarefa"
                  ){
                      SalvarTarefas(navController)
                  }
                }
            }
        }
    }
}



