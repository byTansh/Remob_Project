CREATE TABLE Passageiro 
( 
 nome VARCHAR(100),  
 CPF VARCHAR(20),  
 ID INT PRIMARY KEY AUTO_INCREMENT,  
 idade DATE,  
 telefone INT,  
 email VARCHAR(100),  
 senha VARCHAR(30),  
 genero VARCHAR(10) 
); 

CREATE TABLE Motorista 
( 
 CNH INT,  
 RG INT,  
 ID INT PRIMARY KEY AUTO_INCREMENT,  
 ID_Veiculo INT,  
 ID_Viagem INT,  
 CPF VARCHAR(20),  
 email VARCHAR(100),  
 nome VARCHAR(100),  
 senha VARCHAR(30),  
 telefone INT,  
 genero VARCHAR(10),  
 idade DATE
); 

CREATE TABLE Veiculo 
( 
 ID INT PRIMARY KEY AUTO_INCREMENT,  
 modelo VARCHAR(30),  
 placa VARCHAR(10),  
 tipo VARCHAR(20) 
); 

CREATE TABLE Viagem 
( 
 plano VARCHAR(10),  
 tipo VARCHAR(10),  
 ID INT PRIMARY KEY AUTO_INCREMENT,  
 ID_Passageiro INT,  
 ID_Motorista INT 
); 

CREATE TABLE Pagamento 
( 
 valorTotal FLOAT,  
 formaPagamento VARCHAR(20),  
 ID INT PRIMARY KEY AUTO_INCREMENT,  
 ID_Passageiro INT,  
 ID_Motorista INT,  
 ID_Viagem INT
); 

CREATE TABLE Avaliacao 
( 
 ID INT PRIMARY KEY AUTO_INCREMENT,  
 comentario VARCHAR(1000),
 notas INT,  
 ID_Viagem INT
); 

CREATE TABLE SolicitacaoSuporte 
( 
 Assunto VARCHAR(1000),
 Protocolo VARCHAR(10),
 Status VARCHAR(1),
 ID INT PRIMARY KEY AUTO_INCREMENT 
); 

CREATE TABLE SolicitaPassageiro 
( 
 ID_Passageiro INT,  
 ID_SolicitacaoSuporte INT
); 

CREATE TABLE SolicitaMotorista 
( 
 ID_Motorista INT,  
 ID_SolicitacaoSuporte INT
); 

ALTER TABLE Motorista ADD FOREIGN KEY(ID_Veiculo) REFERENCES Veiculo (ID);
ALTER TABLE Motorista ADD FOREIGN KEY(ID_Viagem) REFERENCES Viagem (ID);
ALTER TABLE Viagem ADD FOREIGN KEY(ID_Passageiro) REFERENCES Passageiro (ID);
ALTER TABLE Viagem ADD FOREIGN KEY(ID_Motorista) REFERENCES Motorista (ID);
ALTER TABLE Pagamento ADD FOREIGN KEY(ID_Passageiro) REFERENCES Passageiro (ID);
ALTER TABLE Pagamento ADD FOREIGN KEY(ID_Motorista) REFERENCES Motorista (ID);
ALTER TABLE Pagamento ADD FOREIGN KEY(ID_Viagem) REFERENCES Viagem (ID);
ALTER TABLE Avaliacao ADD FOREIGN KEY(ID_Viagem) REFERENCES Viagem (ID);
ALTER TABLE SolicitaPassageiro ADD FOREIGN KEY(ID_Passageiro) REFERENCES Passageiro (ID);
ALTER TABLE SolicitaPassageiro ADD FOREIGN KEY(ID_SolicitacaoSuporte) REFERENCES SolicitacaoSuporte (ID);
ALTER TABLE SolicitaMotorista ADD FOREIGN KEY(ID_Motorista) REFERENCES Motorista (ID);
ALTER TABLE SolicitaMotorista ADD FOREIGN KEY(ID_SolicitacaoSuporte) REFERENCES SolicitacaoSuporte (ID);
