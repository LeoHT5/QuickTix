
-- Tabla tb_genero
IF NOT EXISTS (SELECT * FROM sysobjects WHERE NAME = 'tb_genero' AND xtype='U')
  CREATE TABLE tb_genero (genero_id INT PRIMARY KEY, descripcion VARCHAR(255));

-- Tabla tb_duracion
IF NOT EXISTS (SELECT * FROM sysobjects WHERE NAME = 'tb_duracion' AND xtype='U')
  CREATE TABLE tb_duracion (duracion_id INT PRIMARY KEY, descripcion VARCHAR(255));

-- Tabla tb_tamanio
IF NOT EXISTS (SELECT * FROM sysobjects WHERE NAME = 'tb_tamanio' AND xtype='U')
  CREATE TABLE tb_tamanio (tamanio_id INT PRIMARY KEY, descripcion VARCHAR(255));





