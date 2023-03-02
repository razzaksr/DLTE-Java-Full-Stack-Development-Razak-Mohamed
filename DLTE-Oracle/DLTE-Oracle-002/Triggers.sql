create table log_details(chnaged date, message varchar(255));
create or replace trigger transactions
after update on kyc
for each row
when(new.acc_number > 0)
declare
available int;
begin
    available := :new.acc_bal - :old.acc_bal;
    insert into log_details values(sysdate,'old balance: '||:old.acc_bal);
    insert into log_details values(sysdate,'new balance: '||:new.acc_bal);
    insert into log_details values(sysdate,'difference  '||available);
end;

-- DDL:
TRUNCATE table log_details;

-- DML
update everything set acc_bal=acc_bal+1000 where acc_holder='Razak Mohamed';
update kyc set acc_bal=acc_bal-3000 where acc_number=91210005;

