package Dog.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Dog.DAO.DogDAO;
import Dog.Vo.DogVO;

public class DogControl {

	Scanner sc = new Scanner(System.in);
	DogDAO ddao = new DogDAO();

	public void run() {
		boolean isTrue = true;

		while (isTrue) {
			System.out.println("===============================================================");
			System.out.println("1.예약리스트 2.객실정보 3.예약하기 4.예약관리  5.이용안내 6.실시간매출  7.종료 ");
			System.out.println("===============================================================");
			System.out.println("선택 > ");

			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {

			case 1:
				dogList();
				break;
			case 2:
				roomList();
				break;

			case 3:
				addDog();
				break;
			case 4:
				fukDog();
				break;
			case 5:
				impo();
				break;

			case 6:
			    TotalPmoney();
			    break;
			case 7:
				System.out.println("모든 접수가 완료되었습니다.");
				isTrue = false;

			}
		}
	}// end of run().
		// 목록1 출력 기능.

	void dogList() {

		List<DogVO> dog = ddao.selectList();
		System.out.println("예약날짜   숙박기간   퇴실날짜    방이름      예약자       인원     반려견      옵션추가금액        작성날짜");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------");
		for (DogVO svo : dog) {
			System.out.println(svo.briefShow1());
		}

	}

	// 목록 2 출력 기능
	void roomList() {
		List<DogVO> dog = ddao.selectList2();
		System.out.println("객실이름    최대수용인원    반려견가능수      가격   ");
		System.out.println("----------------------------------------------------");
		for (DogVO svo : dog) {
			System.out.println(svo.briefShow2());
		}

	}

	// 예약하기 달력추가
	void addDog() {
		System.out.println("객실기본요금 : 가락 500,000원 / 몽순 400,000원 / 행배 300,000원 ");
		System.out.println("객실 입력");
		String Dog_roomname = sc.nextLine();

		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(cal.get(Calendar.MONTH) + 1 + "월");
		System.out.println("일 \t 월 \t 화 \t 수 \t 목 \t 금 \t 토");

		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

//		System.out.println(cal.get(Calendar.MONTH) + 1); // 월 구

		cal.set(Calendar.DATE, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		for (int i = 1; i < dayOfWeek; i++) {
			System.out.print("         ");
		}
		for (int i = 1; i <= lastDay; i++) {
			// i : 일자 데이터
			// 메소드(방이름, 일자)
			String chkDay = (cal.get(Calendar.MONTH) + 1) + "-" + i;// 7-1

			if (ddao.resCheck(Dog_roomname, chkDay) == 1) {
				System.out.printf("%02d(X)\t", i);
			} else {
				System.out.printf("%02d\t ", i);
			}
			if (dayOfWeek % 7 == 0) {
				System.out.println();
			}
			dayOfWeek++;
		}

		System.out.println();
		System.out.println(">예약자명 ");
		String Dog_user = sc.nextLine();

		System.out.println(">예약날짜 ex) 07-10");
		String Dog_choday = sc.nextLine();

		System.out.println(">이용기간 ex) 1박 > 1, 2박 > 2 최대2박");
		String Dog_useday = sc.nextLine();
//		System.out.println(">퇴실날짜 입력");
//		String Dog_outday = sc.nextLine();
		System.out.println(">인원 수 ");
		int Dog_mansu = Integer.parseInt(sc.nextLine());
		System.out.println(">반려견 수 ");
		int Dog_dogsu = Integer.parseInt(sc.nextLine());

		// 날짜 포맷 형식, 날짜 문자열, 추가할 일 수를 정의합니다.
		String dateFormatType = "MM-dd";
		// SimpleDateFormat 객체를 생성하고 포맷 형식을 설정합니다.
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatType);
		// 문자열을 Date 객체로 변환합니다.
		Date date = null;
		try {
			date = simpleDateFormat.parse(Dog_choday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Calendar 객체를 사용하기 위해 Calendar 인스턴스를 생성합니다.
		cal = Calendar.getInstance();
		// Date 객체를 Calendar 객체에 설정합니다.
		cal.setTime(date);
		// 원하는 일 수를 더합니다.
		cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(Dog_useday));
		// 결과 날짜를 포맷 형식에 맞게 변환합니다.
		String reDate = simpleDateFormat.format(cal.getTime());
		// 결과를 출력합니다.

		DogVO dog = new DogVO();
		dog.setDog_roomname(Dog_roomname);
		dog.setDog_user(Dog_user);

		dog.setDog_choday(Dog_choday);
		dog.setDog_useday(Dog_useday);
		dog.setDog_mansu(Dog_mansu);
		dog.setDog_dogsu(Dog_dogsu);

		// 각 방 유형에 따라 추가 요금 계산

		int additionalCharge = 0;

		switch (Dog_roomname) {
		case "가락":
			additionalCharge = 500000 * Dog_dogsu;
			break;
		case "몽순":
			additionalCharge = 400000* Dog_dogsu;
			break;
		case "행배":
			additionalCharge = 300000* Dog_dogsu;
			break;
		default:
			additionalCharge = 0; // 방 유형을 인식하지 못하는 경우의 기본 요금
			break;
		}

		dog.setDog_pmoney((Dog_dogsu * 20000) + additionalCharge); // 총 금액 계산

		if (ddao.insertDog(dog)) {
		    System.out.println("'" + Dog_user + "'" + "님 이름으로" + "'" + Dog_roomname + "'" + " 객실이 '" + Dog_choday
		            + "' 부터" + "' ~'" + reDate + "' 까지 예약이 완료되었습니다. 총 금액: " + dog.getDog_pmoney() + "원");

		    TotalPmoney(); // 예약 수정 후 총 예약 금액 출력
		}
	}

	public void impo() {
		boolean hi = true;

		while (hi) {
			System.out.println("----------------------------------------");
			System.out.println("1 오시는길 2 이용시간 3 입금계좌안내 4 뒤로가기");
			System.out.println("----------------------------------------");
			System.out.println("선택 > ");
			int choi = Integer.parseInt(sc.nextLine());

			switch (choi) {
			case 1:
				System.out.println("1 오시는길 ");
				System.out.println("-자차 이용시 카카오맵이나 티맵에서 팔공산 공영주차장 입력 후 네비따라 오시면됩니다.");
				System.out.println("-공영주차장에 주차 (주차요금 정상부과) 후 케이블카 탑승하셔서 꼭대기로 오시면 됩니다.");
				System.out.println("-택시탑승 시 기사님에게 \"팔공산 공영주차장 가주세요\" 하시면됩니다. ");
				break;

			case 2:
				System.out.println("2 이용시간 및 안내 ");
				System.out.println("- 성인을 동반하지 않은 미성년자는 예약 및 숙박이 불가합니다.");
				System.out.println("- 이용시간은 예약당일 15시 ~ 익일 11시까지이며 별도 시간추가는 불가능합니다.  ");
				System.out.println("- 예약 후 추가연박은 불가합니다. (예약손님이 있을 수 있으며, 청소업체를 이용하기때문에 연박불가)");
				System.out.println("22시 이후에는 잔디운동장 및 모든 시설이 소등이됩니다.");
				break;

			case 3:
				System.out.println("3 입금계좌안내 ");
				System.out.println("- 국민은행 61870104241940 예금주 : 이성철  ");
				System.out.println("- 예약 후 10분이내 미입금 시 예약이 취소됩니다. ");
				break;
			case 4:

				hi = false;
			}

		}
	}

	public void fukDog() {
		boolean go = true;
		while (go) {

			System.out.println("--------------------------------");
			System.out.println("1.예약수정   2.예약취소  3.뒤로가기    ");
			System.out.println("--------------------------------");
			System.out.println("선택 > ");
			;
			int gogo = Integer.parseInt(sc.nextLine());

			switch (gogo) {

			case 1:
				modDog();
				break;

			case 2:
				deldog();
				break;

			case 3:

				go = false;
			}
		}

	}

//수정기능
	void modDog() {
	    String Dog_user;
	    while (true) {
	        System.out.println(">변경할 예약자명을 입력하세요: ");
	        Dog_user = sc.nextLine();
	        if (ddao.selectExists(Dog_user) == 1) {
	            break;
	        }
	        System.out.println("입력하신 예약자명으로 예약된 정보가 없습니다. 다시 입력해주세요.");
	    }

	    System.out.println(">변경할 객실 이름을 입력하세요 (가락, 몽순, 행배): ");
	    String Dog_roomname = sc.nextLine();

	    // 캘린더 설정 및 날짜 출력
	    Calendar cal = Calendar.getInstance();
	    System.out.println((cal.get(Calendar.MONTH) + 1) + "월");
	    System.out.println("일 \t 월 \t 화 \t 수 \t 목 \t 금 \t 토");

	    int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	    cal.set(Calendar.DATE, 1);
	    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

	    for (int i = 1; i < dayOfWeek; i++) {
	        System.out.print("         ");
	    }
	    for (int i = 1; i <= lastDay; i++) {
	        String chkDay = (cal.get(Calendar.MONTH) + 1) + "-" + i;

	        if (ddao.resCheck(Dog_roomname, chkDay) == 1) {
	            System.out.printf("%02d(X)\t", i);
	        } else {
	            System.out.printf("%02d\t ", i);
	        }
	        if (dayOfWeek % 7 == 0) {
	            System.out.println();
	        }
	        dayOfWeek++;
	    }
	    System.out.println();

	    // 예약 날짜와 이용 기간 입력
	    System.out.println(">예약 날짜를 입력하세요 (ex. 07-10): ");
	    String Dog_choday = sc.nextLine();

	    System.out.println(">이용 기간을 입력하세요 (1박: 1, 2박: 2): ");
	    String Dog_useday = sc.nextLine();

	    // 인원 수 및 반려견 수 변경
	    System.out.println(">변경할 인원 수를 입력하세요: ");
	    int Dog_mansu = Integer.parseInt(sc.nextLine());

	    System.out.println(">변경할 반려견 수를 입력하세요: ");
	    int Dog_dogsu = Integer.parseInt(sc.nextLine());

	    // 예약자 재확인
	    System.out.println(">변경할 예약자명을 다시 입력하세요: ");
	    String dog_user = sc.nextLine();

	    // 날짜 포맷 형식 설정 및 변환
	    String dateFormatType = "MM-dd";
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatType);

	    Date date = null;
	    try {
	        date = simpleDateFormat.parse(Dog_choday);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    // 캘린더 설정 및 계산
	    Calendar cal1 = Calendar.getInstance();
	    cal1.setTime(date);
	    cal1.add(Calendar.DAY_OF_MONTH, Integer.parseInt(Dog_useday));

	    String reDate = simpleDateFormat.format(cal1.getTime());

	    // DogVO 객체 생성 및 값 설정
	    DogVO dog = new DogVO();
	    dog.setDog_roomname(Dog_roomname);
	    dog.setDog_user(dog_user);
	    dog.setDog_choday(Dog_choday);
	    dog.setDog_useday(Dog_useday);
	    dog.setDog_mansu(Dog_mansu);
	    dog.setDog_dogsu(Dog_dogsu);
	    

	    // 각 방 유형에 따른 추가 요금 계산
	    int additionalCharge = 0;
	    switch (Dog_roomname) {
	        case "가락":
	            additionalCharge = 500000 * Dog_dogsu;
	            break;
	        case "몽순":
	            additionalCharge = 400000 * Dog_dogsu;
	            break;
	        case "행배":
	            additionalCharge = 300000 * Dog_dogsu;
	            break;
	        default:
	            additionalCharge = 0;
	            break;
	    }
	    dog.setDog_pmoney((Dog_dogsu * 20000) + additionalCharge);

	    // 예약 수정 및 결과 출력
	    if (ddao.updateDog(dog)) {
	        System.out.println("'" + Dog_user + "' 님의 예약이 '" + Dog_roomname + "' 객실로 변경되었습니다. 예약 날짜: '" + Dog_choday
	                + "' 부터 ~ '" + reDate + "' 까지, 총 예약 금액: " + dog.getDog_pmoney() + "원");

	        TotalPmoney(); // 예약 수정 후 총 예약 금액 출력
	    }
	}
	void deldog() {

		System.out.println("삭제할 예약자 > ");
		String Dog_user = sc.nextLine();
		if (ddao.removeD(Dog_user)) {
			System.out.println("삭제완료!\n");
		} else {
			System.out.println("삭제 할 예약자가 없습니다!\n");

		}

	}

	public void TotalPmoney() {
		int TotalPmoney = ddao.calculateTotalPmoney();
		System.out.println("전체 예약 금액의 총 합: " + TotalPmoney + "원");
	}

}
