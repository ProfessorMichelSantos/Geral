/*
package com.aula.geral

import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var txtfone: EditText
private lateinit var txtmensagem: EditText
private lateinit var btnbotao: Button


/**
 * A simple [Fragment] subclass.
 * Use the [Mensagens.newInstance] factory method to
 * create an instance of this fragment.
 */
class Mensagens : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_mensagens, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botaosms : Button = view.findViewById(R.id.botaomensagem)
        txtfone = view.findViewById(R.id.telefone)
        txtmensagem = view.findViewById(R.id.mensagem)
/*
        botaosms.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this.requireActivity().baseContext, Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION) == PackageManager.PERMISSION_GRANTED){
                SMS()
            }else{
                ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION),100 )
            }
        }

    }
*/
    private fun SMS(){
        val telefone : String = txtfone.text.toString()
        val mensagem : String = txtmensagem.text.toString()

        //val smsManager : SmsManager = SmsManager.getDefault()
        val smsManager = this.requireActivity().baseContext.getSystemService<SmsManager>(SmsManager::class.java)


        smsManager.sendTextMessage(telefone, null,mensagem,null,null)

        Toast.makeText(this.requireActivity().baseContext, "SMS Enviado", Toast.LENGTH_SHORT).show()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Mensagens.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Mensagens().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
*/
