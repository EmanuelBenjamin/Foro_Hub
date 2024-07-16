create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje text not null,
    fecha_creacion datetime not null,
    estado varchar(20) not null,
    autor_id bigint not null,
    curso_id bigint not null,
    cantidad_respuestas int default 0,
    activo boolean not null default true,
    primary key(id),
    constraint fk_topicos_autor foreign key(autor_id) references usuarios(id),
    constraint fk_topicos_curso foreign key(curso_id) references cursos(id)
);