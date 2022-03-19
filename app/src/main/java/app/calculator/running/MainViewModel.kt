package app.calculator.running

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val screen = mutableStateOf<ScreenType>(ScreenType.Run)

    fun navToScreen(nextScreen: ScreenType) {
        screen.value = nextScreen
    }

    var closeActivity: (() -> Unit)? = null
}