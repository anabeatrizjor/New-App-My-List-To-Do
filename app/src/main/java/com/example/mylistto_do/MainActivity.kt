package com.example.mylistto_do

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

            private lateinit var editTextTask: EditText
            private lateinit var buttonAdd: Button
            private lateinit var listViewTasks: ListView

            private lateinit var tasksList: MutableList<String>
            private lateinit var adapter: ArrayAdapter<String>

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                // Inicialização dos componentes da UI
                editTextTask = findViewById(R.id.editTextTask)
                buttonAdd = findViewById(R.id.buttonAdd)
                listViewTasks = findViewById(R.id.listaDeTarefas)

                // Inicialização da lista de tarefas e do adaptador para a ListView
                tasksList = mutableListOf()
                adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasksList)
                listViewTasks.adapter = adapter

                // Configuração do botão para adicionar tarefa
                buttonAdd.setOnClickListener {
                    val task = editTextTask.text.toString().trim()
                    if (task.isNotEmpty()) {
                        addTask(task)
                        editTextTask.text.clear()
                    }
                }

                // Configuração do clique longo para remover tarefa
                listViewTasks.setOnItemLongClickListener { _, _, position, _ ->
                    removeTask(position)
                    true
                }
            }

            private fun addTask(task: String) {
                tasksList.add(task)
                adapter.notifyDataSetChanged()
            }

            private fun removeTask(position: Int) {
                tasksList.removeAt(position)
                adapter.notifyDataSetChanged()
            }
        }
