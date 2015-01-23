package ues.dbmeterandroid.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import ues.dbmeterandroid.LoginActivity;

/**
 * Created by Admin on 22/01/2015.
 */
public class SessionManager {


    SharedPreferences _sharedPref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE =0;
    private static final String PREF_NAME ="DbmeterPref";

    private static final String KEY_USERNAME ="username";
    private static final String KEY_PASSWD = "passwd";

    public SessionManager(Context context)
    {
        this._context = context;
        _sharedPref = _context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = _sharedPref.edit();
    }

    public void savePasswordAndUser (String _passwd, String _user)
    {
        editor.putString(KEY_USERNAME,_user);
        editor.putString(KEY_PASSWD,_passwd);
        editor.commit();
    }

    public HashMap<String,String> getUserSessionInfo(){
        HashMap<String,String> user = new HashMap<>();
        user.put(KEY_USERNAME, _sharedPref.getString(KEY_USERNAME,null));
        user.put(KEY_PASSWD, _sharedPref.getString(KEY_PASSWD,null));

        return user;
    }

    public void logOutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

}
