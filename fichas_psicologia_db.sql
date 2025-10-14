CREATE DATABASE Fichas_Psicologia_DB;
CREATE TABLE Ficha(
Ficha_ID INT PRIMARY KEY,
DNI_Paciente INT,
Localidad VARCHAR(255),
Cobertura BOOLEAN,
Diagnostico VARCHAR(255),
Motivo_Consulta VARCHAR(255),
Nombre_Paciente VARCHAR(100),
Profesional VARCHAR(100),
Consulta BOOLEAN,
Observacion VARCHAR(255),
Estado BOOLEAN,
Fecha_Consulta DATETIME
);
CREATE TABLE Estadistica (
    Estadistica_ID INT PRIMARY KEY,
    Pacientes_Atendidos INT,
    Pacientes_Con_Cobertura VARCHAR(100),
    Pacientes_Sin_Cobertura VARCHAR(100),
    Cupos_Disponibles INT,
    Ficha_ID INT,
    FOREIGN KEY (Ficha_ID) REFERENCES Ficha(Ficha_ID),
    Fecha_Estadistica DATETIME
);
CREATE TABLE Controlador_DB (
    Resultado_ID INT PRIMARY KEY,
    ID_Ficha INT,
    ID_Estadistica INT,
    Fecha_Resultado DATETIME,
    FOREIGN KEY (ID_Ficha) REFERENCES Ficha(Ficha_ID),
    FOREIGN KEY (ID_Estadistica) REFERENCES Estadistica(Estadistica_ID)
);
INSERT INTO Ficha 
(Ficha_ID, DNI_Paciente, Localidad, Cobertura, Diagnostico, Motivo_Consulta, 
 Nombre_Paciente, Profesional, Consulta, Observacion, Estado, Fecha_Consulta) 
VALUES 
(1, 45235442, 'Paraná', TRUE, 'Depresión y Bipolaridad', 'Problemas domésticos', 
 'María López', 'Lic.Romero', TRUE, 'Paciente refiere problemas con sus padres', TRUE, '2025-08-14 10:30:00');
INSERT INTO Ficha 
(Ficha_ID, DNI_Paciente, Localidad, Cobertura, Diagnostico, Motivo_Consulta, 
 Nombre_Paciente, Profesional, Consulta, Observacion, Estado, Fecha_Consulta) 
VALUES 
(2, 32178659, 'Diamante', TRUE, 'Ansiedad Generalizada', 'Estrés laboral', 
 'Julián Gaitán', 'Lic.Romero', TRUE, 'Paciente refiere insomnio', TRUE, '2025-08-14 16:00:00');
INSERT INTO Ficha 
(Ficha_ID, DNI_Paciente, Localidad, Cobertura, Diagnostico, Motivo_Consulta, 
 Nombre_Paciente, Profesional, Consulta, Observacion, Estado, Fecha_Consulta) 
VALUES 
(3, 39876123, 'Crespo', TRUE, 'Depresión leve', 'Desmotivación', 
 'Juan Pérez', 'Lic.Fernandez', TRUE, 'Paciente mejora su ánimo', TRUE, '2025-08-15 10:15:00');
INSERT INTO Ficha 
(Ficha_ID, DNI_Paciente, Localidad, Cobertura, Diagnostico, Motivo_Consulta, 
 Nombre_Paciente, Profesional, Consulta, Observacion, Estado, Fecha_Consulta) 
VALUES 
(4, 45678231, 'Santa Fe', FALSE, 'Ataques de pánico', 'Crisis recientes', 
 'Lucia Ramírez', 'Lic.Fernandez', FALSE, 'Derivada por medico clínico', FALSE, '2025-08-15 18:00:00');
INSERT INTO Ficha 
(Ficha_ID, DNI_Paciente, Localidad, Cobertura, Diagnostico, Motivo_Consulta, 
 Nombre_Paciente, Profesional, Consulta, Observacion, Estado, Fecha_Consulta) 
VALUES 
(5, 43215678, 'Paraná', FALSE, 'Ansiedad generalizada', 'Estrés', 
 'Juan Román', 'Lic.Romero', TRUE, 'Paciente refiere insomnio', TRUE, '2025-08-15 17:00:00');

INSERT INTO Estadistica 
(Estadistica_ID, Pacientes_Atendidos, Pacientes_Con_Cobertura, Pacientes_Sin_Cobertura, 
 Cupos_Disponibles, Fecha_Estadistica)
VALUES
(1, 25, '20', '5', 10, '2025-09-01 08:00:00'),
(2, 18, '15', '3', 7, '2025-09-08 08:00:00'),
(3, 30, '27', '3', 5, '2025-09-15 08:00:00');

INSERT INTO Controlador_DB 
(Resultado_ID, ID_Ficha, ID_Estadistica, Fecha_Resultado)
VALUES
(1, 1, 1, '2025-09-01 10:30:00'),
(2, 2, 2, '2025-09-08 16:15:00'),
(3, 3, 3, '2025-09-15 11:00:00');

SELECT Ficha_ID, Nombre_Paciente, Diagnostico, Fecha_Consulta
FROM Ficha
WHERE Cobertura = TRUE;

SELECT COUNT(*) AS Total_Atendidos
FROM Ficha
WHERE DATE(Fecha_Consulta) = '2025-08-14';

SELECT 
    SUM(Pacientes_Atendidos) AS Total_Atendidos,
    SUM(CAST(Pacientes_Con_Cobertura AS UNSIGNED)) AS Total_Con_Cobertura,
    SUM(CAST(Pacientes_Sin_Cobertura AS UNSIGNED)) AS Total_Sin_Cobertura,
    SUM(Cupos_Disponibles) AS Cupos_Disponibles
FROM Estadistica;


