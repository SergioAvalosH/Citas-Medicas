package com.recyclerview.app_citas_medicas.view.ui.fragments.pacienteFragments

import android.app.ProgressDialog.show
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.fragment_edit_paciente_profile.*
import kotlinx.android.synthetic.main.fragment_edit_paciente_profile.view.*



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditPacienteProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditPacienteProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var displayMessage: String? = ""
    val db = Firebase.firestore
    var dni: String? = ""
    var contrasenia: String? = ""


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
        var view =  inflater.inflate(R.layout.fragment_edit_paciente_profile, container, false)

        displayMessage = arguments?.getString("dni")
        view.tvDNI.text = displayMessage

        // Lamacenar el dni y el password
        dni = displayMessage
        db.collection("usuarios").document(view.tvDNI.text.toString()).get().addOnSuccessListener {
            contrasenia = it.get("Contrase??a") as String?
            view.tvName.setText(it.get("Nombres") as String?)
            view.tvSurname.setText(it.get("Apellidos") as String?)
        }

        // actualizar
        view.UpdatePacienteProfile.setOnClickListener{
            var mensaje: String? = ""
            if(contrasenia == view.tvPassword.text.toString() ){
                db.collection("usuarios").document(view.tvDNI.text.toString()).set(
                    hashMapOf(
                        "Nombres" to view.tvName.text.toString(),
                        "Apellidos" to view.tvSurname.text.toString(),
                        "Contrase??a" to  view.tvPassword.text.toString())
                )
                mensaje = "??Actualizado!"
            }else{
                view.mensajeError.text = "Error, ingrese bien su contrase??a"
                view.tvName.text.clear()
                view.tvSurname.text.clear()
                view.tvPassword.text.clear()
                mensaje = "??Sin Actualizar!"
            }
            view.tvConfUpdate.text = mensaje
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditPacienteProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditPacienteProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}