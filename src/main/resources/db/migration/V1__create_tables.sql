CREATE TABLE coletor (
    idColetor SERIAL PRIMARY KEY,
    nomeColetor VARCHAR(255) NOT NULL,
    cpfColetor CHAR(11) NOT NULL UNIQUE CHECK (cpfColetor ~ '^[0-9]{11}$')
);

CREATE TABLE entomologia (
    id SERIAL PRIMARY KEY,
    idColetor INTEGER NOT NULL REFERENCES coletor(idColetor),
    nome VARCHAR(255),
    dataColeta DATE,
    localColeta VARCHAR(255),
    nomeColetor VARCHAR(255),
    tag VARCHAR(100),
    familia VARCHAR(100),
    genero VARCHAR(100),
    ordem VARCHAR(100)
);

CREATE TABLE imagem_inseto (
    id SERIAL PRIMARY KEY,
    idInseto INTEGER NOT NULL REFERENCES entomologia(id),
    nomeArquivo VARCHAR(255),
    tipo VARCHAR(100),
    dados BYTEA NOT NULL
);
