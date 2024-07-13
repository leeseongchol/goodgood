package Dog.control;

import java.util.Calendar;
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
			System.out.println("1.예약 리스트 2.객실정보 3.예약하기 4.예약관리  5.이용안내  6.종료 ");
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

				break;
			case 5:
				impo();
				break;

			case 6:

				System.out.println("예약해주신 모든분께 진심으로 감사를 드립니다.");
				isTrue = false;

			}
		}
	}// end of run().
		// 목록1 출력 기능.

	void dogList() {

		List<DogVO> dog = ddao.selectList();
		System.out.println("예약날짜   사용일    퇴실날짜    방이름         예약자          인원    반려견      옵션추가금액        작성날짜");
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
		System.out.println("객실이름 입력");
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
		System.out.println(">예약자명 입력.");
		String Dog_user = sc.nextLine();
		System.out.println(">비밀번호 입력.");
		String Dog_password = sc.nextLine();

		System.out.println(">이용날짜 입력. ex) 08-10");
		String Dog_choday = sc.nextLine();

		System.out.println(">이용기간 입력. ex) 1박, 2박");
		String Dog_useday = sc.nextLine();
		System.out.println(">퇴실날짜 입력");
		String Dog_outday = sc.nextLine();
		System.out.println(">인원수 입력.");
		String Dog_mansu = sc.nextLine();
		System.out.println(">반려견 수 (최대 3마리) ");
		int Dog_dogsu = sc.nextInt();

		DogVO dog = new DogVO();
		dog.setDog_roomname(Dog_roomname);
		dog.setDog_user(Dog_user);
		dog.setDog_password(Dog_password);
		dog.setDog_choday(Dog_choday);
		dog.setDog_useday(Dog_useday);
		dog.setDog_mansu(Dog_mansu);
		dog.setDog_dogsu(Dog_dogsu);
		dog.setDog_outday(Dog_outday);
		dog.setDog_pmoney(Dog_dogsu * 20000);

		// 입력기능 호출
		if (ddao.insertDog(dog)) {
			System.out.println("'" + Dog_user + "'" + "님 이름으로" + "'" + Dog_roomname + "'" + " 객실이 " + Dog_choday + "부터"
					+ "'" + Dog_useday + "'" + Dog_outday + " 까지 예약이 완료되었습니다.");
		} else {
			System.out.println("실패다 이새끼야");
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
}
