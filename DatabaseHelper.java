import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RE:me.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ANSWER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("some sql statement to do something");
    }

    private static final String CREATE_TABLE_ANSWER = "create table answer"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "question" + " text not null, "
            + "answer" + " text not null, "
            + "modified_time" + " integer not null, "
            + "created_time" + " integer not null, "
            + "foreign key(question) references QUESTION(question) " + ")";

    private static final  String CREATE_TABLE_QUESTION = "create table question"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "category" + " text not null, "
            + "specific_category" + " text, "
            + "question" + " text " + ")";


}