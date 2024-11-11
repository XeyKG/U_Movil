package co.edu.unab.hernandezbuenobonilla.u_movil

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun RoleSelectionScreen(navController: NavController) {
    val context = LocalContext.current
    val db = FirebaseFirestore.getInstance()
    val user = FirebaseAuth.getInstance().currentUser

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EFFF)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "¿Qué eres?",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC5A3FF)
            )

            Button(
                onClick = {
                    if (user != null) {
                        // Verificar si el usuario ya tiene un vehículo registrado
                        db.collection("conductores")
                            .whereEqualTo("userID", user.uid)
                            .get()
                            .addOnSuccessListener { documents ->
                                if (documents.isEmpty) {
                                    // Si no existe un registro, navega a la pantalla de registro del vehículo
                                    navController.navigate("driverScreen")
                                } else {
                                    // Si ya existe un registro, navega a la pantalla de crear viaje
                                    navController.navigate("createTrip")
                                }
                            }
                            .addOnFailureListener {
                                Toast.makeText(context, "Error al verificar datos del conductor", Toast.LENGTH_SHORT).show()
                            }
                    } else {
                        Toast.makeText(context, "Usuario no autenticado", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE6DBFF))
            ) {
                Text("Conductor", fontSize = 20.sp, color = Color(0xFF8A60D8))
            }

            Button(
                onClick = {
                    // Navegar a la pantalla de pasajero o hacer otra acción para pasajero
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE6DBFF))
            ) {
                Text("Pasajero", fontSize = 20.sp, color = Color(0xFF8A60D8))
            }
        }
    }
}
