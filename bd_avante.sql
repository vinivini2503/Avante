CREATE DATABASE bd_avante;

USE bd_avante;

CREATE TABLE usuario(
	id_usuario BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_usuario)
);

CREATE TABLE tag(
	id_tag BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    id_usuario BIGINT NOT NULL,
    PRIMARY KEY(id_tag),
    FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE grauimportancia(
	id_grauimportancia BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    prioridade VARCHAR(24) NOT NULL,
    PRIMARY KEY(id_grauimportancia)
  
);

CREATE TABLE equipe_chat(
	id_chat_equipe BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    nome_equipe VARCHAR(100) NOT NULL,
    id_usuario BIGINT NOT NULL,
    PRIMARY KEY(id_chat_equipe),
    FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE mensagem(
	id_mensagem BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    id_chat_equipe BIGINT NOT NULL,
    id_usuario BIGINT NOT NULL,
    PRIMARY KEY(id_mensagem),
    FOREIGN KEY(id_chat_equipe) REFERENCES equipe_chat(id_chat_equipe),
    FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE participacao(
	id_participacao BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    id_chat_equipe BIGINT NOT NULL,
    PRIMARY KEY(id_participacao),
    FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY(id_chat_equipe) REFERENCES equipe_chat(id_chat_equipe)
);

CREATE TABLE tarefa(
	id_tarefa BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    nome_tarefa VARCHAR(100) NOT NULL,
    descricao_tarefa VARCHAR(100) NOT NULL,
    data_tarefa DATE NOT NULL,
    horario_tarefa TIME NOT NULL,
    duracao_tarefa TIME NOT NULL,
    id_usuario BIGINT NOT NULL,
    id_grauimportancia BIGINT NOT NULL,
    id_chat_equipe BIGINT NOT NULL,
    PRIMARY KEY(id_tarefa),
    FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY(id_grauimportancia) REFERENCES grauimportancia(id_grauimportancia),
    FOREIGN KEY(id_chat_equipe) REFERENCES equipe_chat(id_chat_equipe)
);

CREATE TABLE tag_tarefa(
	id_tag_tarefa BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    id_tarefa BIGINT NOT NULL,
    id_tag BIGINT NOT NULL,
    PRIMARY KEY(id_tag_tarefa),
    FOREIGN KEY(id_tarefa) REFERENCES tarefa(id_tarefa),
    FOREIGN KEY(id_tag) REFERENCES tag(id_tag)
);

INSERT INTO grauimportancia VALUES (NULL, 'Alta');
INSERT INTO grauimportancia VALUES (NULL, 'Média');
INSERT INTO grauimportancia VALUES (NULL, 'Baixa');
INSERT INTO grauimportancia VALUES (NULL, 'Sem prioridade');
