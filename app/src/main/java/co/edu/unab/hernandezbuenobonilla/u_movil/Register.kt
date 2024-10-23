package co.edu.unab.hernandezbuenobonilla.u_movil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.unab.hernandezbuenobonilla.u_movil.ui.theme.U_MovilTheme

@Composable
@Preview
fun RegisterScreen(){
    U_MovilTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column (
                modifier = Modifier.padding(innerPadding).padding(16.dp).fillMaxSize(),
                verticalArrangement = Arrangement.Center){
                Text(text = "REGISTRO")
                Card {
                    Column (modifier = Modifier.padding(16.dp).fillMaxWidth()){
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "Correo")},
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "ID")},
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "Número telefóno")},
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "Contraseña")},
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = " Repetir contraseña")},
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "Nombre")},
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "Apellido")},
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(top = 16.dp))
                    {
                        Text(text = "Registrarse")
                    }
                }
                Column (modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = "¿Ya tienes cuenta?")
                    OutlinedButton(
                        onClick = {
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Inicia sesión")
                    }
                }
            }
        }
    }
}