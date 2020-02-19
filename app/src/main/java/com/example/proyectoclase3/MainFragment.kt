package com.example.proyectoclase3


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclase3.adapters.MyViewAdapter
import com.example.proyectoclase3.data.User
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), MyViewAdapter.onListInteraction {

    val users = mutableListOf<User>()
    private var adapter: MyViewAdapter? = null
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val informacion = arrayOf(
            arrayOf("Maxence", "Leclerc", "maxence.leclerc@example.com", "06-85-38-79-07"),
            arrayOf("Alex", "Brown", "alex.brown@example.com", "(565)-066-2188"),
            arrayOf("Alicia", "Li", "alicia.li@example.com", "624-814-4913"),
            arrayOf("Terrence", "Rivera", "terrence.rivera@example.com", "0758-007-946"),
            arrayOf("Allan", "Hoffman", "allan.hoffman@example.com", "0771-510-200"),
            arrayOf("Ayla", "Hughes", "ayla.hughes@example.com", "(029)-065-4895"),
            arrayOf("Charles", "Ambrose", "charles.ambrose@example.com", "224-994-8482"),
            arrayOf("Marie", "Larsen", "marie.larsen@example.com", "79778472"),
            arrayOf("Amy", "Andrews", "amy.andrews@example.com", "0759-252-171")
        )

        informacion.forEach {
            users.add(
                User(it[0], it[1])
            )
        }

        users.add(User("Luis", "Carcamo"))

        adapter = MyViewAdapter(users, this)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onListItemInteraction(item: User?) {
        val bundle = bundleOf("data" to item)
        navController!!.navigate(R.id.action_mainFragment_to_personaFragment)
    }


}
