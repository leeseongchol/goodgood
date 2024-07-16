CREATE table A_Doglist(
    Dog_choday VARCHAR2(100) PRIMARY KEY, --���೯¥
    Dog_useday VARCHAR2(100) not null, --�����
    Dog_outday VARCHAR2(100), --��ǳ�¥
    Dog_roomname VARCHAR2(100), --���̸�
    Dog_user VARCHAR2(100), --������
    Dog_mansu VARCHAR2(100), --�ο���
    Dog_dogsu number(100), --�ݷ��߼�
    Dog_pmoney number(100), -- �߰��ݾ�
    creation_date date DEFAULT sysdate, -- �ۼ���¥
    );
    
    select sysdate, 'mm-dd')
    from dual;
    
    select Dog_choday,
       TO_CHAR(TO_DATE(Dog_choday, 'mm-dd') +2 , 'mm-dd')
    from A_Doglist;
       
       
    select *
    from A_Doglist ; 
       
    --�Է� 
insert into A_Doglist (Dog_choday, Dog_useday, Dog_user)
values('07-10', '1', '�ƾƾ�������');

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-25', '2', '07-27', '���', '�϶���������', '2', '2', '40,000��' );

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-28', '2', '07-30', '����', '��ġ���ָӴ�', '1', '1', '20,000��');

update A_Doglist
set Dog_pmoney = '60,000��'
where Dog_choday = '07-10';

commit;

CREATE table B_Room(
    Room_name VARCHAR2(100) PRIMARY KEY, --���̸�
    Room_maxman VARCHAR2(100) not null, --�ִ��ο�
    Room_maxdog VARCHAR2(100), --�ִ� �ݷ���
    Room_price VARCHAR2(100), --����
    );

select *
    from B_Room;


insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price)
values('����','4��','6����','500,000��');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price)
values('����','2��','2����','400,000��');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price)
values('���','2��','2����','300,000');

update B_Room
set Room_price = '300,000��'
where Room_name = '���';

commit;