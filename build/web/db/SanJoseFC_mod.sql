USE master
GO

if DB_ID ('SanJoseFC') IS NOT NULL
DROP DATABASE SanJoseFC
CREATE DATABASE SanJoseFC
GO

USE SanJoseFC
GO

CREATE TABLE Login
(
Id_Login INT IDENTITY(1,1) PRIMARY KEY,
Usuario VARCHAR (15) NOT NULL, --Nombre de usuario en el login
Pazzword VARCHAR (8) NOT NULL, --Contraseña de la contraseña
)
GO

INSERT INTO Login VALUES('Admin','123')
INSERT INTO Login VALUES('Profe','456')
GO

CREATE TABLE Cargo
(
Id_Cargo INT IDENTITY(1,1) PRIMARY KEY,
NombreCargo VARCHAR (50) NOT NULL, --Nombre del cargo del usuario
)
GO

INSERT INTO Cargo VALUES('Administrador')
INSERT INTO Cargo VALUES('Profesor')
GO

CREATE TABLE Empleado
(
Id_Empleado INT IDENTITY(1,1) PRIMARY KEY,
Id_Login INT FOREIGN KEY REFERENCES Login, --Login personal para cada empleado [Combo box para elegir el login]
Id_Cargo INT FOREIGN KEY REFERENCES Cargo, --Cargo del empleado [Combo box para elegir el cargo]
NombreEmpleado VARCHAR (50) NOT NULL, --Nombre del empleado [Cuadro de texto]
ApellidoEmpleado VARCHAR (50) NOT NULL, --Apellido del empleado [Cuadro de texto]
DireccionEmpleado VARCHAR(50) NOT NULL, -- Direccion del empleado [Cuadro de texto]
Telefono VARCHAR (12) NOT NULL, -- Telefono del empleado [Cuadro de texto]
FechaNacimiento DATE NOT NULL, -- Fecha de nacimiento del empleado [ Cuadro de fecha (dd/mm/aaaa)] 
Dni VARCHAR (8) NOT NULL, -- DNI del empleado [Cuadro de texto]
Vigencia BIT NOT NULL, -- Vigencia para el empleado si es que sigue trabajando en la empresa [Check box]
)
GO

INSERT INTO Empleado VALUES(2,2,'Profesor 1','Profesor Apellido 1','Profesor Casa 1',123456789,'2000/01/01',12345678,1)
INSERT INTO Empleado VALUES(2,2,'Profesor 2','Profesor Apellido 2','Profesor Casa 2',234567891,'2000/02/02',23456781,1)
GO

CREATE TABLE Categoria -- Categoria 1 a registrar
(
Id_Categoria INT IDENTITY(1,1) PRIMARY KEY,
NombreAnioCategoria VARCHAR (50) NOT NULL, -- Nombre del año de la categoria : "Categoria 2012" por ejemplo [Cuadro de texto]
Turno BIT NOT NULL, --Turno 1 // Turno 2 [Combo box]
)
GO

INSERT INTO Categoria VALUES('Categoria 2010',1)
INSERT INTO Categoria VALUES('Categoria 2011',2)
GO

CREATE TABLE Apoderado
(
Id_Apoderado INT IDENTITY(1,1) PRIMARY KEY,
NombreApoderado VARCHAR (50) NOT NULL, --Nombre del apoderado [Cuadro de texto]
ApellidoApoderado VARCHAR (50) NOT NULL, --Apellido del apoderado [Cuadro de texto]
DetalleApoderado VARCHAR (50) NOT NULL, -- Define que es el apoderado del alumno (mamá/papá/hermanos/tio/etc) [Cuadro de texto]
Direccion VARCHAR (50) NOT NULL, -- Direccion del apoderado [Cuadro de texto]
FechaNacimiento DATE NOT NULL, -- Fecha de nacimiento del apoderado [ Cuadro de fecha (dd/mm/aaaa)] 
Dni VARCHAR (12) NOT NULL, --DNI Del apoderado [Cuadro de texto]
Telefono VARCHAR (12) NULL, --Teléfono del apoderado [Cuadro de texto]
)
GO

INSERT INTO Apoderado VALUES('Victor','Tello','Papá','Chiclayo','2001/05/20',87654321,987654321)
GO

CREATE TABLE Alumno
(
Id_Alumno INT IDENTITY(1,1) PRIMARY KEY,
NombreAlumno VARCHAR (50) NOT NULL, -- Nombre del alumno [Cuadro de texto]
ApellidoAlumno VARCHAR (50) NOT NULL, -- Apellido del alumno [Cuadro de texto]
Direccion VARCHAR (50) NOT NULL, -- Direccion del alumno [Cuadro de texto]
FechaNacimiento DATE NOT NULL, -- Fecha de nacimiento del alumno [ Cuadro de fecha (dd/mm/aaaa)] 
Dni VARCHAR (12) NOT NULL, -- DNI del alumno [Cuadro de texto]
Vigencia BIT NOT NULL, -- Si es que el alumno sigue en la academia de futbol (Aparece seleccionado)
VigenciaTorneos BIT NOT NULL, -- Para ver si esta habilitado para un torneo (Ya sea si hizo el pago y el padre aprobó su participacion)
passwordAlumno VARCHAR(6) NOT NULL, -- Contraseña para el loguin del alumno 
)
GO

INSERT INTO Alumno VALUES('Fabrizzio','Facho','Chiclayo casa','2002/04/13',18273645,1,1,123)
GO

CREATE TABLE Torneo
(
Id_Torneo INT IDENTITY(1,1) PRIMARY KEY,
Nombre VARCHAR (50) NOT NULL, -- Nombre del torneo [Cuadro de texto]
Empleado VARCHAR(30) NOT NULL, -- Persona encargada de ese torneo [Cuadro de texto]
Lugar VARCHAR(60) NOT NULL, -- El lugar (Direccion) donde se realizará el torneo [Cuadro de texto]
FechaInicio DATE NOT NULL, -- Fecha de Inicio del torneo [ Cuadro de fecha (dd/mm/aaaa)] 
FechaFin DATE NOT NULL, -- Fecha de Fin del torneo [ Cuadro de fecha (dd/mm/aaaa)] 
)
GO

INSERT INTO Torneo VALUES('La liga','fernando','canchita','2019/07/10','2019/08/14')
GO

CREATE TABLE Inscripcion --Para saber que alumno entra en que torneo y cuanto tiene que pagar
(
Id_Inscripcion INT IDENTITY(1,1) PRIMARY KEY, 
Id_Torneo INT FOREIGN KEY REFERENCES Torneo, -- Elegir en que torneo se va a inscribir el alumno [Combo box]
Id_Alumno INT FOREIGN KEY REFERENCES Alumno, -- Elegir el alumno que se va a inscribir en el torneo [Combo box]
Monto MONEY NOT NULL, -- Cuanto va a pagar el alumno en la inscripcion del torneo
VigenciaPago BIT NOT NULL, -- Para saber si ya pagó la inscripcion [Check box] 
)
GO

INSERT INTO Inscripcion VALUES(1,1,20,1)
GO

CREATE TABLE Asistencia -- Lista para hacer la asistencia (Todos los alumnos salen en lista)
(
Id_Asistencia INT IDENTITY(1,1) PRIMARY KEY,
Id_Alumno INT FOREIGN KEY REFERENCES Alumno,
fecha DATE NOT NULL, --Auto asignada del sistema
Asistió BIT NOT NULL, -- Define si asistio o no [Check box] (1 = si // 0 = no)
)
GO

INSERT INTO Asistencia VALUES(1,getdate(),1)

CREATE TABLE Performance
(
Id_Evaluacion INT IDENTITY(1,1) PRIMARY KEY,
Id_Alumno INT FOREIGN KEY REFERENCES Alumno, -- Seleccionar a que alumno pertenecen los datos de performace [Combo box]
Talla DECIMAL(3,2) NOT NULL, -- Talla del alumno [Cuadro de text]
CondicionFisica INT NOT NULL, -- Condicion fisica del alumno [Un seleccionador de 1 al 10 (Siendo 1 nada y 10 excelente)]
DominioBalon INT NOT NULL, -- Dominio del balon [Combo box(Bueno/Regular/Malo)]
TipoJugador VARCHAR (50) NOT NULL, -- Tipo de jugador que es el alumno [Cuadro de texto]
fecha DATE NOT NULL, -- Fecha de registro del performace [ Cuadro de fecha (dd/mm/aaaa)] 
)
GO

INSERT INTO Performance VALUES(1,1.60,9,1,'Habilidoso','2019/08/15')
GO

CREATE TABLE Matricula
(
Id_Matricula INT IDENTITY(1,1) PRIMARY KEY,
Id_Apoderado INT FOREIGN KEY REFERENCES Apoderado, -- Seleccionar el apoderado a registrar en la matricula [Combo box]
Id_Alumno INT FOREIGN KEY REFERENCES Alumno, -- Seleccionar que alumno a registrar en la matricula [Combo box]
Id_Empleado INT FOREIGN KEY REFERENCES Empleado, -- Seleccionar el empleado que registra la matricula (Auto asignado dependiendo quien esta logeado en el sistema)
Id_Categoria INT FOREIGN KEY REFERENCES Categoria, -- Para saber en que categoria estará matriculado el alumno 
FechaMatricula DATE NOT NULL, -- Fecha de la matricula [ Cuadro de fecha (dd/mm/aaaa)] 
Temporada BIT NOT NULL,--Tiempo de Invierno o Verano (Depende de como quiera matricularse el alumno :D ) [Combo box]
Estado BIT NOT NULL,--Si esta o no matriculado [Check box]
PagoMatricula MONEY NOT NULL, -- El pago total de la matricula [Speener]
FechaPago DATE NOT NULL, -- Fecha del pago de la matricula [ Cuadro de fecha (dd/mm/aaaa)]
)
GO

INSERT INTO Matricula VALUES(1,1,1,1,'2019/08/14',2,1,20,'2019/08/15')
GO

CREATE TABLE PagoMensual
(
Id_PagoMensual INT IDENTITY(1,1) PRIMARY KEY,
Id_Matricula INT FOREIGN KEY REFERENCES Matricula, -- Para saber que matricula esta pagando [Combo box]
MontoPagado DECIMAL(6,2) NULL, -- Ultimo monto que pagaste [Cuadro de texto sin poder modificar nada de el (label)]
MontoPagar DECIMAL(6,2) NOT NULL, -- Monto que vas a pagar [Cuadro de texto]
FechaPagada DATE  NULL, -- Ultima fecha que pagaste [ Cuadro de fecha (dd/mm/aaaa)]
FechaPagar DATE NOT NULL, -- Fecha actual del pago que se esta realizando [ Cuadro de fecha (dd/mm/aaaa)]
Vigencia BIT NOT NULL,--Si realizo el pago de ese mes [Check box]
)
GO

INSERT INTO PagoMensual VALUES(1,0,15,'','2019/08/16',1)
GO

SELECT M.Id_Matricula,A.NombreApoderado,Al.NombreAlumno,Em.NombreEmpleado,Ca.NombreAnioCategoria,m.FechaMatricula,M.Temporada,M.Estado,M.PagoMatricula,M.FechaPago
 FROM Matricula M INNER JOIN Apoderado A ON M.Id_Apoderado=A.Id_Apoderado
				  INNER JOIN Alumno Al ON M.Id_Alumno=Al.Id_Alumno
				  INNER JOIN Empleado Em ON M.Id_Empleado=Em.Id_Empleado
				  INNER JOIN Categoria Ca ON M.Id_Categoria=Ca.Id_Categoria