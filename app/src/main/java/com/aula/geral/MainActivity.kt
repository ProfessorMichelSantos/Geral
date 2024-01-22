package com.aula.geral

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentTransaction
import com.aula.geral.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//VERSAO  1
    private lateinit var binding: ActivityMainBinding

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("Activity", "Changed")
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            Toast.makeText(this, "A tela mudou para landscape", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)




        binding.escuro.setOnCheckedChangeListener { compoundButton, ischecked ->
            if (ischecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

        }

            binding.shared.setOnClickListener{
                var frag : SharedPreferences = SharedPreferences.newInstance("","")
                var transacao : FragmentTransaction = supportFragmentManager.beginTransaction();
                transacao.add(R.id.fragmentContainerView2 , frag)
                transacao.commit()
            }

            binding.sensor.setOnClickListener{
                var frag : SensorManager = SensorManager.newInstance("","")
                var transacao : FragmentTransaction = supportFragmentManager.beginTransaction();
                transacao.add(R.id.fragmentContainerView2, frag)
                transacao.commit()
            }

            binding.mediastore.setOnClickListener{
                var frag : Mediastore = Mediastore.newInstance("","")
                var transacao : FragmentTransaction = supportFragmentManager.beginTransaction();
                transacao.add(R.id.fragmentContainerView2, frag)
                transacao.commit()
            }

            binding.impressao.setOnClickListener{

            }

            binding.imersivo.setOnClickListener{

            }
            binding.message.setOnClickListener{

            }



    }


}