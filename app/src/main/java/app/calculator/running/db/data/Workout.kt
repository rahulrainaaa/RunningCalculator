package app.calculator.running.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workout(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String? = "",
    var caption: String? = "",
    var type: String? = "",
    var datetime: String? = ""
)