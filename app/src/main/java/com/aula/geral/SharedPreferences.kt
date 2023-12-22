package com.aula.geral

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SharedPreferences : Fragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shared_preferences, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val botao : Button = view.findViewById(R.id.btnshared)
        val botaoload : Button = view.findViewById(R.id.btnsharedload)

        val nome : EditText = view.findViewById(R.id.txtnome)
        val email : EditText = view.findViewById(R.id.txtemail)

        val txtnomeload : TextView = view.findViewById(R.id.lblNomeload)
        val txtemailload : TextView = view.findViewById(R.id.emailload)

        val sharedpref = activity?.getSharedPreferences("pref", MODE_PRIVATE)
        val edit= sharedpref?.edit()


        botao.setOnClickListener {
            edit?.apply{
                putString("username", nome.text.toString())
                putString("email", email.text.toString())
                apply()
            }
        }

        botaoload.setOnClickListener{
            val nomeload = sharedpref?.getString("username", null).toString()
            val emailload = sharedpref?.getString("email", null).toString()


            txtnomeload.setText(nomeload.toString())
            txtemailload.setText(emailload.toString())


        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SharedPreferences.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SharedPreferences().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}