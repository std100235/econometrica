create table COUNTRY
(
	ISO_CODE VARCHAR(3) not null,
	NAME VARCHAR(100) not null
);

create unique index COUNTRY_ISO_CODE_UINDEX
	on COUNTRY (ISO_CODE);

create unique index COUNTRY_NAME_UINDEX
	on COUNTRY (NAME);


alter table COUNTRY
	add constraint COUNTRY_PK
		primary key (ISO_CODE);


create table COUNTRY_DATASET
(
	START_YEAR VARCHAR(4) not null,
	NAME VARCHAR(255) not null,
	COUNTRY_CODE VARCHAR(3)
		constraint COUNTRY_ISO_CODE_GDP_FK
			references COUNTRY,
	END_YEAR VARCHAR(4) not null,
	DESCRIPTION VARCHAR(512),
	DATASET_ID INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY constraint COUNTRY_DATASET_PK primary key
);


create table COUNTRY_DATA
(
        ID  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY  constraint COUNTRY_DATA_PK	primary key,
	DATA_YEAR VARCHAR(4) not null,
	VALUE VARCHAR(255) not null,
	DATASET INTEGER
		constraint DATASET_ID_FK
			references COUNTRY_DATASET
);


