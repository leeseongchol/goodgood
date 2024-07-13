package Dog.Vo;

import java.util.Date;

public class DogVO {

	// dogList 1번 목록
	private String Dog_choday;
	private String Dog_useday;
	private String Dog_outday;
	private String Dog_roomname;
	private String Dog_user;
	private String Dog_mansu;
	private int Dog_dogsu;
	private int Dog_pmoney;
	private Date creation_date;
	private String Dog_password;
	// room 2번 객실정보
	private String Room_name;
	private String Room_maxman;
	private String Room_maxdog;
	private String Room_price;
	

	public String briefShow1() {
		return Dog_choday + " \t  "  + Dog_useday + "박     " + Dog_outday + " \t     " + Dog_roomname + "\t" + Dog_user + "\t "
				+ Dog_mansu + "명\t " + Dog_dogsu + "마리 \t   " + Dog_pmoney + "원\t   " + creation_date;
	}

	public String briefShow2() {
		return Room_name + "  \t   " + Room_maxman + "\t\t " + Room_maxdog + " \t  " + Room_price ;
	}

	public String getDog_choday() {
		return Dog_choday;
	}

	public void setDog_choday(String dog_choday) {
		Dog_choday = dog_choday;
	}

	public String getDog_useday() {
		return Dog_useday;
	}

	public void setDog_useday(String dog_useday) {
		Dog_useday = dog_useday;
	}

	public String getDog_outday() {
		return Dog_outday;
	}

	public void setDog_outday(String dog_outday) {
		Dog_outday = dog_outday;
	}

	public String getDog_roomname() {
		return Dog_roomname;
	}

	public void setDog_roomname(String dog_roomname) {
		Dog_roomname = dog_roomname;
	}

	public String getDog_user() {
		return Dog_user;
	}

	public void setDog_user(String dog_user) {
		Dog_user = dog_user;
	}

	public String getDog_mansu() {
		return Dog_mansu;
	}

	public void setDog_mansu(String dog_mansu) {
		Dog_mansu = dog_mansu;
	}

	public int getDog_dogsu() {
		return Dog_dogsu;
	}

	public void setDog_dogsu(int dog_dogsu) {
		Dog_dogsu = dog_dogsu;
	}

	public int getDog_pmoney() {
		return Dog_pmoney;
	}

	public void setDog_pmoney(int dog_pmoney) {
		Dog_pmoney = dog_pmoney;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getRoom_name() {
		return Room_name;
	}

	public void setRoom_name(String room_name) {
		Room_name = room_name;
	}

	public String getRoom_maxman() {
		return Room_maxman;
	}

	public void setRoom_maxman(String room_maxman) {
		Room_maxman = room_maxman;
	}

	public String getRoom_maxdog() {
		return Room_maxdog;
	}

	public void setRoom_maxdog(String room_maxdog) {
		Room_maxdog = room_maxdog;
	}

	public String getRoom_price() {
		return Room_price;
	}

	public void setRoom_price(String room_price) {
		Room_price = room_price;
	}





	public String getDog_password() {
		return Dog_password;
	}

	public void setDog_password(String res_password) {
		Dog_password = res_password;
	}



}
