-- DDL
create table bankers(bankers_id int not null, name varchar(255) not null, passcode varchar(255) not null, age int not null, address blob not null);

alter table bankers drop column bankers_id;

alter table bankers modify(age date);

alter table bankers add bankers_id int not null;

alter table bankers add constraint bank_seq PRIMARY key(bankers_id);

create sequence bank_seq start with 1101 increment by 1;

describe bankers;

-- DML

insert into bankers(bankers_id, name, passcode, age, address) values(bank_seq.NEXTVAL,'razzaksr','Razak@123','26-01-1992',utl_raw.cast_to_raw('Salem, Tmailnadu, India'));

update bankers set passcode='dlithe@123', address=utl_raw.cast_to_raw('Moodbidri') where name='sridhar';

select utl_raw.cast_to_varchar2(address) from bankers;

-- TCL: commit, rollback

update bankers set passcode='dlithe@123', address=utl_raw.cast_to_raw('Moodbidri') where name='sridhar';
rollback;
