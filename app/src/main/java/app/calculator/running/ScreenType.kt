package app.calculator.running

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class ScreenType(val id: String, @DrawableRes val drawableResId: Int, @StringRes val labelResId: Int, val screen: ComposableFun) {
    object Run : ScreenType("run", R.drawable.ic_run, R.string.run, { RunScreen() })
    object History : ScreenType("history", R.drawable.ic_history, R.string.history, { HistoryScreen() })
}