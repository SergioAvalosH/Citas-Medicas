package com.recyclerview.app_citas_medicas.view.ui.activity

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.activity_crear_cita.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register_pacient.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CrearCitaActivity : AppCompatActivity() {

    val db = Firebase.firestore
    var datalista=ArrayList<String>()
    var cadena2=ArrayList<String>()
    var namelista=ArrayList<String>()
    var horalista=ArrayList<String>()
    var medico = ""
    val posit = 1
    private lateinit var tvFecha: TextView
    private lateinit var btnFecha: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cita)

        val dni: String? = intent.getStringExtra("dni")
        tvDPaciente.text=dni

        db.collection("especialidad").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    var cadena=" ${document.getString("Nombre")}"
                    datalista.add(cadena)

                }
                val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datalista)
                EspSpinner.adapter = adapter
            }

        tvFecha=findViewById(R.id.tvFecha)
        btnFecha=findViewById(R.id.btnFecha)

        val Calendario= Calendar.getInstance()

        val datePicker= DatePickerDialog.OnDateSetListener{view,year,month,dayofMonth ->
            Calendario.set(Calendar.YEAR,year)
            Calendario.set(Calendar.MONTH,month)
            Calendario.set(Calendar.DAY_OF_MONTH,dayofMonth)
            updateLable(Calendario)
        }

        btnFecha.setOnClickListener{
            DatePickerDialog(this, datePicker,Calendario.get(Calendar.YEAR),Calendario.get(Calendar.MONTH),
            Calendario.get(Calendar.DAY_OF_MONTH)).show()
        }

        db.collection("atencionhora")
            .addSnapshotListener{querySnapshot,error->
                if(error!=null){
                    mensaje(error.message!!)
                    return@addSnapshotListener
                }
                for(document in querySnapshot!!){
                    var horacadena=" ${document.getString("Hora")}"
                    horalista.add(horacadena)


                }
                var adap=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,horalista)
                SpinnerHora.adapter=adap
            }


        bntGuardarCita.setOnClickListener {

            db.collection("citas").document(tvDPaciente.text.toString()).set(
                hashMapOf(
                    "DNI" to tvDPaciente.text.toString(),
                    "Especialidad" to EspSpinner.selectedItem.toString(),
                    "Fecha" to tvFecha.text,
                    "Hora" to  SpinnerHora.selectedItem.toString()
                )
            )
        }






}

    private fun updateLable(Calendario: Calendar) {

        val myformat= "dd-MM-yyyy"
        val sdf=SimpleDateFormat(myformat,Locale.UK)
        tvFecha.setText(sdf.format(Calendario.time))
    }

    private fun mensaje(s: String) {
        AlertDialog.Builder(this).setTitle("Atencion")
            .setMessage(s)
            .setPositiveButton("OK"){d,i->}
            .show()
    }

    fun getEspecialidad(): ArrayList<String> {
        return datalista
    }


    // Para el toolbar Crear Citas Medicas
        //val actionBar = supportActionBar
        //actionBar!!.title = "Crear Cita"
        //actionBar.setDisplayHomeAsUpEnabled(true)


        // Mensaje para cuando se cree la cita
        //bntGuardarCita.setOnClickListener{
        //    Toast.makeText(this, "Todavia No se implementa, gay!", Toast.LENGTH_SHORT).show()
        //}

}