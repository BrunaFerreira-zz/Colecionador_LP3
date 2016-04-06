CREATE TABLE Usuario(
    id_usuario bigint NOT NULL PRIMARY KEY
                        GENERATED always AS IDENTITY
                        (START WITH 1, increment by 1),
    nome_usuario varchar(50) not null
);

CREATE TABLE infoUsuario(
    id_infoUsuario bigint NOT NULL PRIMARY KEY
                        GENERATED always AS IDENTITY
                        (START WITH 1, increment by 1),
    nome_Completo varchar(100) not null,
    acesso_Usuario varchar(10) not null,
    senha varchar(10) not null, 
    id_usuario bigint
);

CREATE TABLE emprestimo(
    id_emprestimo bigint NOT NULL PRIMARY KEY
                        GENERATED always AS IDENTITY
                        (START WITH 1, increment by 1),
    data_Emprestimo date not null,
    id_usuario bigint,
    id_obra bigint,
    id_autor bigint
);
CREATE TABLE obra(
  id_obra bigint NOT NULL PRIMARY KEY
                        GENERATED always AS IDENTITY
                        (START WITH 1, increment by 1),
  nome_obra varchar(100) not null, 
  id_autor bigint
);
CREATE TABLE autor(
    id_autor bigint NOT NULL PRIMARY KEY
                        GENERATED always AS IDENTITY
                        (START WITH 1, increment by 1),
    nome_autor varchar(100) not null,
    id_obra bigint
);

alter table infoUsuario
add foreign key (id_usuario)
references usuario(id_usuario)
on delete cascade;


alter table obra
add foreign key (id_autor)
references autor(id_autor)
on delete cascade;

alter table autor
add foreign key (id_obra)
references obra(id_obra)
on delete cascade;

alter table emprestimo
add foreign key (id_usuario)
references infoUsuario(id_infousuario)
on delete cascade;

alter table emprestimo
add foreign key (id_obra)
references obra(id_obra)
on delete cascade;