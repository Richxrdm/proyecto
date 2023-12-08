package com.reminder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private var reminders : MutableList<Reminder> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)

        initData()

        val adapter = ReminderAdapter(reminders)

        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.remindersRecycler
            )


        //Variables para el elemento nuevo
        var _id : Int = 0
        var _note : String
        var _date : String

        fab.setOnClickListener {

            // Show Bottom Sheet Dialog and add a new item
            val bottomSheetFragment = BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_reminder, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            //elementos del formulario bsd
            val newId = parentView.findViewById<EditText>(R.id.bsd_reminder_id)
            val newName = parentView.findViewById<EditText>(R.id.bsd_reminder_note)
            val newCapital = parentView.findViewById<EditText>(R.id.bsd_reminder_date)


            val button = parentView.findViewById<Button>(R.id.bsd_submit)

            //boton guardar del bsd, asignación de valores y creación del nuevo elemento
            button.setOnClickListener{
                _id = newId.text.toString().toInt()
                _note = newName.text.toString()
                _date = newCapital.text.toString()

                val newProductAdd = Reminder(
                    _id,
                    _note,
                    _date
                )

                reminders.add(newProductAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                bottomSheetFragment.dismiss()
            }
        }

        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        reminders = mutableListOf(
            Reminder(1, "Ir a la Universidad", "07/12/2023"),
            Reminder(2, "Ir al Trabajo", "07/12/2023"),
            Reminder(3, "Ir al la Casa", "07/12/2023"),
            Reminder(4, "Comer", "07/12/2023"),
            Reminder(5, "Hacer la Tarea", "07/12/2023"),
            Reminder(6, "Ir al Gimnasio", "07/12/2023"),
            Reminder(7, "Ir al Super", "07/12/2023"),
            Reminder(8, "Sacar a pasear al perro", "07/12/2023"),
            Reminder(9, "Limpiar", "07/12/2023"),
            Reminder(10, "Hacer la cena", "07/12/2023")
        )
    }
}