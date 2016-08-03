select * from ordering.usersinfo;

insert into ordering.orders (order_id, user_id, merchandise_id, num) values (001, 001, 001, 2);
insert into ordering.orders (user_id, merchandise_id, num) values (001, 002, 1);
insert into ordering.orders (user_id, merchandise_id, num) values (001, 003, 5);
insert into ordering.orders (user_id, merchandise_id, num) values (002, 002, 2);
insert into ordering.orders (user_id, merchandise_id, num) values (002, 004, 1);

select * from ordering.orders;

insert into ordering.merchandise (merchandise_name, price) values ('apple', 2.0);
insert into ordering.merchandise (merchandise_name, price) values ('banana', 1.5);
insert into ordering.merchandise (merchandise_name, price) values ('tomato', 1.2);
insert into ordering.merchandise (merchandise_name, price) values ('potato', 0.6);
insert into ordering.merchandise (merchandise_name, price) values ('egg', 0.3);
insert into ordering.merchandise (merchandise_name, price) values ('pork', 5.0);

select * from ordering.merchandise;
select merchandise_name, price from ordering.merchandise;

update ordering.merchandise 
set merchandise_name='watermelon', price=6.2 where merchandise_id=2;

alter table ordering.payment
drop total_price;

insert into ordering.payment (order_id, paid) values (1, 'paid');
insert into ordering.payment (order_id, paid) values (2, 'paid');
insert into ordering.payment (order_id, paid) values (3, 'paid');
insert into ordering.payment (order_id, paid) values (4, 'waiting');
insert into ordering.payment (order_id, paid) values (5, 'canceled');

select * from ordering.payment;

select usersinfo.user_name, merchandise.merchandise_name, round(merchandise.price * orders.num) as total_price
from ordering.orders 
inner join ordering.usersinfo 
inner join ordering.merchandise
on orders.user_id = usersinfo.user_id 
and orders.merchandise_id = merchandise.merchandise_id
where user_name="cheryl";

