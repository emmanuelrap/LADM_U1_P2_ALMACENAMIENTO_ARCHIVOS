package com.example.ladm_u1_p2_almacenamiento_archivos.ui.gallery

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.a
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.b
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.c
import com.example.ladm_u1_p2_almacenamiento_archivos.databinding.FragmentGalleryBinding
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos1
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos2
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos3
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.datos4
import kotlinx.android.synthetic.main.card_layout.*
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root





        binding.btn1.setOnClickListener {
            try {
                b=0
                val espacio = datos1.size-1
                (0..espacio).forEach {
                    if (idServicios.text.toString().equals(datos3[it])) {
                        AlertDialog.Builder(requireContext())
                            .setTitle("ID Repetido")
                            .setPositiveButton("OK", { d, i -> d.dismiss() })
                            .setNegativeButton("EXIT", { d, i -> d.cancel() })
                            .show()
                        b = 1
                    }
                }
                (0..espacio).forEach {
                    if (datos3[it].isEmpty() && b == 0) {
                        datos1[it] = binding.nombre.text.toString()
                        datos2[it] = binding.modelo.text.toString()
                        datos3[it] = binding.idServicios.text.toString()
                        datos4[it] = binding.costo.text.toString()
                        b=1
                    }
                }

            }catch (e:Exception){
                AlertDialog.Builder(requireContext())
                    .setMessage(e.message)
                    .show()
            }
            binding.nombre.setText("")
            binding.modelo.setText("")
            binding.costo.setText("")
            binding.idServicios.setText("")
            Toast.makeText(requireContext(), "Registro Insertado", Toast.LENGTH_LONG).show()
        }

        binding.btn4.setOnClickListener {
            try{
                b=0
                val espacio =datos1.size-1

                (0..espacio).forEach {
                    if(idServicios.text.toString().equals(datos3[it])){
                        binding.nombre.setText(datos1[it])
                        binding.modelo.setText(datos2[it])
                        binding.idServicios.setText(datos3[it])
                        binding.costo.setText(datos4[it])
                        b=1
                    }
                }
                if(b==0){
                    AlertDialog.Builder(requireContext())
                        .setTitle("No Existe ese Servicio")
                        .setPositiveButton("OK",{d, i->d.dismiss()})
                        .setNegativeButton("EXIT", {d, i->d.cancel()})
                        .show()
                }
            }catch (e:Exception){
                AlertDialog.Builder(requireContext())
                    .setMessage(e.message)
                    .show()
            }
        }
        binding.btn3.setOnClickListener {
            try {
                b=0
                val espacio = datos1.size-1
                (0..espacio).forEach {
                    if(idServicios.text.toString().equals(datos3[it])) {
                        datos1[it] = binding.nombre.text.toString()
                        datos2[it] = binding.modelo.text.toString()
                        datos3[it] = binding.idServicios.text.toString()
                        datos4[it] = binding.costo.text.toString()
                        b=1
                    }
                }
                if(b==0){
                    AlertDialog.Builder(requireContext())
                        .setTitle("NO COINCIDE EL ID")
                        .setPositiveButton("OK",{d, i->d.dismiss()})
                        .setNegativeButton("EXIT", {d, i->d.cancel()})
                        .show()
                }
                binding.nombre.setText("")
                binding.modelo.setText("")
                binding.costo.setText("")
                binding.idServicios.setText("")
                Toast.makeText(requireContext(), "ACTUALIZACION EXITOSA", Toast.LENGTH_LONG).show()
            }catch (e:Exception){
                AlertDialog.Builder(requireContext())
                    .setMessage(e.message)
                    .show()
            }
        }
        binding.btn2.setOnClickListener {
            try{
                b=0
                c--
                val espacio =datos1.size-1
                (0..espacio).forEach {
                    if(idServicios.text.toString().equals(datos3[it])){
                        //  z--
                        a=it
                        datos1[it]=""
                        datos2[it]=""
                        datos3[it]=""
                        datos4[it]=""
                        b=1
                    }
                }
                if(b==0){
                    AlertDialog.Builder(requireContext())
                        .setTitle("NO EXISTE")
                        .setPositiveButton("OK",{d, i->d.dismiss()})
                        .setNegativeButton("EXIT", {d, i->d.cancel()})
                        .show()
                }
                binding.nombre.setText("")
                binding.modelo.setText("")
                binding.costo.setText("")
                binding.idServicios.setText("")
                Toast.makeText(requireContext(), "ELIMINACION EXITOSA", Toast.LENGTH_LONG).show()
            }catch (e:Exception){
                AlertDialog.Builder(requireContext())
                    .setMessage(e.message)
                    .show()
            }

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}