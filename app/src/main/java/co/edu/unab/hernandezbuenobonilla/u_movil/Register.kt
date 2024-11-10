package co.edu.unab.hernandezbuenobonilla.u_movil

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var userID by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = "REGISTRO",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE0A458),
                modifier = Modifier
                    .background(Color(0xFF2C2C2C))
                    .padding(horizontal = 32.dp, vertical = 8.dp)
            )

            BasicTextFieldWithLabel("Correo", email) { email = it }
            BasicTextFieldWithLabel("ID", userID) { userID = it }
            BasicTextFieldWithLabel("Número telefónico", phoneNumber) { phoneNumber = it }
            BasicTextFieldWithLabel("Nombre Completo", name) { name = it }
            BasicTextFieldWithLabel("Contraseña", password, PasswordVisualTransformation()) { password = it }
            BasicTextFieldWithLabel("Repetir contraseña", confirmPassword, PasswordVisualTransformation()) { confirmPassword = it }

            Button(
                onClick = {
                    if (password.text == confirmPassword.text) {
                        registerUser(
                            email.text,
                            password.text,
                            userID.text,
                            phoneNumber.text,
                            name.text,
                            auth,
                            db,
                            context,
                            navController
                        )
                    } else {
                        Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0A458))
            ) {
                Text(text = "REGISTRARSE", fontSize = 16.sp, color = Color.Black)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "¿Ya tienes cuenta? ",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Inicia Sesión",
                    fontSize = 14.sp,
                    color = Color(0xFF77A6D2),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { navController.navigate("login") }
                )
            }
        }
    }
}

@Composable
fun BasicTextFieldWithLabel(
    label: String,
    value: TextFieldValue,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (TextFieldValue) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = Color(0xFFE0A458),
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2C2C2C))
                .padding(8.dp),
            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = Color.White),
            visualTransformation = visualTransformation,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color(0xFF2C2C2C))
                        .padding(horizontal = 8.dp, vertical = 12.dp)
                ) {
                    if (value.text.isEmpty()) {
                        Text(text = label, color = Color.Gray)
                    }
                    innerTextField()
                }
            }
        )
    }
}

fun registerUser(
    email: String,
    password: String,
    userID: String,
    phoneNumber: String,
    name: String,
    auth: FirebaseAuth,
    db: FirebaseFirestore,
    context: android.content.Context,
    navController: NavController
) {
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val userId = auth.currentUser?.uid ?: ""
                val user = hashMapOf(
                    "email" to email,
                    "userID" to userID,
                    "phoneNumber" to phoneNumber,
                    "Name" to name
                )
                db.collection("users").document(userId).set(user)
                    .addOnSuccessListener {
                        Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                        navController.navigate("login")
                    }
                    .addOnFailureListener {
                        Toast.makeText(context, "Error al guardar datos", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(context, "Error en el registro", Toast.LENGTH_SHORT).show()
            }
        }
}

