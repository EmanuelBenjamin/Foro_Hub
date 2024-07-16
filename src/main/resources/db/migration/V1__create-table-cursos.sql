
create table cursos(
    id bigint not null auto_increment,
    nombre varchar(100) not null unique,
    categoria varchar(100) not null,
    estado varchar(20) not null,
    activo boolean not null default true,
    primary key(id)
);

