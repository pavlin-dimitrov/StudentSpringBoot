drop table if exists "students"
create table "students"
(
  id bigint primary key not null,
  name varchar(50) not null,
  email varchar(50) not null,
  dob varchar(8)
)