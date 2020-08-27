-- 계정 추가 및 권한 부여
CREATE USER jsp_study IDENTIFIED BY rootroot;

GRANT CONNECT, resource, CREATE synonym, CREATE VIEW TO jsp_study;

--확인

SELECT * FROM dba_users WHERE username = 'jsp_study';
