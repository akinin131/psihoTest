package quiz.example.psychologytests.activityTest.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.io.Serializable;
import java.util.Objects;

@Entity(indices = {
        @Index(value = {"first_name", "last_name"},unique = true)
}
)
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name",index = true)
    public int firstName;

    @ColumnInfo(name = "last_name",index = true)
    public int lastName;

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid && firstName.equals(user.firstName) && lastName.equals(user.lastName);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(uid, firstName, lastName);
    }

}
