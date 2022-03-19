package app.calculator.running

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController: NavHostController, mainVM: MainViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val currentScreen by mainVM.screen
        BackHandler(enabled = true) {
            scope.launch {
                when (scaffoldState.snackbarHostState.showSnackbar(message = "Are you sure?", actionLabel = "Quit")) {
                    SnackbarResult.Dismissed -> {}
                    SnackbarResult.ActionPerformed -> mainVM.closeActivity?.let { it() }
                }
            }
        }
        Scaffold(
            scaffoldState = scaffoldState,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            topBar = {
                val screen by mainVM.screen
                TopAppBar(title = { Text(text = stringResource(id = screen.labelResId)) })
            },
            bottomBar = {
                BottomAppBar {
                    TabRow(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentWidth(),
                        selectedTabIndex = when (currentScreen) {
                            ScreenType.Run -> 0
                            ScreenType.History -> 1
                        }
                    ) {
                        Tab(selected = currentScreen == ScreenType.Run,
                            onClick = { mainVM.navToScreen(ScreenType.Run) }) {
                            Row {
                                Icon(painter = painterResource(id = ScreenType.Run.drawableResId), contentDescription = stringResource(ScreenType.Run.labelResId))
                                Text(text = stringResource(id = ScreenType.Run.labelResId))
                            }
                        }
                        Tab(selected = currentScreen == ScreenType.History,
                            onClick = { mainVM.navToScreen(ScreenType.History) }) {
                            Row {
                                Icon(painter = painterResource(id = ScreenType.History.drawableResId), contentDescription = stringResource(ScreenType.History.labelResId))
                                Text(text = stringResource(id = ScreenType.History.labelResId))
                            }
                        }
                    }
                }
            },
            content = { padding ->
                val runScrollState = rememberScrollState()
                val historyScrollState = rememberScrollState()

                NavHost(
                    navController = navController,
                    startDestination = currentScreen.id,
                    modifier = Modifier.padding(
                        bottom = padding.calculateBottomPadding(),
                        top = padding.calculateTopPadding(),
                        start = 4.dp,
                        end = 4.dp
                    )
                ) {
                    composable(currentScreen.id, content = { currentScreen.screen(runScrollState, mainVM) })
                }
            }
        )
    }
}
