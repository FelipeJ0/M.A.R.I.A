package com.android.maria.tarefasview

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.maria.R
import com.android.maria.ui.theme.PinkTP
import com.android.maria.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ListaTarefas(navController: NavController) {
    androidx.compose.material.Scaffold (
        topBar = {
            androidx.compose.material.TopAppBar(
                backgroundColor = PinkTP,
                title = {
                    Text(
                        text = "Lista de Terefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            )
        },

        backgroundColor = White,
        floatingActionButton = {
           androidx.compose.material.FloatingActionButton(onClick = {
               navController.navigate("salvarTarefa")

           },
               backgroundColor = PinkTP
               ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Icone de salvar tarefa")
           }
        },


        bottomBar = {
            androidx.compose.material.BottomAppBar(
                backgroundColor = PinkTP,

            ) {
                IconButton(onClick = { },

                    ) {

                    Image(
                        modifier = Modifier.size(100.dp,100.dp),

                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_person),
                        contentDescription = "Icone da tela principal",
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Fit
                        )

                }

                IconButton(onClick = { },
                ) {
                    Image(
                        modifier = Modifier.size(100.dp,100.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_home),
                        contentDescription = "Icone da tela principal",
                        alignment = Alignment.Center
                    )

                }

                IconButton(onClick = { navController.navigate("listaTarefa")  },
                ) {
                    Image(
                        modifier = Modifier.size(100.dp,100.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_checklist),
                        contentDescription = "Icone da tela lista de tarefas",
                        alignment = Alignment.Center
                    )

                }
            }
        }
    ) {


    }


}






