package co.edu.unab.hernandezbuenobonilla.u_movil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainNavController = rememberNavController()
            NavHost(
                navController = mainNavController,
                startDestination = "login"
            ) {
                composable("login") {
                    LoginScreen(mainNavController)
                }
                composable("register") {
                    RegisterScreen(mainNavController)
                }
            }
        }
    }
}
