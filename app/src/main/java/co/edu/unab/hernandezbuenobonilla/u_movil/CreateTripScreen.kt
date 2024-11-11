package co.edu.unab.hernandezbuenobonilla.u_movil

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun CreateTripScreen(navController: NavController) {
    var lugarSalida by remember { mutableStateOf(TextFieldValue("")) }
    var destino by remember { mutableStateOf(TextFieldValue("")) }
    var horaSalida by remember { mutableStateOf(TextFieldValue("")) }
    var cupos by remember { mutableStateOf(TextFieldValue("")) }
    var precio by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = "Volver",
                fontSize = 16.sp,
                color = Color(0xFFAA7F4D),
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { navController.popBackStack() }
            )

            Text(
                text = "Crear viaje",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            BasicTextFieldWithLabel("Lugar de salida", lugarSalida) { lugarSalida = it }
            BasicTextFieldWithLabel("Destino", destino) { destino = it }
            BasicTextFieldWithLabel("Hora de salida", horaSalida) { horaSalida = it }
            BasicTextFieldWithLabel("Cupos", cupos) { cupos = it }
            BasicTextFieldWithLabel("Precio por persona", precio) { precio = it }

            Button(
                onClick = {
                    // Acción para crear el viaje
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD7C4F2))
            ) {
                Text(text = "Crear", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}
