package com.android.maria.repositorio

import com.android.maria.datasource.DataSource
import com.android.maria.model.Tarefa
import kotlinx.coroutines.flow.Flow

class TarefasRepositorio{

    private val datasource = DataSource()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int){

        datasource.salvarTarefa(tarefa,descricao,prioridade)

    }

    //retorna a lista pronta, presente no banco de dados
    fun recuperarTarefas(): Flow<MutableList<Tarefa>>{
        return datasource.recuperarTarefas()
    }

    fun deletarTarefa(tarefa: String){
        datasource.deletarTarefa(tarefa)
    }
}