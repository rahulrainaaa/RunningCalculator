package app.calculator.running.global

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import app.calculator.running.R

/**
 * Class retaining screen type(s) that are required here in Compose UI routing to show various screen(s) within this application.
 */
sealed class ScreenType(
    val id: String,
    @DrawableRes val drawableResId: Int,
    @StringRes val labelResId: Int
) {
    object Run : ScreenType(
        id = "run",
        drawableResId = R.drawable.ic_run,
        labelResId = R.string.run
    )

    object History : ScreenType(
        id = "history",
        drawableResId = R.drawable.ic_history,
        labelResId = R.string.history
    )
}