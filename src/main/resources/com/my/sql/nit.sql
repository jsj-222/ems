create table t_emp
(
    id     varchar(40)  primary key,
    name   varchar(60)  null,
    salary double(7, 2) null,
    age    int(3)       null,
    bir    date         null
);
create table t_user
(
    id       varchar(40) primary key,
    username varchar(40) null,
    realname varchar(40) null,
    password varchar(40) null,
    sex      varchar(8)  null
)