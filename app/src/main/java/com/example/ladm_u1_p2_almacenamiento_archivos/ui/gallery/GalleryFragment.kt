package com.example.ladm_u1_p2_almacenamiento_archivos.ui.gallery

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ladm_u1_p2_almacenamiento_archivos.databinding.FragmentGalleryBinding
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.i
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.informacion1
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.informacion2
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.informacion3
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.informacion4
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.y
import com.example.ladm_u1_p2_almacenamiento_archivos.Arreglo.z

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
            val espacio = informacion1.size - 1

           /* informacion1[it] = binding.et1.text.toString()
            informacion2[it] = binding.et2.text.toString()
            informacion3[it] = binding.et3.text.toString()
            informacion4[it] = binding.et4.text.toString()*/

            binding.et1.setText("")
            binding.et2.setText("")
            binding.et4.setText("")
            binding.et3.setText("")
            Toast.makeText(requireContext(), "SE INSERTO CORRECTAMENTE", Toast.LENGTH_LONG).show()
        }



        binding.btn2.setOnClickListener {
            try{
                y=0
                z--
                val espacio =informacion1.size-1
                (0..espacio).forEach {
                    if(binding.et3.text.toString().equals(informacion3[it])){
                        //  z--
                        i=it
                        informacion1[it]=""
                        informacion2[it]=""
                        informacion3[it]=""
                        informacion4[it]=""
                        y=1
                    }
                }
                if(y==0){
                    AlertDialog.Builder(requireContext())
                        .setTitle("EL ID BUSCADO NO EXISTE")
                        .setPositiveButton("ACEPTAR",{d, i->d.dismiss()})
                        .setNegativeButton("SALIR", {d, i->d.cancel()})
                        .show()
                }
                binding.et1.setText("")
                binding.et2.setText("")
                binding.et4.setText("")
                binding.et3.setText("")
                Toast.makeText(requireContext(), "SE ELIMINO CORRECTAMENTE", Toast.LENGTH_LONG).show()
            }catch (e:Exception){
                AlertDialog.Builder(requireContext())
                    .setMessage(e.message)
                    .show()
            }

        }




        binding.btn3.setOnClickListener {
            try {
                y=0
                val espacio = informacion1.size-1
                (0..espacio).forEach {
                    if(binding.et3.text.toString().equals(informacion3[it])) {
                        informacion1[it] = binding.et1.text.toString()
                        informacion2[it] = binding.et2.text.toString()
                        informacion3[it] = binding.et3.text.toString()
                        informacion4[it] = binding.et4.text.toString()
                        y=1
                    }
                }
                if(y==0){
                    AlertDialog.Builder(requireContext())
                        .setTitle("EL ID BUSCADO NO EXISTE")
                        .setPositiveButton("ACEPTAR",{d, i->d.dismiss()})
                        .setNegativeButton("SALIR", {d, i->d.cancel()})
                        .show()
                }
                binding.et1.setText("")
                binding.et2.setText("")
                binding.et4.setText("")
                binding.et3.setText("")
                Toast.makeText(requireContext(), "SE ACTUALIZO CORRECTAMENTE", Toast.LENGTH_LONG).show()
            }catch (e:Exception){
                AlertDialog.Builder(requireContext())
                    .setMessage(e.message)
                    .show()
            }
        }



        binding.btn4.setOnClickListener {
            try{
                y=0
                val espacio =informacion1.size-1
                (0..espacio).forEach {
                    if(binding.et3.text.toString().equals(informacion3[it])){
                        binding.et1.setText(informacion1[it])
                        binding.et2.setText(informacion2[it])
                        binding.et3.setText(informacion3[it])
                        binding.et4.setText(informacion4[it])
                        y=1
                    }
                }
                if(y==0){
                    AlertDialog.Builder(requireContext())
                        .setTitle("EL ID BUSCADO NO EXISTE")
                        .setPositiveButton("ACEPTAR",{d, i->d.dismiss()})
                        .setNegativeButton("SALIR", {d, i->d.cancel()})
                        .show()
                }
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