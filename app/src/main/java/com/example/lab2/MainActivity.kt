package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var edt_Nombre:EditText
    private lateinit var edt_edad:EditText
    private lateinit var edt_Departamento:EditText
    private lateinit var tv_Resultado:TextView
    private lateinit var lv_lista:ListView
    val Nombre = arrayListOf<String>()
    val Edad = arrayListOf<String>()
    val Departamento = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_Nombre=findViewById(R.id.edt_Nombre)
        edt_Departamento=findViewById(R.id.edt_Departamento)
        edt_edad=findViewById(R.id.edt_edad)
        tv_Resultado=findViewById(R.id.tv_resultado)
        lv_lista=findViewById(R.id.lv_lista)
    }




    fun AgregarLisra(v:View){
        if(!edt_Nombre.text.toString().isEmpty() && !edt_edad.text.toString().isEmpty() && !edt_Departamento.text.toString().isEmpty()) {
            Nombre.add(edt_Nombre.text.toString())
            Edad.add(edt_edad.text.toString())
            Departamento.add(edt_Departamento.text.toString())
            edt_Nombre.setText("")
            edt_edad.setText("")
            edt_Departamento.setText("")
            var adaptador: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.lista, Nombre)
            lv_lista?.adapter = adaptador

            lv_lista?.onItemClickListener=object : AdapterView.OnItemClickListener{
                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    tv_Resultado.setText("Los datos de ${Nombre.get(p2)} la edad s ${Edad.get(p2)} Y vive el el departamento de ${Departamento.get(p2)}")
                }

            }
        }else{
            Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }


}