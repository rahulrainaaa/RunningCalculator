package app.calculator.running

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainScreen(navController: NavHostController, mainVM: MainViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            topBar = {
                val screen by mainVM.screen
                TopAppBar(title = {
                    Text(text = stringResource(id = screen.labelResId))
                })
            },
            bottomBar = {
                BottomAppBar {
                    Button(onClick = { mainVM.navToScreen(ScreenType.Run) }) {
                        Text(text = stringResource(id = ScreenType.Run.labelResId))
                    }
                    Button(onClick = { mainVM.navToScreen(ScreenType.History) }) {
                        Text(text = stringResource(id = ScreenType.History.labelResId))
                    }
                }
            },
            content = {
                NavHost(navController = navController, startDestination = ScreenType.Run.id) {
                    composable(ScreenType.Run.id, content = { ScreenType.Run.screen })
                    composable(ScreenType.History.id, content = { ScreenType.History.screen })
                }
            }
        )
    }
}
