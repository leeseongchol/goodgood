CREATE table A_Doglist(
    Dog_choday VARCHAR2(100) PRIMARY KEY, --���೯¥
    Dog_useday VARCHAR2(100) not null, --�����
    Dog_outday VARCHAR2(100), --��ǳ�¥
    Dog_roomname VARCHAR2(100), --���̸�
    Dog_user VARCHAR2(100), --������
    Dog_mansu VARCHAR2(100), --�ο���
    Dog_dogsu VARCHAR2(100), --�ݷ��߼�
    Dog_pmoney VARCHAR2(100), -- �߰��ݾ�
    creation_date date DEFAULT sysdate -- �ۼ���¥
    );
       
    select *
    from A_Doglist ; 
       
    --�Է� 
insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-10', '1��', '07-11', '����', '�ɱݻ����ǥ�̻�', '����2��', '�ݷ���5����', '100000��' );

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-25', '2��', '07-27', '���', '�϶���������', '����2��', '�ݷ���2����', '40000��' );

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-28', '2��', '07-30', '����', '��ġ���ָӴ�', '����1��', '�ݷ���1����', '20000��');

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('07-01', '2��', '07-01', '����', 'JKJKJKJK', '����1��', '�ݷ���1����', '20000��');

update A_Doglist
set Dog_pmoney = '60000��'
where Dog_choday = '07-10';

commit;

CREATE table B_Room(
    Room_name VARCHAR2(100) PRIMARY KEY, --���̸�
    Room_maxman VARCHAR2(100) not null, --�ִ��ο�
    Room_maxdog VARCHAR2(100), --�ִ� �ݷ���
    Room_price VARCHAR2(100), --����
    Room_option VARCHAR2(100) --Ǯ��ɼ�   
    );

select *
    from B_Room;


insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price, Room_option)
values('����','4��','6����','500,000��','����');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price, Room_option)
values('����','2��','2����','400,000��','����');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price, Room_option)
values('���','2��','2����','300,000','�Ұ���');

update B_Room
set Room_price = '300,000��'
where Room_name = '���';

commit;

CREATE table C_Reservation(
  
    Res_roomname VARCHAR2(100) not null, --������ �� �̸�
    Res_name VARCHAR2(100), --������ ��
    Res_password VARCHAR2(100), --������ ��й�ȣ   
    Res_choday VARCHAR2(100), -- �̿볯¥  
    Res_useday VARCHAR2(100), -- �̿�Ⱓ  
    Res_mansu VARCHAR2(100), --�ο�����
    Res_dogsu VARCHAR2(100) --�ݷ��߼�
    );
    

    
    
    select *
    from C_Reservation;
    
 


    
commit;
    