package gabriel.contreras.validacionesyspinner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1 Mandar a llamar a todos los elementos
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val txtDUI = findViewById<EditText>(R.id.txtDui)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //2 Agregar un evento al botón
        btnAgregar.setOnClickListener {
            //Validemos que los campos no estén vacios

            if (txtEdad.text.isEmpty()
                || txtCorreo.text.isEmpty()
                || txtNombre.text.isEmpty()
                || txtContrasena.text.isEmpty()
                || txtDUI.text.isEmpty()
            ) {
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_LONG).show()
            }
            //Validamos solo números
            else if (txtEdad.text.matches("[0-9]+".toRegex())) {
                Toast.makeText(this, "Campos agregados", Toast.LENGTH_LONG).show()
            }
            //Validar que correo lleve arroba
            else {
                Toast.makeText(this, "Verifique los campos", Toast.LENGTH_LONG).show()
            }
        }

        if (txtCorreo.text.matches("[a-zA-z0-9._-]+@[a-z]+\\\\.+[a-z]+]".toRegex())) {
            Toast.makeText(this, "Correo real", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Correo no real", Toast.LENGTH_LONG).show()
        }

        //Validar la contraseña para que tenga más de 6 digitos
        if (txtContrasena.text.length <= 6){
            Toast.makeText(this, "Debe tener más de 6 dígitos", Toast.LENGTH_LONG).show()
        }

        //validar el DUI
        if (txtDUI.text.matches("[0-9]+-[0-9]".toRegex()) && txtDUI.text.length <=10)
        {

        }else {}

        if(txtNombre.text.matches("[a-zA-z]=".toRegex())){}
    }
}
