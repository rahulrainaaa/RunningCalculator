package app.calculator.running

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import app.calculator.running.ui.theme.RunningCalculatorTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RunningCalculatorTheme {
                val navController = rememberNavController()
                MainScreen(navController = navController, mainVM = mainViewModel)
            }
        }
    }
}