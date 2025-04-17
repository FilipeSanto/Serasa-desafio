CREATE SEQUENCE PESSOA_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE Pessoa (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255),
    idade VARCHAR(3),
    cep VARCHAR(8),
    estado VARCHAR(255),
    cidade VARCHAR(255),
    bairro VARCHAR(255),
    logradouro VARCHAR(255),
    telefone VARCHAR(15),
    score INTEGER,
    ativo BOOLEAN
);

DELETE FROM PESSOA;
ALTER SEQUENCE PESSOA_SEQ RESTART WITH 1;

-- Inserindo registros com o campo "ativo"
INSERT INTO Pessoa (id, nome, idade, cep, estado, cidade, bairro, logradouro, telefone, score, ativo)
VALUES
(NEXT VALUE FOR PESSOA_SEQ, 'João Silva', '30', '12345678', 'Minas Gerais', 'Araxá', 'Centro', 'Rua Principal', '34912345678', 150, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Maria Oliveira', '25', '87654321', 'Minas Gerais', 'Belo Horizonte', 'Savassi', 'Rua das Flores', '34987654321', 250, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Carlos Souza', '40', '11223344', 'São Paulo', 'São Paulo', 'Jardim Paulista', 'Av. Paulista', '34911223344', 500, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Ana Lima', '35', '55667788', 'Rio de Janeiro', 'Rio de Janeiro', 'Copacabana', 'Av. Atlântica', '34955667788', 550, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Ana Clara Santos', '32', '55667788', 'São Paulo', 'Campinas', 'Taquaral', 'Rua das Palmeiras', '11987654321', 750, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Carlos Eduardo Lima', '45', '22334455', 'Rio de Janeiro', 'Niterói', 'Icaraí', 'Av. Sete de Setembro', '21965432112', 999, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Fernanda Oliveira', '27', '44556677', 'Minas Gerais', 'Belo Horizonte', 'Savassi', 'Rua da Bahia', '31987654322', 1, true),
(NEXT VALUE FOR PESSOA_SEQ, 'João Pedro Silva', '39', '11223344', 'Rio de Janeiro', 'Petrópolis', 'Centro', 'Rua Imperador', '21954321678', 320, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Mariana Andrade', '30', '33445566', 'Bahia', 'Salvador', 'Barra', 'Av. Oceânica', '71999887766', 221, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Rafael Souza', '29', '66778899', 'Paraná', 'Curitiba', 'Batel', 'Rua Vicente Machado', '41987654543', 200, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Gabriela Almeida', '34', '77889900', 'Pernambuco', 'Recife', 'Boa Viagem', 'Av. Boa Viagem', '81955443322', 300, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Lucas Pereira', '40', '88990011', 'Santa Catarina', 'Florianópolis', 'Centro', 'Rua Felipe Schmidt', '48998765432', 400, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Beatriz Rocha', '26', '99001122', 'Ceará', 'Fortaleza', 'Meireles', 'Rua Silva Jatahy', '85988887766', 500, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Thiago Gonçalves', '31', '11334455', 'Goiás', 'Goiânia', 'Marista', 'Av. Goiás', '62977665544', 600, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Vanessa Mendes', '37', '22335566', 'Amazonas', 'Manaus', 'Ponta Negra', 'Rua do Sol', '92999887711', 700, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Felipe Araújo', '44', '33446677', 'Rio Grande do Sul', 'Porto Alegre', 'Moinhos de Vento', 'Rua Padre Chagas', '51955443388', 800, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Larissa Figueiredo', '28', '44557788', 'Espírito Santo', 'Vitória', 'Praia do Canto', 'Av. Nossa Senhora', '27987766544', 900, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Henrique Lopes', '36', '55668899', 'Minas Gerais', 'Uberlândia', 'Santa Mônica', 'Av. João Naves', '34966778899', 0, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Patrícia Ribeiro', '33', '66779900', 'Distrito Federal', 'Brasília', 'Asa Sul', 'SQS 308', '61955443377', 100, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Rodrigo Martins', '38', '77880011', 'Mato Grosso', 'Cuiabá', 'Centro', 'Av. Getúlio Vargas', '65988776655', 780, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Camila Costa', '35', '88991122', 'Mato Grosso do Sul', 'Campo Grande', 'Jardim dos Estados', 'Rua Ceará', '67999887711', 920, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Eduardo Lima', '42', '99002233', 'Alagoas', 'Maceió', 'Ponta Verde', 'Av. Álvaro Otacílio', '82977665588', 810, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Juliana Moreira', '25', '11335566', 'Pará', 'Belém', 'Umarizal', 'Av. Nazaré', '91955443322', 890, true),
(NEXT VALUE FOR PESSOA_SEQ, 'Daniel Freitas', '41', '22336677', 'Roraima', 'Boa Vista', 'Centro', 'Rua Dr. Araujo', '95988776655', 830, true);

CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);

--INSERT INTO users (id, login, password, role)
----VALUES ('1', 'carlos_user', '$2a$10$vuDnxpTpabQEJkPkZYfynemfidDggSa1OxrdVqgIMb3E5NFmwDM3q', 'USER');
--VALUES ('1', 'carlos_user', 'senha123', 'USER');
--
--INSERT INTO users (id, login, password, role)
--VALUES ('2', 'Fernanda Almeida', 'fernanda_admin', 'admin456', 'ADMIN');