create sequence api_user_seq start with 1 increment by 50;
create sequence phone_seq start with 1 increment by 50;
create table api_user
(
    active     boolean      not null,
    created    timestamp(6) with time zone,
    last_login timestamp(6) with time zone,
    modified   timestamp(6) with time zone,
    email      varchar(255) unique,
    id         varchar(255) not null,
    name       varchar(255),
    password   varchar(255),
    token      varchar(255),
    primary key (id)
);
create table config
(
    id    varchar(255) not null,
    valor varchar(255),
    primary key (id)
);
create table phone
(
    id          bigint not null,
    citycode    varchar(255),
    countrycode varchar(255),
    number      varchar(255),
    user_id     varchar(255),
    primary key (id)
);
alter table if exists phone add constraint FKe7cnb9sbbe5p8dgrmfmkuiied foreign key (user_id) references api_user;