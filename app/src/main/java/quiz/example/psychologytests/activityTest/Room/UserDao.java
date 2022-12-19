package quiz.example.psychologytests.activityTest.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert(entity = User.class, onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User... users);

    @Delete
    void delete(User user);
}