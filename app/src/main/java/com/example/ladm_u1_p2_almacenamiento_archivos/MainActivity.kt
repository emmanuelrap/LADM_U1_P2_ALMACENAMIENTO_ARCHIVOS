package com.example.ladm_u1_p2_almacenamiento_archivos

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos1
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos2
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos3
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos4

import com.example.ladm_u1_p2_almacenamiento_archivos.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)


        binding.appBarMain.fab.setOnClickListener { view ->
            guardarArchivoTXT()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        try {
            abrirTXT()
        }catch (e:Exception){
            androidx.appcompat.app.AlertDialog.Builder(this).setMessage(e.message).show()
        }
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    private fun guardarArchivoTXT() {
        try {
            val archivo = OutputStreamWriter(openFileOutput("archivo.txt", MODE_PRIVATE))
            var espacio = datos1.size-1
            var cad = " "
            
            //Creamos la cadena mediante un ciclo
            (0..espacio).forEach{
                if(it == espacio){
                    cad += datos1[it]+"||"+datos2[it]+"||"+datos3[it]+"||"+datos4[it]
                }
                cad += datos1[it]+"||"+datos2[it]+"||"+datos3[it]+"||"+datos4[it]+"&&"
                Toast.makeText(this, "GUADADO EXITOSO", Toast.LENGTH_LONG).show()
            }
            archivo.write(cad)
            archivo.flush()
            archivo.close()
            androidx.appcompat.app.AlertDialog.Builder(this).setMessage("SE GUARDO").show()
        }catch (e:Exception){
            androidx.appcompat.app.AlertDialog.Builder(this).setMessage(e.message).show()
        }
    }

    private fun abrirTXT() {
        try {
            val archivo = BufferedReader(InputStreamReader(openFileInput("archivo.txt")))
            var lista = archivo.readLine()//archivo de tipo list
            val dividir = lista.split("&&")
            (0..dividir.size).forEach {
                var cadena2 = dividir[it].split("||")
                datos1[it]=cadena2[0]
                datos2[it]=cadena2[1]
                datos3[it]=cadena2[2]
                datos4[it]=cadena2[3]
            }

            AlertDialog.Builder(this)
                .setMessage(lista.toString()).show()
        }catch (e: Exception){
            AlertDialog.Builder(this)
                .setMessage(e.message).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}