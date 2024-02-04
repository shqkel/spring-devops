-- drop table product;
-- drop sequence product_seq;

create table product (
    id number,
    name varchar2(500),
    created_at timestamp default systimestamp,
    constraint pk_product_id primary key (id)
);
create sequence product_seq
increment by 50;