package app.calculator.running.di

import android.content.Context
import androidx.room.Room
import app.calculator.running.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Qualifier
//@Retention(AnnotationRetention.BINARY)
//annotation class DB1
//
//@Qualifier
//@Retention(AnnotationRetention.BINARY)
//annotation class DB2

@Module
@InstallIn(SingletonComponent::class)
object DependencyProvider {

//    @DB1
//    @Provides
//    fun provideDB1(@ApplicationContext context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "db2").build()
//
//
//    @DB2
//    @Provides
//    fun provideDB2(@ApplicationContext context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "db1").build()
//

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "my_database_1").build()

    @Singleton
    @Provides
    fun provideWorkoutDao(db: AppDatabase) = db.workoutDao()
}