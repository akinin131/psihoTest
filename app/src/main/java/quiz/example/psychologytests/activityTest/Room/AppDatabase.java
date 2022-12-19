package quiz.example.psychologytests.activityTest.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version = 9)
public abstract class AppDatabase extends RoomDatabase {

   /* public static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(final SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Employee ADD COLUMN birthday INTEGER DEFAULT 0 NOT NULL");
        }
    };*/

    public abstract UserDao userDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DB_NAME")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}