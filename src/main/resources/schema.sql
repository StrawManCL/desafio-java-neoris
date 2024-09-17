create sequence phone_seq start with 1 increment by 50;
create table api_user
(
    active     boolean not null,
    created    timestamp(6) with time zone,
    last_login timestamp(6) with time zone,
    modified   timestamp(6) with time zone,
    id         uuid    not null,
    email      varchar(255) unique,
    name       varchar(255),
    password   varchar(255),
    token      varchar(255),
    primary key (id)
);
create table api_user_phones
(
    phones_id bigint not null unique,
    user_id   uuid   not null
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
    primary key (id)
);
alter table if exists api_user_phones add constraint FKjk0j2bq8kgrh1e3ou8dclxpdu foreign key (phones_id) references phone;
alter table if exists api_user_phones add constraint FKchu7955do7ty91yll4onf0cgp foreign key (user_id) references api_user;