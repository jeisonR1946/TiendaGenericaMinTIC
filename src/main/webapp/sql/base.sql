create database tienda_generica;

use tienda_generica;

create table clientes ( 
cedula_cliente bigint(20) primary key,
direccion_cliente varchar (255),
email_cliente varchar (255),
nombre_cliente varchar (255),
telefono_cliente varchar (255)
);

create table usuarios (
cedula_usuario bigint(20) primary key,
email_usuario varchar (255),
nombre_usuario varchar (255),
pass varchar (255),
usuario varchar (255)
);



create table venta (
codigo_venta  bigint(20) primary key,
cedula_cliente bigint(20) not null,
cedula_usuario bigint(20) not null,
iva_venta double not null,
total_venta double not null,
valor_venta double not null
);

alter table venta add foreign key (cedula_cliente) references clientes(cedula_cliente);
alter table venta add foreign key (cedula_usuario) references usuarios(cedula_usuario);


create table proveedores (
nit_proveedor bigint(20) primary key,
ciudad_proveedor varchar (255),
direccion_proveedor varchar (255),
nombre_proveedor varchar (255),
telefono_proveedor varchar (255)
);


create table productos  (
codigo_producto bigint(20)primary key,
iva_compra double not null,
nit_proveedor bigint(20) not null,
nombre_producto varchar (255),
precio_compra double not null,
precio_venta double not null,
foreign key (nit_proveedor) references proveedores(nit_proveedor)
);


create table detalle_ventas (
codigo_detalle_venta bigint(20) primary key,
cantidad_producto int(11) not null,
codigo_producto bigint(20) not null,
codigo_venta bigint(20) not null,
valor_total double not null,
valor_renta double not null,
valor_iva double not null,
foreign key (codigo_producto) references productos(codigo_producto),
foreign key (codigo_venta) references venta(codigo_venta)
);

