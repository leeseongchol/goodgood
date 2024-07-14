CREATE table A_Doglist(
    Dog_choday VARCHAR2(100) PRIMARY KEY, --예약날짜
    Dog_useday VARCHAR2(100) not null, --사용일
    Dog_outday VARCHAR2(100), --퇴실날짜
    Dog_roomname VARCHAR2(100), --방이름
    Dog_user VARCHAR2(100), --예약자
    Dog_mansu VARCHAR2(100), --인원수
    Dog_dogsu VARCHAR2(100), --반려견수
    Dog_pmoney VARCHAR2(100), -- 추가금액
    creation_date date DEFAULT sysdate -- 작성날짜
    );
       
    select *
    from A_Doglist ; 
       
    --입력 
insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-10', '1박', '07-11', '가락', '능금사과대표이사', '성인2명', '반려견5마리', '100000원' );

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-25', '2박', '07-27', '행배', '하랑하율엄마', '성인2명', '반려견2마리', '40000원' );

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-28', '2박', '07-30', '몽순', '감치아주머니', '성인1명', '반려견1마리', '20000원');

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-01', '2박', '07-01', '몽순', 'JKJKJKJK', '성인1명', '반려견1마리', '20000원');

update A_Doglist
set Dog_pmoney = '60000원'
where Dog_choday = '07-10';

commit;

CREATE table B_Room(
    Room_name VARCHAR2(100) PRIMARY KEY, --방이름
    Room_maxman VARCHAR2(100) not null, --최대인원
    Room_maxdog VARCHAR2(100), --최대 반려견
    Room_price VARCHAR2(100), --가격
    Room_option VARCHAR2(100) --풀장옵션   
    );

select *
    from B_Room;


insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price, Room_option)
values('가락','4명','6마리','500,000원','가능');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price, Room_option)
values('몽순','2명','2마리','400,000원','가능');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price, Room_option)
values('행배','2명','2마리','300,000','불가능');

update B_Room
set Room_price = '300,000원'
where Room_name = '행배';

commit;

CREATE table C_Reservation(
  
    Res_roomname VARCHAR2(100) not null, --예약할 방 이름
    Res_name VARCHAR2(100), --예약자 명
    Res_password VARCHAR2(100), --예약자 비밀번호   
    Res_choday VARCHAR2(100), -- 이용날짜  
    Res_useday VARCHAR2(100), -- 이용기간  
    Res_mansu VARCHAR2(100), --인원예약
    Res_dogsu VARCHAR2(100) --반려견수
    );
    

    
    
    select *
    from C_Reservation;
    
 


    
commit;
    