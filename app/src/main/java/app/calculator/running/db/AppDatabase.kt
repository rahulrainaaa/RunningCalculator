package app.calculator.running.db

import androidx.room.Database
import androidx.room.RoomDatabase
import app.calculator.running.db.dao.WorkoutDao
import app.calculator.running.db.data.Workout

@Database(entities = [Workout::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
}