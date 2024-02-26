CREATE TABLE assignees_to_tasks (
        task_id bigint NOT NULL,
        person_id bigint NOT NULL,
        PRIMARY KEY (task_id, person_id)
    );

CREATE TABLE person (
        id bigserial not null,
        email varchar(255) not null,
        guid varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        address_id bigint not null,
        primary key (id)
    );

create table residence_address (
        id bigserial not null,
        city varchar(255) not null,
        complement varchar(255),
        country varchar(255) not null,
        district varchar(255) not null,
        number varchar(255) not null,
        state varchar(255) not null,
        street varchar(255) not null,
        primary key (id)
    );

create table task (
        id bigserial not null,
        created_at timestamp(6) not null,
        deleted boolean not null,
        description TEXT,
        finished_at timestamp(6),
        guid varchar(255) not null,
        status VARCHAR(20) not null check (status in ('NOT_STARTED','DOING','COMPLETED')),
        title varchar(255) not null,
        person_id bigint not null,
        primary key (id)
    );

alter table if exists person
           drop constraint if exists UK_fwmwi44u55bo4rvwsv0cln012;

alter table if exists person
       add constraint UK_fwmwi44u55bo4rvwsv0cln012 unique (email);


alter table if exists person
       drop constraint if exists UK_qyfih6d32lgpd4nhawlqmmsy2;

alter table if exists person
       add constraint UK_qyfih6d32lgpd4nhawlqmmsy2 unique (guid);

alter table if exists person
       drop constraint if exists UK_o8tnkglv9n1eeqmo7de7em37n;

alter table if exists person
       add constraint UK_o8tnkglv9n1eeqmo7de7em37n unique (address_id);

alter table if exists task
       drop constraint if exists UK_lbepcp6aox9e18r9jeum5uejd;

alter table if exists task
       add constraint UK_lbepcp6aox9e18r9jeum5uejd unique (guid);

 alter table if exists assignees_to_tasks
       add constraint FKbcorpfm33ec0e4h1gu676n8o8
       foreign key (person_id)
       references person;

alter table if exists assignees_to_tasks
       add constraint FKaj2rtiixh6jbgpgufgt96pjjq
       foreign key (task_id)
       references task;

alter table if exists person
       add constraint FKe86q2i97ab30fn40r3apk2ynq
       foreign key (address_id)
       references residence_address;

alter table if exists task
       add constraint FK1b9x9tb4qrlrhnb6v2xes2792
       foreign key (person_id)
       references person;

insert
    into
        residence_address
        (city, complement, country, district, number, state, street)
    values
        ('Cidade 01', 'Casa 01','País 01', 'Bairro 01', '01', 'Estado 01', 'Rua 01');

insert
    into
        person
        (address_id, email, guid, name, password)
    values
        (1, 'user@example.com', 'b80936a3-7363-4333-a180-2a7ef6933c61', 'Usuário Teste', '$2a$10$pc0gtcd58Jn3h0dwjIdTP.mPXOBT22bhvKC8OvSB/WokS55MOvN3G');