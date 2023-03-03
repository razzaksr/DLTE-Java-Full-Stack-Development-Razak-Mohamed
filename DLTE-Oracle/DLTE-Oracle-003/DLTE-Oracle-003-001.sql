select * from transaction where amount in (2000,800);

select * from transaction where amount=2000 or amount=800;

-- DCL:

select * from all_users;
create user abhishek identified by tietoevry;
connect abhishek/tietoevry;

grant create session to abhishek;
connect abhishek/tietoevry;

insert into kyc values(kyc_seq.nextval,'abhi@123','Abhishek',987656787667,'ABCDDD1234R','abhishek@gmail.com',8765676564,900.5,utl_raw.cast_to_raw('Kerala'))
grant select on kyc to abhishek;
update kyc set passcode='evry@123' where acc_holder='Abhishek';


-- via sqlplus

sqlplus

SQL*Plus: Release 11.2.0.2.0 Production on Fri Mar 3 14:15:16 2023

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

Enter user-name: system
Enter password:

Connected to:
Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production

SQL> create user hameed identified by shahul;

select * from all_users;

alter session set current_schema=system;

select * from kyc;

SQL> grant connect to hameed;

SQL> grant select on kyc to hameed;

exit

log through hameed

alter session set current_schema=system;

select * from kyc;

update,delete,insert will fail since hameed privilege to do select alone

Enter user-name: system
Enter password:

Connected to:
Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production

SQL> alter session set current_schema=system;

Session altered.

SQL> revoke select on kyc from hameed;

Revoke succeeded.

SQL>connect system/admin;

SQL>drop user hameed;
