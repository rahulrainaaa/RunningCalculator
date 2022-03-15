package app.calculator.running

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.calculator.running.ui.theme.RunningCalculatorTheme

@Composable
fun RunScreen() {
    Text(text = "Run Screen")
}

@Preview
@Composable
fun RunScreenPreview() {
    RunningCalculatorTheme {
        RunScreen()
    }
}