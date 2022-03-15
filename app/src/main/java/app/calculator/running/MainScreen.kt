package app.calculator.running

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.calculator.running.ui.theme.RunningCalculatorTheme

@Composable
fun MainScreen(navController: NavHostController, mainVM: MainViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()
        val currentScreen by mainVM.screen
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
            content = {
                NavHost(navController = navController, startDestination = currentScreen.id) {
                    composable(currentScreen.id, content = { currentScreen.screen() })
                }
            }
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() = RunningCalculatorTheme { MainScreen(navController = Any() as NavHostController, mainVM = Any() as MainViewModel) }