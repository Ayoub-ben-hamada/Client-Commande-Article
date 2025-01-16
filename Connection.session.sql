-- Table Client
CREATE TABLE Client (
    CodeClient VARCHAR(50) PRIMARY KEY,
    Rs VARCHAR(100),
    Adresse VARCHAR(200),
    Telephone VARCHAR(20)
);

-- Table Commande
CREATE TABLE Commande (
    NumCmd VARCHAR(50) PRIMARY KEY,
    DateCmd DATE,
    TotalHt DOUBLE PRECISION,
    TotalTTC DOUBLE PRECISION,
    CodeClient VARCHAR(50),
    FOREIGN KEY (CodeClient) REFERENCES Client(CodeClient)
);

-- Table Article
CREATE TABLE Article (
    CodeArticle VARCHAR(50) PRIMARY KEY,
    Libelle VARCHAR(100),
    Qte INTEGER,
    PrixHT DOUBLE PRECISION
);
