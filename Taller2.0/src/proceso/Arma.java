package proceso;


public class Arma {
	private String gun_name;
	private String gun_code;
	private int ammo;
	private String gun_country;
	private int gun_mats;
	
	public Arma (String gun_name,String gun_code,int ammo,String gun_country,int gun_mats) {
		this.gun_name = gun_name;
		this.gun_code = gun_code;
		this.ammo = ammo;
		this.gun_country = gun_country;
		this.gun_mats = gun_mats;
		
	}
	@Override
	public String toString() {
		return "Arma [gun_name=" + gun_name + ", gun_code=" + gun_code + ", ammo=" + ammo + ", gun_country="
				+ gun_country + ", gun_mats=" + gun_mats + "]";
	}
	public String getGun_name() {
		return gun_name;
	}
	public void setGun_name(String gun_name) {
		this.gun_name = gun_name;
	}
	public String getGun_code() {
		return gun_code;
	}
	public void setGun_code(String gun_code) {
		this.gun_code = gun_code;
	}
	public int getAmmo() {
		return ammo;
	}
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	public String getGun_country() {
		return gun_country;
	}
	public void setGun_country(String gun_country) {
		this.gun_country = gun_country;
	}
	public int getGun_mats() {
		return gun_mats;
	}
	public void setGun_mats(int gun_mats) {
		this.gun_mats = gun_mats;
	}

}
