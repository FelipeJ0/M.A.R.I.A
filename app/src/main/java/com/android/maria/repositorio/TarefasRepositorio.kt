package com.android.maria.repositorio

import com.android.maria.datasource.DataSource

class TarefasRepositorio{

    private val datasource = DataSource()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int){

        datasource.salvarTarefa(tarefa,descricao,prioridade)

    }
}