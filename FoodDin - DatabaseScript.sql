CREATE DATABASE restaurante;
USE restaurante;

CREATE TABLE PESSOA (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100),
    endereco TEXT,
    dataCadastro DATETIME DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_cpf (cpf)
);

CREATE TABLE FUNCIONARIO (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pessoaId INT NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    dataContratacao DATETIME NOT NULL,
    turno VARCHAR(20) NOT NULL,
    FOREIGN KEY (pessoaId) REFERENCES PESSOA(id),
    INDEX idx_pessoa (pessoaId)
);

CREATE TABLE CLIENTE (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pessoaId INT NOT NULL,
    pontosFidelidade INT DEFAULT 0,
    ultimaVisita DATETIME,
    FOREIGN KEY (pessoaId) REFERENCES PESSOA(id),
    INDEX idx_pessoa (pessoaId)
);

CREATE TABLE MESA (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero INT NOT NULL UNIQUE,
    capacidade INT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'DISPONIVEL',
    funcionarioId INT,
    FOREIGN KEY (funcionarioId) REFERENCES FUNCIONARIO(id),
    INDEX idx_status (status),
    INDEX idx_funcionario (funcionarioId)
);

CREATE TABLE ITEM_CARDAPIO (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    disponivel BOOLEAN DEFAULT true,
    INDEX idx_categoria (categoria),
    INDEX idx_disponivel (disponivel)
);

CREATE TABLE PEDIDO (
    id INT PRIMARY KEY AUTO_INCREMENT,
    mesaId INT NOT NULL,
    clienteId INT,
    funcionarioId INT NOT NULL,
    dataPedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL DEFAULT 'ABERTO',
    valorTotal DECIMAL(10,2) DEFAULT 0.00,
    FOREIGN KEY (mesaId) REFERENCES MESA(id),
    FOREIGN KEY (clienteId) REFERENCES CLIENTE(id),
    FOREIGN KEY (funcionarioId) REFERENCES FUNCIONARIO(id),
    INDEX idx_mesa (mesaId),
    INDEX idx_cliente (clienteId),
    INDEX idx_funcionario (funcionarioId),
    INDEX idx_status (status)
);

CREATE TABLE ITEM_PEDIDO (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pedidoId INT NOT NULL,
    itemCardapioId INT NOT NULL,
    quantidade INT NOT NULL,
    observacoes TEXT,
    precoUnitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (pedidoId) REFERENCES PEDIDO(id),
    FOREIGN KEY (itemCardapioId) REFERENCES ITEM_CARDAPIO(id),
    INDEX idx_pedido (pedidoId)
);

CREATE TABLE CONTA (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pedidoId INT NOT NULL UNIQUE,
    valorTotal DECIMAL(10,2) NOT NULL,
    desconto DECIMAL(10,2) DEFAULT 0.00,
    formaPagamento VARCHAR(50),
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',
    dataPagamento DATETIME,
    FOREIGN KEY (pedidoId) REFERENCES PEDIDO(id),
    INDEX idx_status (status)
);
