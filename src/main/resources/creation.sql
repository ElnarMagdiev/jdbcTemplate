create schema if not exists schema_web;

create table if not exists schema_web.questions
(
    id bigserial not null
        constraint questions_pk
            primary key,
    content varchar(255) not null
);

create table if not exists schema_web.answers
(
    id bigserial not null
        constraint answers_pk
            primary key,
    question_id bigint not null
        constraint answers_questions_id_fk
            references schema_web.questions,
    content varchar(255) not null,
    correct boolean default false
);


