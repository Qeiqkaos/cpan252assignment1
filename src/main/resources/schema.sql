create table if not exists item (
  id identity,
  name varchar(50) not null,
  price int not null,
  yearcreated int not null,
  brand_from varchar(50) not null
);