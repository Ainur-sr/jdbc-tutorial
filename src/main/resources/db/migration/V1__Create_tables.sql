create table ADDRESS
(
    ID        BIGINT       not null,
    COUNTRY   VARCHAR(255) not null,
    CITY      VARCHAR(255) not null,
    STREET    VARCHAR(255) not null,
    POST_CODE VARCHAR(15)  not null,
    constraint ADDRESS_PKEY
        primary key (ID)
);

create table EMPLOYEE
(
    ID         BIGINT       not null,
    FIRST_NAME VARCHAR(255) not null,
    LAST_NAME  VARCHAR(255) not null,
    BIRTHDAY   DATE         not null,
    ADDRESS_ID BIGINT       not null,
    constraint EMPLOYEE_PKEY
        primary key (ID),
    constraint EMPLOYEE_FKEY
        foreign key (ADDRESS_ID) references ADDRESS (ID)
);

create table PROJECT
(
    ID    BIGINT       not null,
    TITLE VARCHAR(255) not null,
    constraint PROJECT_PKEY
        primary key (ID)
);

create table EMPL_PROJ
(
    EMPLOYEE_ID BIGINT not null,
    PROJECT_ID  BIGINT not null,
    constraint EMPL_PROJ_EMPLOYEE_ID_FKEY
        foreign key (EMPLOYEE_ID) references EMPLOYEE (ID),
    constraint EMPL_PROJ_PROJECT_ID_FKEY
        foreign key (PROJECT_ID) references PROJECT (ID)
);