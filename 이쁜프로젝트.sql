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
    from A_Doglist
    where TO_DATE('07-11', 'mm-dd') between TO_DATE (Dog_choday, 'mm-dd') AND TO_DATE(Dog_outday, 'mm-dd')
    and Dog_roomname = '����'
    ; 
    
    
    
    alter table A_Doglist add Dog_mansu VARCHAR2(100);
    
    
    
    --�Է� 
insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('08-10', '1��', '08-11', '����', '�ɱݻ����ǥ�̻�', '����2��', '�ݷ���5����', '100000��' );

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('08-25', '2��', '08-27', '���', '�϶���������', '����2��', '�ݷ���2����', '40000��' );

insert into A_Doglist (Dog_choday, Dog_useday, Dog_outday, Dog_roomname, Dog_user, Dog_mansu, Dog_dogsu, Dog_pmoney)
values('08-28', '2��', '08-30', '����', '��ġ���ָӴ�', '����1��', '�ݷ���1����', '20000��');

update A_Doglist
set Dog_outday = '07-30'
where Dog_choday = '07-28';

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
values('������','4��','6����','500000��','����');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price, Room_option)
values('������','2��','2����','400000��','����');
insert into B_Room(Room_name, Room_maxman, Room_maxdog, Room_price, Room_option)
values('���','2��','2����','300000','�Ұ���');

update B_Room
set Room_price = '500,000��'
where Room_name = '������';

commit;

CREATE table C_Reservation(
    Res_number VARCHAR2(100) PRIMARY KEY, --�����ȣ
    Res_roomname VARCHAR2(100) not null, --������ �� �̸�
    Res_name VARCHAR2(100), --������ ��
    Res_password VARCHAR2(100), --������ ��й�ȣ   
    Res_choday VARCHAR2(100), -- �̿볯¥  
    Res_useday VARCHAR2(100) -- �̿�Ⱓ  
    );
    
    alter table C_Reservation add Res_mansu VARCHAR2(100); --�ο�����
     alter table C_Reservation add Res_dogsu VARCHAR2(100);
    
    
    select *
    from C_Reservation;
    
 


    
commit;
    