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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun DriverScreen() {
    var selectedVehicleType by remember { mutableStateOf("") }
    var marca by remember { mutableStateOf(TextFieldValue("")) }
    var modelo by remember { mutableStateOf(TextFieldValue("")) }
    var color by remember { mutableStateOf(TextFieldValue("")) }
    var placa by remember { mutableStateOf(TextFieldValue("")) }

    val vehicleOptions = listOf("Carro", "Moto")
    val context = LocalContext.current

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
                text = "Registrar Vehículo",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFAA7F4D)
            )

            Text(
                text = "Maneja carro o moto",
                fontSize = 16.sp,
                color = Color(0xFFAA7F4D)
            )

            DropdownMenu(
                options = vehicleOptions,
                selectedOption = selectedVehicleType,
                onOptionSelected = { selectedVehicleType = it }
            )

            BasicTextFieldWithLabel("Marca", marca) { marca = it }
            BasicTextFieldWithLabel("Modelo", modelo) { modelo = it }
            BasicTextFieldWithLabel("Color", color) { color = it }
            BasicTextFieldWithLabel("Placa", placa) { placa = it }

            Button(
                onClick = { /* Acción de guardar */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAA7F4D))
            ) {
                Text(text = "GUARDAR", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun DropdownMenu(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFAF4E8))
            .clickable { expanded = !expanded }
            .padding(8.dp)
    ) {
        Text(
            text = if (selectedOption.isNotEmpty()) selectedOption else "Seleccione",
            color = Color(0xFFAA7F4D)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun BasicTextFieldWithLabel(
    label: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = Color(0xFFAA7F4D),
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAF4E8))
                .padding(8.dp),
            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = Color(0xFFAA7F4D)),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color(0xFFFAF4E8))
                        .padding(horizontal = 8.dp, vertical = 12.dp)
                ) {
                    if (value.text.isEmpty()) {
                        Text(text = label, color = Color(0xFFAA7F4D))
                    }
                    innerTextField()
                }
            }
        )
    }
}