package com.example.lab2vkladiki

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.LinearLayout
import android.widget.TextView

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_third, container, false)

        val tableLayout = TableLayout(requireContext())
        val tableParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        tableLayout.layoutParams = tableParams

        // Создаем строки и столбцы в TableLayout
        for (i in 0 until 20) {
            val tableRow = TableRow(requireContext())

            val textView1 = TextView(requireContext())
            textView1.text = "Строка $i, Столбец 1"

            val textView2 = TextView(requireContext())
            textView2.text = "Строка $i, Cтолбец 2"

            tableRow.addView(textView1)
            tableRow.addView(textView2)
            tableLayout.addView(tableRow)
        }

        val linearLayout = rootView.findViewById<LinearLayout>(R.id.container_layout) // Получаем родительский Layout
        linearLayout.addView(tableLayout)

        return rootView
    }
}
