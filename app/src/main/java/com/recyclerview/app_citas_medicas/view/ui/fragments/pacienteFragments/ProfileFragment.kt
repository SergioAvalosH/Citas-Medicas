package com.recyclerview.app_citas_medicas.view.ui.fragments.pacienteFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.fragment_profile.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var displayMessage: String? = ""

    val db = Firebase.firestore
    // Para pasar datos al otro fragment

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
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        /*
        displayMessage = arguments?.getString("dni")
        view.tvDniPaciente.text = displayMessage

        // PAra enviar Dni al para editar
        comunicator = activity as Comunicator_Paciente

        view.editarDatosPaciente.setOnClickListener{
            comunicator.passDataFroProfiletoEdite(view.tvDniPaciente.text.toString())
        }

        var nombres: String = ""
        var apellidos: String = ""
        db.collection("usuarios").document(view.tvDniPaciente.text.toString()).get().addOnSuccessListener {
            nombres = it.get("Nombres").toString()
            apellidos = it.get("Apellidos").toString()
        }
        view.tvNombresPaciente.text = nombres
        view.tvApellidosPaciente.text = apellidos

         */
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}