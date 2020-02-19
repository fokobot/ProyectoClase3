package com.example.proyectoclase3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclase3.R
import com.example.proyectoclase3.databinding.RowBinding
import com.example.proyectoclase3.data.User
import kotlinx.android.synthetic.main.row.view.*

class MyViewAdapter(
    private val data: List<User>,
    private val mListener: onListInteraction
) : RecyclerView.Adapter<MyViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        var binder : RowBinding
        binder  = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row, parent, false)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.mView.user = item
        holder.mView.executePendingBindings()
        holder.mView.theLayout.setOnClickListener{
            mListener?.onListItemInteraction(item)
        }

        //holder.textViewNombre.text = item.nombre
        //holder.textViewApellidos.text = item.apellidos

        //holder.itemView.setOnClickListener {
        //   mListener.onListItemInteraction(item)
        //}
    }

    fun updateData() {
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: RowBinding) : RecyclerView.ViewHolder(mView.root) {
        //val textViewNombre: TextView = mView.textViewNombre
        //val textViewApellidos: TextView = mView.textViewApellidos
    }

    interface onListInteraction {
        fun onListItemInteraction(item: User?)
    }

}