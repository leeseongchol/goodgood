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
	private String Dog_dogsu;
	private String Dog_pmoney;
	private Date creation_date;
	// room 2번 객실정보
	private String Room_name;
	private String Room_maxman;
	private String Room_maxdog;
	private String Room_price;
	private String Room_option;
	// reservation 3-1.예약 하기
	
	private String Res_roomname;
	private String Res_name;
	private String Res_password;
	private String Res_mansu;
	private String Res_choday;
	private String Res_useday;
	private String Res_dogsu;




	public String briefShow1() {
		return Dog_choday + "\t" + Dog_useday + "     " + Dog_outday + "\t " + Dog_roomname + " \t  " + Dog_user + "\t "
				+ Dog_mansu + "    " + Dog_dogsu + "\t   " + Dog_pmoney + "  \t   " + creation_date;
	}

	public String briefShow2() {
		return Room_name + "  \t   " + Room_maxman + "\t\t " + Room_maxdog + " \t  " + Room_price + "\t " + Room_option;
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

	public String getDog_dogsu() {
		return Dog_dogsu;
	}

	public void setDog_dogsu(String dog_dogsu) {
		Dog_dogsu = dog_dogsu;
	}

	public String getDog_pmoney() {
		return Dog_pmoney;
	}

	public void setDog_pmoney(String dog_pmoney) {
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

	public String getRoom_option() {
		return Room_option;
	}

	public void setRoom_option(String room_option) {
		Room_option = room_option;
	}

	

	public String getRes_roomname() {
		return Res_roomname;
	}

	public void setRes_roomname(String res_roomname) {
		Res_roomname = res_roomname;
	}

	public String getRes_name() {
		return Res_name;
	}

	public void setRes_name(String res_name) {
		Res_name = res_name;
	}

	public String getRes_password() {
		return Res_password;
	}

	public void setRes_password(String res_password) {
		Res_password = res_password;
	}

	public String getRes_mansu() {
		return Res_mansu;
	}

	public void setRes_mansu(String res_mansu) {
		Res_mansu = res_mansu;
	}

	public String getRes_choday() {
		return Res_choday;
	}

	public void setRes_choday(String res_choday) {
		Res_choday = res_choday;
	}

	public String getRes_useday() {
		return Res_useday;
	}

	public void setRes_useday(String res_useday) {
		Res_useday = res_useday;
	}
	public String getRes_dogsu() {
		return Res_dogsu;
	}

	public void setRes_dogsu(String res_dogsu) {
		Res_dogsu = res_dogsu;
	}





}
