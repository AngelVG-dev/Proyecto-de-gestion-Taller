create database tallerM;
use tallerM;

create table Empleado(
  IdEmpleado INT NOT NULL AUTO_INCREMENT,
  Nombre VARCHAR(100) NOT NULL,
  Apellido_Paterno VARCHAR(100) NOT NULL,
  Apellido_Materno VARCHAR(100) NOT NULL,
  Edad INT NOT NULL,
  Cargo VARCHAR(80) NOT NULL,
  Telefono VARCHAR(10) NULL,
  PRIMARY KEY (IdEmpleado)
);



insert into empleado value
(1, 'Juan', 'Romero', 'Vazquez', 25, 'Administrativo', '893120');



create table Usuarios(
  id INT NOT NULL AUTO_INCREMENT,
  IdEmpleado int not null,
  Usuario VARCHAR(150) NOT NULL,
  Contraseña VARCHAR(100) NOT NULL,
   PRIMARY KEY (id, IdEmpleado),
    FOREIGN KEY (IdEmpleado)
    REFERENCES Empleado (IdEmpleado)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );
    
    insert into usuarios value
    (1,1, 'JuanPro', 'maikra');
    

    
create table cliente (
  idCliente INT NOT NULL auto_increment,
  Nombre VARCHAR(250) NOT NULL,
  Apellidos VARCHAR(250) NOT NULL,
  Correo_electronico VARCHAR(255) NULL,
  Telefono VARCHAR(10) NULL,
  PRIMARY KEY (idCliente)
);



create table Auto(
  idAuto INT  NOT NULL AUTO_INCREMENT,
  Placa VARCHAR(10) NOT NULL,
  idCliente INT NOT NULL,
  Modelo VARCHAR(4) NOT NULL,
  Marca VARCHAR(150) NOT NULL,
  Tamaño VARCHAR(20) NOT NULL,
  fecha_recibido DATE NOT NULL,
  PRIMARY KEY (idAuto),
  foreign key(idCliente)
  references cliente (idCliente)
  on delete cascade
  on update cascade
  );
  


create table servicio (
  No_Servicio INT auto_increment NOT NULL,
  Descripcion VARCHAR(255) NOT NULL,
  Fecha_Entrega DATE NOT NULL,
  idAuto int not null, 
  IdEmpleado int not null,
  PRIMARY KEY (No_Servicio),
  FOREIGN KEY (idAuto)
    REFERENCES auto (idAuto)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
	FOREIGN KEY (IdEmpleado)
    REFERENCES empleado (IdEmpleado)
    ON DELETE no action
    ON UPDATE no action
    );
    
    
  create table sueldos (
  idSueldos int auto_increment not null,
  idEmpleado int not null,
  horas_Trabajadas int not null,
  Sub_total double not null,
  sueldo_final double not null,
  primary key(idSueldos),
  foreign key (idEmpleado)
  references empleado (idEmpleado)
  on delete cascade
  on update cascade
  );
  

    
    






