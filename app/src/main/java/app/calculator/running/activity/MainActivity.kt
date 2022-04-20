package app.calculator.running.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import app.calculator.running.screen.MainScreen
import app.calculator.running.theme.RunningCalculatorTheme
import app.calculator.running.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.closeActivity = { finish() }
        mainViewModel.testing()
        setContent {
            RunningCalculatorTheme {
                val navController = rememberNavController()
                MainScreen(navController = navController, mainVM = mainViewModel)
            }
        }
    }
}