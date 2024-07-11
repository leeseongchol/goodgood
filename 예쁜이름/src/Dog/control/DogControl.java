package Dog.control;

import java.text.SimpleDateFormat;
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
			System.out.println("============================================================");
			System.out.println("1. 예약 리스트 2. 객실정보 3. 예약하기 4. 예약관리  5. 이용안내  6. 종료 ");
			System.out.println("============================================================");
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
				System.out.println("예약해주신 모든분께 진심으로 감사를 드립니다.");
				isTrue = false;

			}
		}
	}// end of run().
		// 목록1 출력 기능.

	void dogList() {
		List<DogVO> dog = ddao.selectList();
		System.out.println("예약날짜  사용일   퇴실날짜    방이름        예약자        인원        반려견          옵션추가금액            작성날짜");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------");
		for (DogVO svo : dog) {
			System.out.println(svo.briefShow1());
		}

	}

	// 목록 2 출력 기능
	void roomList() {
		List<DogVO> dog = ddao.selectList2();
		System.out.println("객실이름    최대수용인원    반려견가능수      가격     풀장이용가능여부");
		System.out.println("---------------------------------------------------------");
		for (DogVO svo : dog) {
			System.out.println(svo.briefShow2());
		}

	}

	// 예약하기 달력추가
	void addDog() {
		System.out.println("객실이름 입력");
		String Res_roomname = sc.nextLine();

		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(cal.get(Calendar.MONTH) + 1+"월");
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
			String chkDay = (cal.get(Calendar.MONTH) + 1) + "-" + i;//7-1
			
			if (ddao.resCheck(Res_roomname, chkDay) == 1) {
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
		String Res_name = sc.nextLine();
		System.out.println(">비밀번호 입력.");
		String Res_password = sc.nextLine();

		System.out.println(">이용날짜 입력. ex) 08-10");
		String Res_choday = sc.nextLine();

		System.out.println(">이용기간 입력. ex) 1박, 2박");
		String Res_useday = sc.nextLine();
		System.out.println(">인원수 입력.");
		String Res_mansu = sc.nextLine();
		System.out.println(">반려견 수");
		String Res_dogsu = sc.nextLine();

		DogVO dog = new DogVO();
		dog.setRes_roomname(Res_roomname);
		dog.setRes_name(Res_name);
		dog.setRes_password(Res_password);
		dog.setRes_choday(Res_choday);
		dog.setRes_useday(Res_useday);
		dog.setRes_mansu(Res_mansu);
		dog.setRes_dogsu(Res_dogsu);

		// 입력기능 호출
		if (ddao.insertDog(dog)) {
			System.out.println(
					Res_name + "님 이름으로" + Res_roomname + "객실이 " + Res_choday + "부터" + Res_useday + "동안 예약이 완료되었습니다.");
		} else {
			System.out.println("저리충 예외발생!");
		}
	}
}
