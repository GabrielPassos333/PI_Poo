CREATE TABLE Curso (
    id_curso SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE Prof (
    id_prof SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE Sala (
    id_sala SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    lugares INT NOT NULL
);

CREATE TABLE Materia (
    id_materia SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_curso INT NOT NULL,
    id_prof INT NOT NULL,
    CONSTRAINT fk_curso FOREIGN KEY (id_curso) REFERENCES Curso (id_curso),
    CONSTRAINT fk_prof FOREIGN KEY (id_prof) REFERENCES Prof (id_prof)
);

--CREATE TABLE Horario (
--    id_horario SERIAL PRIMARY KEY,
--    id_sala INT NOT NULL,
--    id_materia INT NOT NULL,
--    id_prof INT NOT NULL,
--    CONSTRAINT fk_sala FOREIGN KEY (id_sala) REFERENCES Sala (id_sala),
--    CONSTRAINT fk_materia FOREIGN KEY (id_materia) REFERENCES Materia (id_materia),
--    CONSTRAINT fk_prof FOREIGN KEY (id_prof) REFERENCES Prof (id_prof)
--);

/*ALTER TABLE horario
ADD COLUMN semestre INT,
ADD COLUMN dia_semana VARCHAR(10),
ADD CONSTRAINT chk_semestre CHECK (semestre IN (1, 2, 3, 4, 5, 6)),
ADD CONSTRAINT chk_dia_semana CHECK (dia_semana IN ('Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'));
*/

CREATE TABLE horario (
    id_horario SERIAL PRIMARY KEY,
    dia_semana VARCHAR(10) CHECK (dia_semana IN ('Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado')),
    semestre INTEGER NOT NULL CHECK (semestre IN (1, 2, 3, 4, 5, 6)),
    id_sala INTEGER NOT NULL,
    id_materia INTEGER NOT NULL,
    id_prof INTEGER NOT NULL,
    FOREIGN KEY (id_sala) REFERENCES sala (id_sala),
    FOREIGN KEY (id_materia) REFERENCES materia (id_materia),
    FOREIGN KEY (id_prof) REFERENCES prof (id_prof)
);

-- Inserindo cursos
INSERT INTO Curso (nome) VALUES ('Ciência da Computação'), ('Engenharia');

-- Inserindo professores
INSERT INTO Prof (nome) VALUES ('Carlos Silva'), ('Ana Souza');

-- Inserindo salas
INSERT INTO Sala (nome, lugares) VALUES ('Sala 101', 30), ('Sala 102', 25);

-- Inserindo matérias
INSERT INTO Materia (nome, id_curso, id_prof) VALUES 
('Algoritmos', 1, 1),
('Cálculo', 2, 2);

INSERT INTO Materia (nome, id_curso, id_prof) VALUES 
('Matemárica', 1, 1)

-- Inserindo horários
--INSERT INTO Horario (id_sala, id_materia, id_prof) VALUES 
/*(1, 1, 1), -- Sala 101, Matéria Algoritmos, Prof. Carlos Silva
(2, 2, 2); -- Sala 102, Matéria Cálculo, Prof. Ana Souza
(1,2,2)*/

select * from curso
select * from materia
select * from prof
select * from horario

SELECT 
    prof.nome AS professor, 
    mat.nome AS materia 
FROM 
    Prof prof
JOIN 
    Materia mat ON prof.id_prof = mat.id_prof
ORDER BY 
    prof.nome;
------------------------------------------------------
SELECT 
    prof.nome AS professor,
    mat.nome AS materia,
    sala.nome AS sala,
    horario.id_horario AS horario
FROM 
    Horario horario
JOIN 
    Prof prof ON horario.id_prof = prof.id_prof
JOIN 
    Materia mat ON horario.id_materia = mat.id_materia
JOIN 
    Sala sala ON horario.id_sala = sala.id_sala
ORDER BY 
    prof.nome, horario.id_horario;
------------------------------------------------------
SELECT 
    prof.nome AS professor,
    mat.nome AS materia,
    sala.nome AS sala,
    CASE horario.id_horario
        WHEN 1 THEN '19:00-19:50'
        WHEN 2 THEN '19:50-20:40'
        WHEN 3 THEN '20:50-21:40'
        WHEN 4 THEN '21:40-22:30'
		WHEN 5 THEN '09:30-10:20'
		WHEN 6 THEN '10:20-11:10'
		WHEN 7 THEN '11:20-12:10'
		WHEN 8 THEN '12:10-13:00'
        ELSE 'Horário desconhecido'
    END AS horario
FROM 
    Horario horario
JOIN 
    Prof prof ON horario.id_prof = prof.id_prof
JOIN 
    Materia mat ON horario.id_materia = mat.id_materia
JOIN 
    Sala sala ON horario.id_sala = sala.id_sala
ORDER BY 
    prof.nome, horario.id_horario;

-----------------------------------

SELECT 
    CASE horario.id_horario
        WHEN 1 THEN '19:00-19:50'
        WHEN 2 THEN '19:50-20:40'
        WHEN 3 THEN '20:50-21:40'
        WHEN 4 THEN '21:40-22:30'
        WHEN 5 THEN '09:30-10:20'
        WHEN 6 THEN '10:20-11:10'
        WHEN 7 THEN '11:20-12:10'
        WHEN 8 THEN '12:10-13:00'
        ELSE 'Horário desconhecido'
    END AS horario,
    prof.nome AS professor,
    mat.nome AS materia,
    sala.nome AS sala
FROM 
    Horario horario
JOIN 
    Prof prof ON horario.id_prof = prof.id_prof
JOIN 
    Materia mat ON horario.id_materia = mat.id_materia
JOIN 
    Sala sala ON horario.id_sala = sala.id_sala
ORDER BY 
    horario.id_horario, prof.nome;

----------------------------
select * from materia
select * from horario

