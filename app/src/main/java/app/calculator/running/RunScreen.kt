package app.calculator.running

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import java.text.SimpleDateFormat

@Composable
fun RunScreen(state: ScrollState, mainVM: MainViewModel) {
    val location by mainVM.locationLiveData.observeAsState()
    val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        location?.run {
            Text(text = "latitude = ${latitude}")
            Text(text = "longitude = ${longitude}")
            Text(text = "altitude = ${altitude}")
            Text(text = "speed = ${speed}")
            Text(text = "bearing = ${bearing}")
            Text(text = "elapsedRealtimeNanos = ${formatter.format(elapsedRealtimeNanos)}")
            Text(text = "provider = ${provider}")
            Text(text = "time = ${formatter.format(time)}")
        }
    }
}