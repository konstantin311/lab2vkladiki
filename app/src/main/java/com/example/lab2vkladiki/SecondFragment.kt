package com.example.lab2vkladiki

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.Toast


class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)

        val listView = rootView.findViewById<ListView>(R.id.listView)

        // Создаем список данных
        val dataList = listOf("Николай", "Коля", "Колян", "Николаич", "Ник", "Николас")

        // Создаем и устанавливаем адаптер для ListView
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, dataList)
        listView.adapter = adapter

        // Обработка событий нажатия на элемент списка
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataList[position]
            Toast.makeText(requireContext(), "Вы выбрали: $selectedItem", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }
}