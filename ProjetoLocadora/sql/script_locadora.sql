create table Clientes (
id int (100) primary key auto_increment not null,
nome varchar (100) not null,
email varchar (100) not null,
telefone varchar (100) not null 

);

create table Filmes(
id int (100) primary key auto_increment not null,
nomeFilme varchar(100) not null

);

create table Emprestimos(
id int(100) primary key auto_increment not null,
dataEmpre date not null,
dataDev date not null,
descr varchar (100) not null,
foreign key (id)
references clientes (id),
foreign key (id)
references Filmes (id)
);
