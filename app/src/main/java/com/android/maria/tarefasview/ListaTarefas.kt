package com.android.maria.tarefasview

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ListaTarefas(navController: NavController){
    Scaffold (
            topBar = {
                TopAppBar(
                        title = {
                            Text(
                                    text = "Lista de tarefas",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = White

                            )

                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = PinkTP)

                )
    )


}



