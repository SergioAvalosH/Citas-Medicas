package com.recyclerview.app_citas_medicas.view.ui.fragments.pacienteFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.recyclerview.app_citas_medicas.R

class UbicacionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubicacion, container, false)
    }
    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parame

        de:	Aldair Leonardo Diaz Lopez <aldair14101997@gmail.com>
        para:	Stefanía Cajusol <mili.cajusol@gmail.com>
        fecha:	22 ago. 2021 05:31
        asunto:	Re: Sanado y salvado por si te preguntabas
        enviado por:	gmail.com
        ter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UbicacionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UbicacionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}