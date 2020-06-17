CREATE TABLE cliente (
NOME varchar(30),
COGNOME varchar(30),
CF varchar(16),
ANNO_DI_NASCITA date,
EMAIL varchar(30) primary key,
PASSWORD_CLIENTE varchar(30),
SESSIONE_ID int,
FOREIGN KEY (SESSIONE_ID) references sessione(ID)
);

