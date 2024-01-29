
IF NOT EXISTS
    (SELECT 1 FROM tb_genero WHERE genero_id = 1 AND descripcion = 'Rock')
    BEGIN
        INSERT tb_genero (genero_id, descripcion) VALUES (1, 'Rock')
    END;

IF NOT EXISTS
    (SELECT 1 FROM tb_genero WHERE genero_id = 2 AND descripcion = 'Pop')
    BEGIN
        INSERT tb_genero (genero_id, descripcion) VALUES (2, 'Pop')
    END;   

IF NOT EXISTS (SELECT 1 FROM tb_genero WHERE genero_id = 3 AND descripcion = 'Electrónica')
BEGIN
    INSERT tb_genero (genero_id, descripcion) VALUES (3, 'Electrónica')
END;

IF NOT EXISTS (SELECT 1 FROM tb_genero WHERE genero_id = 4 AND descripcion = 'Reggueton')
BEGIN
    INSERT  tb_genero (genero_id, descripcion) VALUES (4, 'Reggueton')
END;

IF NOT EXISTS (SELECT 1 FROM tb_genero WHERE genero_id = 5 AND descripcion = 'Cumbia')
BEGIN
    INSERT  tb_genero (genero_id, descripcion) VALUES (5, 'Cumbia')
END;

-- Duraciones
IF NOT EXISTS (SELECT 1 FROM tb_duracion WHERE duracion_id = 1 AND descripcion = 'Horas')
BEGIN
    INSERT  tb_duracion (duracion_id, descripcion) VALUES (1, 'Horas')
END;

IF NOT EXISTS (SELECT 1 FROM tb_duracion WHERE duracion_id = 2 AND descripcion = 'Dias')
BEGIN
    INSERT  tb_duracion (duracion_id, descripcion) VALUES (2, 'Dias')
END;

IF NOT EXISTS (SELECT 1 FROM tb_duracion WHERE duracion_id = 3 AND descripcion = 'Semanas')
BEGIN
    INSERT  tb_duracion (duracion_id, descripcion) VALUES (3, 'Semanas')
END;

-- Tamaños
IF NOT EXISTS (SELECT 1 FROM tb_tamanio WHERE tamanio_id = 1 AND descripcion = 'Estadio')
BEGIN
    INSERT  tb_tamanio (tamanio_id, descripcion) VALUES (1, 'Estadio')
END;

IF NOT EXISTS (SELECT 1 FROM tb_tamanio WHERE tamanio_id = 2 AND descripcion = 'Arena')
BEGIN
    INSERT  tb_tamanio (tamanio_id, descripcion) VALUES (2, 'Arena')
END;

IF NOT EXISTS (SELECT 1 FROM tb_tamanio WHERE tamanio_id = 3 AND descripcion = 'Club')
BEGIN
    INSERT  tb_tamanio (tamanio_id, descripcion) VALUES (3, 'Club')
END;

--Usuario(para ingresar en modo administrador: admin@gmail.com, 123)
-- INSERT INTO tb_usuario ( id, apellido, correo, nombre, clave, role, telefono)
-- VALUES ( 1, 'Admin', 'admin@gmail.com', 'Admin','123', 'ADMIN', '963258741');

-- IF NOT EXISTS (SELECT * FROM tb_usuario WHERE correo = 'admin@gmail.com')
-- BEGIN
--     INSERT INTO tb_usuario (apellido, correo, nombre, clave, role, telefono)
--     VALUES ('Admin', 'admin@gmail.com', 'Admin', '123', 'ADMIN', '963258741');
-- END;


