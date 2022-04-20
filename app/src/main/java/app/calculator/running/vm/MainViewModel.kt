package app.calculator.running.vm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.calculator.running.core.LocationLiveData
import app.calculator.running.db.dao.WorkoutDao
import app.calculator.running.db.data.Workout
import app.calculator.running.global.ScreenType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dao: WorkoutDao
) : ViewModel() {

    val screen = mutableStateOf<ScreenType>(ScreenType.Run)

    fun navToScreen(nextScreen: ScreenType) {
        screen.value = nextScreen
    }

    @Inject
    lateinit var locationLiveData: LocationLiveData

    var closeActivity: (() -> Unit)? = null

    val list = dao.getAllWorkoutFlow()

    fun testing() {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteAll()
            while (true) {
                dao.insert(Workout())
                Thread.sleep(1000)
            }
        }
    }

}