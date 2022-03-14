package app.calculator.running

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import app.calculator.running.ui.theme.RunningCalculatorTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RunningCalculatorTheme {
                val navController = rememberNavController()
                MainScreen(navController)
            }
        }
    }
}