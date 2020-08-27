SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN FROM MEMBER;

INSERT INTO MEMBER VALUES('박규영','parkgy','1234','pgy@gmail.com','010-1111-2222',1);

UPDATE MEMBER SET name = '박규영', pwd='5678', email='mcw@naver.com', phone='010-5656-5656', admin=0 WHERE userID='light';

SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN FROM MEMBER WHERE userid='somi';

DELETE FROM MEMBER WHERE USERID = 'pipi';

