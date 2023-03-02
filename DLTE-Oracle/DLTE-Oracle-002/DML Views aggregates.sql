create table kyc(acc_number int not null,passcode varchar(255) not null,acc_holder varchar(255) not null,aadhaar int not null, pan varchar(255) not null, email varchar(255) not null, contact int not null, acc_bal int not null, address blob not null);

alter table kyc add constraint kyc_seq primary key(acc_number);
create sequence kyc_seq start with 91210001 increment by 1;

-- DDL
create view everything as select * from kyc;
create view major_detail as select acc_number, acc_bal, acc_holder from kyc;
create view secure as select passcode, acc_number from kyc;
create view documents as select aadhaar, pan, acc_number from kyc;
create type info as table of varchar(255);


-- update view
create or replace view major_detail as select acc_number,acc_bal,contact from kyc where acc_bal>=10000;

--Dropping views
drop view documents;

-- DQL: select

-- Aggregate
select cast(collect(acc_holder) as info) from everything;
-- wont work since type mismatch
select cast(collect(acc_number) as info) "Myinfo" from everything;

select cast(collect(acc_holder) as info) "Myinfo" from everything where acc_bal between 5000 and 20000;
select DISTINCT(passcode) from everything;
select avg(acc_bal) "Maintained" from everything;



select * from kyc;
select * from everything;
select * from major_detail;
select * from secure;
select * from documents;

select * from everything where acc_number=9121008;
select * from everything where utl_raw.cast_to_varchar2(address) = 'Karkala';
select * from everything order by utl_raw.cast_to_varchar2(address);
select * from everything order by utl_raw.cast_to_varchar2(address) desc;
select acc_holder,acc_bal from everything where passcode like '%123';

-- DML
update kyc set acc_bal=acc_bal-(acc_bal*0.020) where acc_bal<=10000;
update kyc set acc_bal=acc_bal+(acc_bal*0.060) where acc_bal>=10000;
-- changes would affect even through the view
update everything set passcode='razak@321' where acc_holder='Razak Mohamed';