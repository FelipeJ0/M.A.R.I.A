package com.android.maria.itemlista

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.android.maria.R
import com.android.maria.model.Tarefa
import com.android.maria.repositorio.TarefasRepositorio
import com.android.maria.ui.theme.CardBg
import com.android.maria.ui.theme.Light_Pink
import com.android.maria.ui.theme.PinkTP
import com.android.maria.ui.theme.Radio_Button_Green_Selected
import com.android.maria.ui.theme.Radio_Button_Red_Selected
import com.android.maria.ui.theme.Radio_Button_Yellow_Selected
import com.android.maria.ui.theme.ShapeCardPrioridade
import com.android.maria.ui.theme.White
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun TarefaItem(
    position: Int,
    listaTarefas: MutableList<Tarefa>,
    context: Context,
    navController: NavController
) {

    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade

    val scope = rememberCoroutineScope()
    val tarefasRepositorio = TarefasRepositorio()

    fun dialogDeletar() {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deletar Tarefa")
            .setMessage("Deseja excluir a tarefa?")
            .setPositiveButton("Sim") { _, _ ->
                tarefasRepositorio.deletarTarefa(tituloTarefa.toString())

                scope.launch(Dispatchers.Main){
                    listaTarefas.removeAt(position)
                    navController.navigate("listaTarefa")
                    Toast.makeText(context, "Sucesso ao deletar tarefa!",Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Não") { _, _ ->

            }
        .show()
    }

    //Validando o texto da caixa de tarefa referente aos niveis de prioridade
    var nivelDePrioridade: String = when (prioridade) {
        0 -> {
            "Sem prioridade"
        }

        1 -> {
            "Prioridade Baixa"
        }

        2 -> {
            "Prioridade Média"
        }

        else -> {
            "Prioridade Alta"
        }
    }

    //Validando a cor do icone de nivel de prioridade referente aos niveis de prioridade
    val color = when (prioridade) {
        0 -> {
            Color.Black
        }

        1 -> {
            Radio_Button_Green_Selected
        }

        2 -> {
            Radio_Button_Yellow_Selected
        }

        else -> {
            Radio_Button_Red_Selected
        }
    }


    Card(
        backgroundColor = CardBg,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtTitulo, txtDescricao, cardPrioridade, txtPrioridade, btDeletar) = createRefs()

            Text(
                text = tituloTarefa.toString(),
                modifier = Modifier.constrainAs(txtTitulo) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)

                },
                color = White,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = descricaoTarefa.toString(),
                modifier = Modifier.constrainAs(txtDescricao) {
                    top.linkTo(txtTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)

                },
                color = White,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = nivelDePrioridade,
                modifier = Modifier.constrainAs(txtPrioridade) {
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                },
                color = White,
                fontWeight = FontWeight.Bold,
            )

            Card(
                backgroundColor = color,
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPrioridade) {
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(txtPrioridade.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    },
                shape = ShapeCardPrioridade.large
            ) {

            }

            IconButton(
                onClick = {
                    dialogDeletar()
                },
                modifier = Modifier.constrainAs(btDeletar) {
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(cardPrioridade.end, margin = 10.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            }

        }
    }
}

