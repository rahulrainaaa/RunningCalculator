package app.calculator.running

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(@ApplicationContext context: Context) : ViewModel() {

    val screen = mutableStateOf<ScreenType>(ScreenType.Run)

    fun navToScreen(nextScreen: ScreenType) {
        screen.value = nextScreen
    }

    var closeActivity: (() -> Unit)? = null

    val locationLiveData by lazy { LocationLiveData(context) }
}