package app.calculator.running.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.calculator.running.vm.MainViewModel

@Composable
fun HistoryScreen(scrollState: ScrollState, mainVM: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(scrollState)
    ) {
        val list by mainVM.list.collectAsState(initial = emptyList())
        Text(text = "Count = ${list.size}")
        for (item in list) {
            Text(text = "History Screen - ${item.id}")
        }
    }
}