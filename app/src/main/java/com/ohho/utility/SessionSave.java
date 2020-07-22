package com.ohho.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 *This common class to store the require data by using SharedPreferences.
 */
public class SessionSave
{
	public static void saveSession(String key, String value, Context context)
	{
		Editor editor = context.getSharedPreferences("KEY", Activity.MODE_PRIVATE).edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static String getSession(String key, Context context)
	{
		SharedPreferences prefs = context.getSharedPreferences("KEY", Activity.MODE_PRIVATE);
		return prefs.getString(key, "");
	}

	public static void clearSession(Context context)
	{
		Editor editor = context.getSharedPreferences("KEY", Activity.MODE_PRIVATE).edit();
		editor.clear();
		editor.commit();
	}

	public static void setDistance(Float distance, Context con)
	{
		Editor editor=con.getSharedPreferences("DIS", Context.MODE_PRIVATE).edit();
		editor.putFloat("DISTANCE", distance);
		editor.commit();
	}

	public static float getDistance(Context con)
	{
		SharedPreferences sharedPreferences=con.getSharedPreferences("DIS", Context.MODE_PRIVATE);
		return sharedPreferences.getFloat("DISTANCE", 0);

	}

	public static void setWaitingTime(Long time, Context con)
	{
		Editor editor=con.getSharedPreferences("long", Context.MODE_PRIVATE).edit();
		editor.putLong("LONG", time);
		editor.commit();
	}

	public static long getWaitingTime(Context con)
	{
		SharedPreferences sharedPreferences=con.getSharedPreferences("long", Context.MODE_PRIVATE);
		return sharedPreferences.getLong("LONG", 0);

	}


	public static void setFreeWaitingTime(Long time, Context con)
	{
		Editor editor=con.getSharedPreferences("long", Context.MODE_PRIVATE).edit();
		editor.putLong("LONG", time);
		editor.commit();
	}

	public static long getFreeWaitingTime(Context con)
	{
		SharedPreferences sharedPreferences=con.getSharedPreferences("long", Context.MODE_PRIVATE);
		return sharedPreferences.getLong("LONG", 0);

	}

	public static void setWaiting_trip_Time(Long time, Context con)
	{
		Editor editor=con.getSharedPreferences("long", Context.MODE_PRIVATE).edit();
		editor.putLong("LONG_trip", time);
		editor.commit();
	}

	public static long getWaiting_trip_Time(Context con)
	{
		SharedPreferences sharedPreferences=con.getSharedPreferences("long", Context.MODE_PRIVATE);
		return sharedPreferences.getLong("LONG_trip", 0);
	}

	public static void setWaiting_street_Time(Long time, Context con)
	{
		Editor editor=con.getSharedPreferences("long", Context.MODE_PRIVATE).edit();
		editor.putLong("LONG_street", time);
		editor.commit();
	}

	public static long getWaiting_street_Time(Context con)
	{
		SharedPreferences sharedPreferences=con.getSharedPreferences("long", Context.MODE_PRIVATE);
		return sharedPreferences.getLong("LONG_street", 0);
	}
}
