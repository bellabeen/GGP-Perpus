package com.kedaiit.ggp.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("foto")
	private String foto;

	@SerializedName("lastlogin")
	private String lastlogin;

	@SerializedName("indeks")
	private String indeks;

	@SerializedName("hp")
	private String hp;

	@SerializedName("host")
	private String host;

	@SerializedName("kata_sandi")
	private String kataSandi;

	@SerializedName("tanggal_daftar")
	private String tanggalDaftar;

	@SerializedName("email")
	private String email;

	@SerializedName("status")
	private String status;

	@SerializedName("id_sesi")
	private String idSesi;

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setLastlogin(String lastlogin){
		this.lastlogin = lastlogin;
	}

	public String getLastlogin(){
		return lastlogin;
	}

	public void setIndeks(String indeks){
		this.indeks = indeks;
	}

	public String getIndeks(){
		return indeks;
	}

	public void setHp(String hp){
		this.hp = hp;
	}

	public String getHp(){
		return hp;
	}

	public void setHost(String host){
		this.host = host;
	}

	public String getHost(){
		return host;
	}

	public void setKataSandi(String kataSandi){
		this.kataSandi = kataSandi;
	}

	public String getKataSandi(){
		return kataSandi;
	}

	public void setTanggalDaftar(String tanggalDaftar){
		this.tanggalDaftar = tanggalDaftar;
	}

	public String getTanggalDaftar(){
		return tanggalDaftar;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setIdSesi(String idSesi){
		this.idSesi = idSesi;
	}

	public String getIdSesi(){
		return idSesi;
	}
}