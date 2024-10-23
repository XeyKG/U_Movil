package co.edu.unab.hernandezbuenobonilla.u_movil

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.unab.hernandezbuenobonilla.u_movil.ui.theme.U_MovilTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@Composable
fun Login(){
    U_MovilTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column (
                modifier = Modifier.padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center){
                Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = "Bienvenido a U_Movil")
                }
                Card {
                    Column (modifier = Modifier.padding(16.dp)){
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "ID")
                            },
                            modifier = Modifier.fillMaxWidth(),
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "Contraseña")
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(top = 102.dp,
                            bottom =32.dp)
                    ){
                        Text(text = "Iniciar Sesión")
                    }
                }
                Column (modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = "¿No tienes cuenta?")
                    OutlinedButton(
                        onClick = {/*TODO*/},
                        modifier = Modifier.fillMaxWidth())
                    {
                        Text(text = "Regístrate")
                    }
                }
            }
        }
    }
}