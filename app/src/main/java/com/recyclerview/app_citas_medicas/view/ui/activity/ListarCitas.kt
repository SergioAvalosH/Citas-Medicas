package com.recyclerview.app_citas_medicas.view.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.toObject
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.adapter.CitaAdapter

class ListarCitas : AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var citaArrayList: ArrayList<Cita>
    private lateinit var myAdapter: CitaAdapter
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_citas)

        recyclerView=findViewById(R.id.recyclerViewCitas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        citaArrayList= arrayListOf()

        myAdapter= CitaAdapter(citaArrayList)

        EventChangeListener()


    }

    private fun EventChangeListener() {

        db= FirebaseFirestore.getInstance()
        db.collection("cita").
                addSnapshotListener(object : EventListener<QuerySnapshot>{
                    override fun onEvent(
                        value:QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {
                        if (error  !=null){

                            Log.e("Firestore Error",error.message.toString())
                        }

                        for (dc:DocumentChange in value?.documentChanges!!){

                            if (dc.type==DocumentChange.Type.ADDED){

                                citaArrayList.add(dc.document.toObject(Cita::class.java))
                            }
                        }

                        myAdapter.notifyDataSetChanged()
                    }
                })

    }

}