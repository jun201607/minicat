package com.mcxiaoke.fanfouapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mcxiaoke.fanfouapp.dao.model.DirectMessageColumns;
import com.mcxiaoke.fanfouapp.dao.model.RecordColumns;
import com.mcxiaoke.fanfouapp.dao.model.StatusColumns;
import com.mcxiaoke.fanfouapp.dao.model.UserColumns;


/**
 * @author mcxiaoke
 * @version 1.0 2012.02.16
 * 
 */
public class SQLiteHelper extends SQLiteOpenHelper {
	public static final String TAG = "SQLiteHelper";

	public static final String DATABASE_NAME = "data.db";
	public static final int DATABASE_VERSION = 2;

	/**
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(StatusColumns.CREATE_TABLE);
		db.execSQL(UserColumns.CREATE_TABLE);
		db.execSQL(DirectMessageColumns.CREATE_TABLE);
		db.execSQL(RecordColumns.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + StatusColumns.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + UserColumns.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + DirectMessageColumns.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + RecordColumns.TABLE_NAME);
		onCreate(db);

	}

}