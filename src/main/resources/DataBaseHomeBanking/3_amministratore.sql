use `sql7347782`;
CREATE  TABLE amministratore(
EMAIL VARCHAR(30),
PASSWORD_ADMIN VARCHAR(30),
ID INTEGER AUTO_INCREMENT PRIMARY KEY,
SESSIONE_ID INTEGER,

FOREIGN KEY(SESSIONE_ID) REFERENCES sessione(ID)


);