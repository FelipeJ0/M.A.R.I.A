package com.android.maria.tarefasview


import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.maria.R
import com.android.maria.ui.theme.PinkTP
import com.android.maria.ui.theme.White


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ListaTarefas(navController: NavController){
    Scaffold (
            topBar = {
                androidx.compose.material.TopAppBar(
                backgroundColor = PinkTP,
                        title = {
                            Text(text = "Lista de Tarefas",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = White)
                        }
                )



            }
                ){

    }
}



