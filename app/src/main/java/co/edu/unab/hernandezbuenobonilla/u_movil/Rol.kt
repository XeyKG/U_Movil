package co.edu.unab.hernandezbuenobonilla.u_movil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RoleSelectionScreen(navController: NavController) {
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
                onClick = { navController.navigate("driverScreen") },
                modifier = Modifier
                    .width(200.dp)
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE6DBFF))
            ) {
                Text("Conductor", fontSize = 20.sp, color = Color(0xFF8A60D8))
            }

            Button(
                onClick = { navController.navigate("passengerScreen") },
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
