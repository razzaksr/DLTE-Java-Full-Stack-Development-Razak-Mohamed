Day 16:
create table dlte_initial(username varchar(255) not null, upi varchar(255) not null, bank varchar(255) not null, gmail varchar(255) not null, wallet varchar(255) not null, done date not null, amount int not null);

1st NF:
	No column should have multi value
	Each row should be identified by any unique column/ attribute
	update dlte_first_normal set upi='gaurava1@oksbi', gmail='gaurav1@gmail.com' where username='gaurav';

2nd NF:
	Every records has to be connect/ match with atleast one composite key(integration of more than one column as pair)
	No partial dependent should be there
create table dlte_second_normal_composite as select user_id, upi from dlte_first_normal;
alter table dlte_second_normal_composite add FOREIGN key(user_id) references dlte_second_normal_user(user_id);
alter table dlte_second_normal_composite add FOREIGN key(upi) references dlte_second_normal_transaction(upi);
create table dlte_second_normal_user as select user_id, username, gmail, bank from dlte_first_normal;
create table dlte_second_normal_transaction as select upi, wallet, done, amount from dlte_first_normal;
alter table dlte_second_normal_transaction add primary key(upi);

3rd NF:
	Non key attribute should not depend with another non key attribute
	create table dlte_third_normal_history(done date not null, amount int not null);
alter table DLTE_THIRD_NORMAL_HISTORY add primary key(done);
create table dlte_third_normal_transaction as select upi, wallet from dlte_second_normal_transaction;
alter table dlte_third_normal_transaction add primary key(upi);

4th NF:
	No multi valued
	Composite depended not allowed

create table dlte_fourth_normal(user_id int not null, username varchar(255) not null, bank varchar(255) not null);
create table dlte_fourth_normal_email(user_id int not null, gmail varchar(255) not null);
create table dlte_fourth_normal_composite(user_id int not null, upi varchar(255) not null);
alter table dlte_fourth_normal_composite add FOREIGN key(user_id) references dlte_fourth_normal(user_id);
alter table dlte_fourth_normal_email add FOREIGN key(user_id) references dlte_fourth_normal(user_id);
alter table dlte_fourth_normal_composite add FOREIGN key(upi) references dlte_third_normal_transaction(upi);
