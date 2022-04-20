package app.calculator.running.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.calculator.running.db.data.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM Workout")
    fun getAllWorkoutFlow(): Flow<List<Workout>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Workout)

    @Query("Delete from Workout")
    fun deleteAll()
}