--script del proyecto de taller de desarrollo 2

create database Ferreteria_Bullets;

--cambiar de base de datos

\c ferreteria_bullets

create table Proveedor(
	id_proveedor integer NOT NULL GENERATED ALWAYS AS IDENTITY,
	nombre varchar NOT NULL,
	telefono varchar NOT NULL,
	rfc varchar NOT NULL,
	primary key(id_proveedor)
);

--tabla CompraM

create table CompraM(
	id_compra integer NOT NULL GENERATED ALWAYS AS IDENTITY,
	id_proveedor integer NOT NULL,
	montoCTotal numeric(10,2) NOT NULL constraint montoCTotal_Invalido check(montoCTotal > 0 ),
	fechaCompra date NOT NULL constraint  fechaCompra_invalida check (fechaCompra >= now()),
	primary key(id_compra),
	foreign key(id_proveedor) references Proveedor on delete cascade

);

create table Categoria(
	id_categoria integer GENERATED ALWAYS AS IDENTITY,
	nombre_c varchar NOT NULL,
	descripcion varchar NOT NULL,
	primary key(id_categoria)

);

create table Materiales(
	codigo_barras varchar NOT NULL,
	id_categoria integer NOT NULL,
	nombre varchar NOT NULL,
	precio_venta numeric(10,2) NOT NULL constraint precio_ventaInvalido check(precio_venta > 0 ),
	marca varchar NOT NULL,
	stock integer,
	primary key(codigo_barras),
	foreign key(id_categoria) references Categoria on delete cascade
);

--tabla Detalle_CompraM
create table Detalle_Compra(
	id_compra integer NOT NULL,
	cns_compra integer NOT NULL,
	codigo_barras varchar NOT NULL,
	descripcionDC varchar NOT NULL,
	cantidadDC integer NOT NULL constraint cantidad_invalido check(cantidadDC > 0),
	precioDC numeric(10,2) NOT NULL constraint precioDC_invalido check(precioDC > 0),
	primary key(id_compra, cns_compra),
	foreign key(id_compra) references CompraM on delete cascade,
	foreign key(codigo_barras) references Materiales on delete cascade

);


create table Venta(
	id_venta integer NOT NULL GENERATED ALWAYS AS IDENTITY,
	monto_final numeric(10,2) NOT NULL constraint monto_finalInvalido check (monto_final > 0),
	fecha_venta date NOT NULL constraint  fecha_venta_invalida check (fecha_venta >= now()),
	primary key(id_venta)
);

create table Detalle_Venta(
	cns integer NOT NULL,
	id_venta integer NOT NULL,
	codigo_barras varchar NOT NULL,
	cantidad integer NOT NULL constraint cantidad_invalido check (cantidad > 0),
	precio_VDTV numeric(10,2) NOT NULL constraint precio_VDTV_Invalido check(precio_VDTV > 0 ),
	primary key(id_venta, cns),
	foreign key(codigo_barras) references Materiales on delete cascade

);

create table Usuarios(
	idUsuario varchar NOT NULL, 
	nombreUsu varchar NOT NULL,
	contraUsu varchar NOT NULL,
	primary key (idUsuario)
);

--comanderia SQL necesaria--


--creacion de grupos
create group cajeros;
create group administradores;

--creacion de los usuarios de cada grupo

--grupo cajeros
create user anahi_cajera with password 'cajeraAna' in group cajeros;
create user natalia_cajera with password 'cajeraNati' in group cajeros;
--grupo administradores
create user jeannette_admin with password 'adminJeannette' in group administradores;
create user noe_admin with password 'adminNoe' in group administradores;

--ahora se les otorga los privilegios correspondientes de cada grupo
--PRIVILEGIOS DE LOS CAJEROS
GRANT SELECT ON TABLE Proveedor to group cajeros;
GRANT SELECT ON TABLE CompraM to group cajeros;
GRANT SELECT ON TABLE Categoria to group cajeros;
GRANT SELECT ON TABLE Materiales to group cajeros;
GRANT SELECT ON TABLE Detalle_Compra to group cajeros;
GRANT SELECT, INSERT ON TABLE Venta to group cajeros;
GRANT ALL ON TABLE Detalle_Venta to group cajeros;
--PRIVILEGIOS DE LOS ADMINISTRADORES
GRANT ALL ON TABLE Proveedor to group administradores;
GRANT ALL ON TABLE CompraM to group administradores;
GRANT ALL ON TABLE Categoria to group administradores;
GRANT ALL ON TABLE Materiales to group administradores;
GRANT ALL ON TABLE Detalle_Compra to group administradores;
GRANT ALL ON TABLE Venta to group administradores;
GRANT ALL ON TABLE Detalle_Venta to group administradores;
