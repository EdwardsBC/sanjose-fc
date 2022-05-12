USE master
GO

if DB_ID ('SanJoseFC') IS NOT NULL
DROP DATABASE SanJoseFC
CREATE DATABASE SanJoseFC
GO

USE SanJoseFC
GO

--COMPLETAR LOS PAGOS DE PAGOS PARA TORNEOS
-- AGREGAR MAS CAMPOS A TODO!
CREATE TABLE Login
(
Id_Login INT IDENTITY(1,1) PRIMARY KEY,
Usuario VARCHAR (15) NOT NULL,
Pazzword VARCHAR (8) NOT NULL,
)
GO

CREATE TABLE Cargo
(
Id_Cargo INT IDENTITY(1,1) PRIMARY KEY,
NombreCargo VARCHAR (50) NOT NULL,
)
GO

CREATE TABLE Empleado
(
Id_Empleado INT IDENTITY(1,1) PRIMARY KEY,
Id_Login INT FOREIGN KEY REFERENCES Login,
Id_Cargo INT FOREIGN KEY REFERENCES Cargo,
NombreEmpleado VARCHAR (50) NOT NULL,
ApellidoEmpleado VARCHAR (50) NOT NULL,
DireccionEmpleado VARCHAR(50) NOT NULL,
Telefono VARCHAR (12) NOT NULL,
FechaNacimiento DATE NOT NULL,
Dni VARCHAR (8) NOT NULL,
Vigencia BIT NOT NULL,
)
GO

CREATE TABLE Categoria
(
Id_Categoria INT IDENTITY(1,1) PRIMARY KEY,
NombreAnioCategoria VARCHAR (50) NOT NULL,
Turno DATE NOT NULL, --Turno 1 // Turno 2
)
GO

CREATE TABLE UnionCategorias
(
Id_UnionCategorias INT IDENTITY(1,1) PRIMARY KEY,
DetalleCategorias VARCHAR(150) NOT NULL,
)
GO

CREATE TABLE DetalleCategorias
(
Id_DetalleCategorias INT IDENTITY(1,1) PRIMARY KEY,
Id_Categoria INT FOREIGN KEY REFERENCES Categoria,
Id_UnionCategorias INT FOREIGN KEY REFERENCES UnionCategorias,
)
GO

CREATE TABLE Apoderado
(
Id_Apoderado INT IDENTITY(1,1) PRIMARY KEY,
NombreApoderado VARCHAR (50) NOT NULL,
ApellidoApoderado VARCHAR (50) NOT NULL,
DetalleApoderado VARCHAR (50) NOT NULL, -- DEFINE SI ES PADRE, MADRE, ETC.
Direccion VARCHAR (50) NOT NULL, -- DONDE VIVE EL APODERADO
FechaNacimiento DATE NOT NULL, -- AÑO EN EL QUE NACIO EL APODERADO
Dni VARCHAR (12) NOT NULL, 
Telefono VARCHAR (12) NULL,
)
GO

CREATE TABLE Torneo
(
Id_Torneo INT IDENTITY(1,1) PRIMARY KEY,
Nombre VARCHAR (50) NOT NULL, -- Nombre del torneo
Empleado VARCHAR(30) NOT NULL, -- Persona encargada de ese torneo
Lugar VARCHAR(60) NOT NULL, -- El lugar (Direccion) donde se realizará el torneo
FechaInicio DATE NOT NULL, -- INICIO DEL TORNEO
FechaFin DATE NOT NULL, -- FINAL DEL TORNEO
)
GO

CREATE TABLE Inscripcion --Es como un detalle, entre el torneo y el alumno
(
Id_Inscripcion INT IDENTITY(1,1) PRIMARY KEY, 
Id_Torneo INT FOREIGN KEY REFERENCES Torneo,
Monto MONEY NOT NULL,
)
GO

--CREATE TABLE PagoTorneo
--(
--Id_PagoTorneo INT IDENTITY(1,1) PRIMARY KEY,
--Id_Torneo INT FOREIGN KEY REFERENCES Torneo,
--FechaPago DATE NOT NULL,
--PagoTorneo MONEY NOT NULL,
--MontoPagado MONEY NOT NULL, -- Si en caso se puede pagar por partes, aquí se ve cuanto a pagado ya
--Vigencia BIT NOT NULL,--Si pagó
--)
--GO

CREATE TABLE Alumno
(
Id_Alumno INT IDENTITY(1,1) PRIMARY KEY,
--Id_Inscripcion INT FOREIGN KEY REFERENCES Inscripcion,
Id_Torneo INT FOREIGN KEY REFERENCES Torneo,
NombreAlumno VARCHAR (50) NOT NULL,
ApellidoAlumno VARCHAR (50) NOT NULL,
Direccion VARCHAR (50) NOT NULL,
FechaNacimiento DATE NOT NULL,
Dni VARCHAR (12) NOT NULL,
Vigencia BIT NOT NULL,
VigenciaTorneos BIT NOT NULL,
passwordAlumno VARCHAR(6) NOT NULL,
)
GO


CREATE TABLE ApoderadoAlumno
(
Id_ApoderadoAlumno INT IDENTITY(1,1) PRIMARY KEY,
Id_Alumno INT FOREIGN KEY REFERENCES Alumno,
Id_Apoderado INT FOREIGN KEY REFERENCES Apoderado,
)
GO

CREATE TABLE Asistencia
(
Id_Asistencia INT IDENTITY(1,1) PRIMARY KEY,
Id_Alumno INT FOREIGN KEY REFERENCES Alumno,
fecha DATE NOT NULL,
Asistió BIT NOT NULL,
)
GO

CREATE TABLE Performance
(
Id_Evaluacion INT IDENTITY(1,1) PRIMARY KEY,
Id_Alumno INT FOREIGN KEY REFERENCES Alumno,
Talla DECIMAL(3,2) NOT NULL,
CondicionFisica VARCHAR (50) NOT NULL,
DominioBalon VARCHAR (50) NOT NULL,
TipoJugador VARCHAR (50) NOT NULL,
fecha DATE NOT NULL,
)
GO

CREATE TABLE Matricula
(
Id_Matricula INT IDENTITY(1,1) PRIMARY KEY,
Id_ApoderadoAlumno INT FOREIGN KEY REFERENCES ApoderadoAlumno,
Id_Empleado INT FOREIGN KEY REFERENCES Empleado,
Id_UnionCategorias INT FOREIGN KEY REFERENCES UnionCategorias UNIQUE,
FechaMatricula DATE NOT NULL,
Temporada BIT NOT NULL,--Tiempo de Invierno o Verano (Depende de como quiera matricularse el alumno :D )
Estado BIT NOT NULL,--Si esta o no matriculado
PagoMatricula MONEY NOT NULL,
FechaPago MONEY NOT NULL,
)
GO

CREATE TABLE PagoMensual
(
Id_PagoMensual INT IDENTITY(1,1) PRIMARY KEY,
Id_Matricula INT FOREIGN KEY REFERENCES Matricula,
MontoPagado DECIMAL(6,2) NOT NULL,
MontoPagar DECIMAL(6,2) NOT NULL,
FechaPagada DATE NOT NULL,
FechaPagar DATE NOT NULL,
Vigencia BIT NOT NULL,--Si realizo el pago ese mes
)
GO