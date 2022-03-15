package app.calculator.running

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.calculator.running.ui.theme.RunningCalculatorTheme

@Composable
fun HistoryScreen() {
    Text(text = "History Screen")
}

@Preview
@Composable
fun HistoryScreenPreview() {
    RunningCalculatorTheme {
        HistoryScreen()
    }
}