package com.reminder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReminderAdapter(private var reminders: List<Reminder>): RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_reminder, parent, false)
        return ReminderViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
        val reminder = reminders[position]
        holder.render(reminder)

        //aquí se aplica la lógica. ej: onClickListener
    }

    override fun getItemCount(): Int {
        return reminders.size
    }

    class ReminderViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val note: TextView = view.findViewById(R.id.reminder)
        val date: TextView = view.findViewById(R.id.date)

        fun render(reminders: Reminder) {
            note.text = reminders.note + ", "
            date.text = reminders.date
        }
    }
}