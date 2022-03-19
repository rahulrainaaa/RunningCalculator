package app.calculator.running

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.Composable

/**
 * Defining alias for Composable method.
 */
typealias ComposableFun = @Composable (scrollState: ScrollState) -> Unit

/**
 * Class retaining screen type(s) that are required here in Compose UI routing to show various screen(s) within this application.
 */
sealed class ScreenType(
    val id: String,
    @DrawableRes val drawableResId: Int,
    @StringRes val labelResId: Int,
    val screen: ComposableFun
) {
    object Run : ScreenType("run",
        R.drawable.ic_run,
        R.string.run,
        { RunScreen(it) })

    object History : ScreenType("history",
        R.drawable.ic_history,
        R.string.history,
        { HistoryScreen(it) })
}