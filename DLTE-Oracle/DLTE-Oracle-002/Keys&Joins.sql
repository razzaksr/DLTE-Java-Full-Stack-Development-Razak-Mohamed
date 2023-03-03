create table debit(card_number int not null, card_cvv int not null, card_expiry date not null, account int not null );

alter table debit add primary key(card_number);

alter table debit add FOREIGN key(account) REFERENCES kyc(acc_number);

describe debit;

-- joins:
-- right:
select acc_number, acc_holder, card_number,card_expiry from debit outer right join kyc on account=acc_number;
-- left
select acc_number, acc_holder, card_number,card_expiry from debit outer left join kyc on account=acc_number;


-- subqueries:
9876567834
23456745644
67876567345

create table transactions(transaction_id int not null,transaction_from int not null,transaction_to int not null,amount int not null,happened date not null);

alter table transactions add foreign key(transaction_from) references debit(card_number);

alter table transactions add constraint trans_seq primary key(transaction_id);
create sequence trans_seq start with 101 increment by 1;


select acc_holder,acc_number,card_number,happened,amount from (
(kyc inner join debit on account=acc_number) 
inner join transactions on transaction_from=card_number)

select acc_holder,acc_number,card_number,happened,amount from (
(kyc inner join debit on account=acc_number) 
inner join transactions on transaction_to=card_number)

select acc_holder,acc_number,card_number,happened,amount, transaction_from, transaction_to from (
(kyc inner join debit on account=acc_number) 
inner join transactions on transaction_to=card_number)


-- DDL
drop table transactions;
drop sequence trans_seq;
drop table debit;
alter table kyc rename to accounts;
drop view everything;
drop view secure;
drop table accounts;
drop table bankers;
drop database dlte;