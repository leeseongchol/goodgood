CREATE table A_Doglist(
    Dog_choday VARCHAR2(100) PRIMARY KEY, --예약날짜
    Dog_useday VARCHAR2(100) not null, --사용일
    Dog_outday VARCHAR2(100), --퇴실날짜
    Dog_roomname VARCHAR2(100), --방이름
    Dog_user VARCHAR2(100), --예약자
    Dog_mansu VARCHAR2(100), --인원수
    Dog_dogsu number(100), --반려견수
    Dog_pmoney number(100), -- 추가금액
    creation_date date DEFAULT sysdate, -- 작성날짜
    );
    
    select sysdate, 'mm-dd')
    from dual;
    
    select Dog_choday,
       TO_CHAR(TO_DATE(Dog_choday, 'mm-dd') +2 , 'mm-dd')
    from A_Doglist;
       
       
    select *
    from A_Doglist ; 
       
    --입력 
insert into A_Doglist (Dog_choday, Dog_useday, Dog_user)
values('07-10', '1', '아아아하하하');

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-25', '2', '07-27', '행배', '하랑하율엄마', '2', '2', '40,000원' );

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-28', '2', '07-30', '몽순', '감치아주머니', '1', '1', '20,000원');

update A_Doglist
set Dog_pmoney = '60,000원'
where Dog_choday = '07-10';

commit;

CREATE table B_Room(
    Room_name VARCHAR2(100) PRIMARY KEY, --방이름
    Room_maxman VARCHAR2(100) not null, --최대인원
    Room_maxdog VARCHAR2(100), --최대 반려견
    Room_price VARCHAR2(100), --가격
    );

select *
    from B_Room;


insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price)
values('가락','4명','6마리','500,000원');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price)
values('몽순','2명','2마리','400,000원');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price)
values('행배','2명','2마리','300,000');

update B_Room
set Room_price = '300,000원'
where Room_name = '행배';

commit;