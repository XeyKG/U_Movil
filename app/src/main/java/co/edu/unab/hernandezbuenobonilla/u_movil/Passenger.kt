package co.edu.unab.hernandezbuenobonilla.u_movil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PassengerScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC5A3FF)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Bienvenido, Pasajero", fontSize = 24.sp, color = Color.White)
    }
}