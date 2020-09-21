package com.kedaiit.ggp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.kedaiit.ggp.model.login.LoginData;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String INDEKS = "indeks";
    public static final String HP = "hp";
    public static final String EMAIL = "email";
    public static final String TANGGAL_DAFTAR = "tanggal_daftar";
    public static final String FOTO = "foto";
    public static final String ID_STATUS = "status";
    public static final String ID_SESI = "id_sesi";
    public static final String LASTLOGIN = "lastlogin";
    public static final String HOST = "host";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(INDEKS, user.getIndeks());
        editor.putString(HP, user.getHp());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(TANGGAL_DAFTAR, user.getTanggalDaftar());
        editor.putString(FOTO, user.getFoto());
        editor.putString(ID_STATUS, user.getStatus());
        editor.putString(ID_SESI, user.getIdSesi());
        editor.putString(LASTLOGIN, user.getLastlogin());
        editor.putString(HOST, user.getHost());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(INDEKS, sharedPreferences.getString(INDEKS,null));
        user.put(HP, sharedPreferences.getString(HP,null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL,null));
        user.put(TANGGAL_DAFTAR, sharedPreferences.getString(TANGGAL_DAFTAR, null));
        user.put(FOTO, sharedPreferences.getString(FOTO, null));
        user.put(ID_STATUS, sharedPreferences.getString(ID_STATUS, null));
        user.put(ID_SESI, sharedPreferences.getString(ID_SESI, null));
        user.put(LASTLOGIN, sharedPreferences.getString(LASTLOGIN, null));
        user.put(HOST, sharedPreferences.getString(HOST, null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}
