package com.example.leanne.mobilecwk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Locale;
/**
 * Created by leanne on 10/12/2015.
 */
public class LeagueTableInfoDBMgr extends SQLiteOpenHelper {

    private static final int DB_VER = 1;
    private static final String DB_PATH = "/data/data/com.example.leanne.mobilecwk.app/databases";
    private static final String DB_NAME = "FootballFanatic.s3db";
    private static final String TBL_LEAGUEINFO = "leaguetableinfo";

    public static final String COL_POSITION = "Position";
    public static final String COL_TEAMNAME = "TeamName";
    public static final String COL_POINTS = "Points";
    public static final String COL_MATCHESPLAYED = "MatchesPlayed";
    public static final String COL_MATCHESWON = "MatchesWon";
    public static final String COL_MATCHESDRAWN = "MatchesDrawn";
    public static final String COL_MATCHESLOST = "MatchesLost";

    private final Context appContext;

    public LeagueTableInfoDBMgr(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.appContext = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_LEAGUE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TBL_LEAGUEINFO + "("
                + COL_POSITION + " TEXT," + COL_TEAMNAME
                + " TEXT," + COL_POINTS + " TEXT," + COL_MATCHESPLAYED + " TEXT,"
                + COL_MATCHESWON + " TEXT" + COL_MATCHESDRAWN + "TEXT" + COL_MATCHESLOST + ")";
        db.execSQL(CREATE_LEAGUE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TBL_LEAGUEINFO);
            onCreate(db);
        }
    }

    // ================================================================================
    // Creates a empty database on the system and rewrites it with your own database.
    // ================================================================================
    public void dbCreate() throws IOException {

        boolean dbExist = dbCheck();

        if (!dbExist) {
            //By calling this method an empty database will be created into the default system path
            //of your application so we can overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDBFromAssets();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    // ============================================================================================
    // Check if the database already exist to avoid re-copying the file each time you open the application.
    // @return true if it exists, false if it doesn't
    // ============================================================================================
    private boolean dbCheck() {

        SQLiteDatabase db = null;

        try {
            String dbPath = DB_PATH + DB_NAME;
            db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY);
            db.setLocale(Locale.getDefault());
            db.setVersion(1);

        } catch (SQLiteException e) {

            Log.e("SQLHelper", "Database not Found!");

        }

        if (db != null) {

            db.close();

        }

        return db != null ? true : false;
    }

    // ============================================================================================
    // Copies your database from your local assets-folder to the just created empty database in the
    // system folder, from where it can be accessed and handled.
    // This is done by transfering bytestream.
    // ============================================================================================
    private void copyDBFromAssets() throws IOException {

        InputStream dbInput = null;
        OutputStream dbOutput = null;
        String dbFileName = DB_PATH + DB_NAME;

        try {

            dbInput = appContext.getAssets().open(DB_NAME);
            dbOutput = new FileOutputStream(dbFileName);
            //transfer bytes from the dbInput to the dbOutput
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dbInput.read(buffer)) > 0) {
                dbOutput.write(buffer, 0, length);
            }

            //Close the streams
            dbOutput.flush();
            dbOutput.close();
            dbInput.close();
        } catch (IOException e) {
            throw new Error("Problems copying DB!");
        }
    }


    public void addLeagueTableInfo(LeagueInfo aLeagueTableInfo) {

        ContentValues values = new ContentValues();
        values.put(COL_POSITION, aLeagueTableInfo.getPosition());
        values.put(COL_TEAMNAME, aLeagueTableInfo.getTeamName());
        values.put(COL_POINTS, aLeagueTableInfo.getPoints());
        values.put(COL_MATCHESPLAYED, aLeagueTableInfo.getMatchesPlayed());
        values.put(COL_MATCHESWON, aLeagueTableInfo.getMatchesWon());
        values.put(COL_MATCHESDRAWN, aLeagueTableInfo.getMatchesDrawn());
        values.put(COL_MATCHESLOST, aLeagueTableInfo.getMatchesLost());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TBL_LEAGUEINFO, null, values);
        db.close();
    }

    public LeagueInfo findLeagueTable(String sLeagueInfo) {
        String query = "SELECT * FROM " + TBL_LEAGUEINFO + "/";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        LeagueInfo TeamInfo = new LeagueInfo();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            TeamInfo.setPosition(cursor.getString(0));
            TeamInfo.setTeamName(cursor.getString(1));
            TeamInfo.setPoints(cursor.getString(2));
            TeamInfo.setMatchesPlayed(cursor.getString(3));
            TeamInfo.setMatchesWon(cursor.getString(4));
            TeamInfo.setMatchesDrawn(cursor.getString(5));
            TeamInfo.setMatchesLost(cursor.getString(6));
            cursor.close();
        } else {
            TeamInfo = null;
        }
        db.close();
        return TeamInfo;


    }


}