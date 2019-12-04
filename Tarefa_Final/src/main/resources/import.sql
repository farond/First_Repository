INSERT INTO tb_semana(id_semana,dia_semana) VALUES (1,'Segunda-Feira')
INSERT INTO tb_semana(id_semana,dia_semana) VALUES (2,'Terça-Feira')
INSERT INTO tb_semana(id_semana,dia_semana) VALUES (3,'Quarta-Feira')
INSERT INTO tb_semana(id_semana,dia_semana) VALUES (4,'Quinta-Feira')
INSERT INTO tb_semana(id_semana,dia_semana) VALUES (5,'Sexta-Feira')
INSERT INTO tb_semana(id_semana,dia_semana) VALUES (6,'Sábado')
INSERT INTO tb_semana(id_semana,dia_semana) VALUES (7,'Domingo')

INSERT INTO tb_cidade(cidade_id,nome_cidade,lat_cidade,lon_cidade) VALUES (1,'São Paulo',28.0,-27.0)
INSERT INTO tb_cidade(cidade_id,nome_cidade,lat_cidade,lon_cidade) VALUES (2,'Birigui',65,-54.0)
INSERT INTO tb_cidade(cidade_id,nome_cidade,lat_cidade,lon_cidade) VALUES (3,'Bahia',98.0,-25.0)
INSERT INTO tb_cidade(cidade_id,nome_cidade,lat_cidade,lon_cidade) VALUES (4,'Rio de Janeiro',78.0,-45.0)
INSERT INTO tb_cidade(cidade_id,nome_cidade,lat_cidade,lon_cidade) VALUES (5,'Minas Gerais',36.0,-54.0)
INSERT INTO tb_cidade(cidade_id,nome_cidade,lat_cidade,lon_cidade) VALUES (6,'São Mateus',15.0,-57.0)
INSERT INTO tb_cidade(cidade_id,nome_cidade,lat_cidade,lon_cidade) VALUES (7,'Rio Grande Do Sul',38.0,-17.0)

insert into tb_tempo (tempo_id,cidade_id,id_semana,tempmin_tempo,tempmax_tempo,humidade_tempo,datahora_tempo,desc_tempo, icon_name) values (1,1,1,21.4,27.2,56,now(),'', '01d');
insert into tb_tempo (tempo_id,cidade_id,id_semana,tempmin_tempo,tempmax_tempo,humidade_tempo,datahora_tempo,desc_tempo, icon_name) values (2,2,2,21.4,27.2,56,now(),'', '01d');
insert into tb_tempo (tempo_id,cidade_id,id_semana,tempmin_tempo,tempmax_tempo,humidade_tempo,datahora_tempo,desc_tempo, icon_name) values (3,3,3,20.6,27.8,0,now(),'', '01d');
insert into tb_tempo (tempo_id,cidade_id,id_semana,tempmin_tempo,tempmax_tempo,humidade_tempo,datahora_tempo,desc_tempo, icon_name) values (4,4,4,20.8,27.8,34,now(),'', '01d');
insert into tb_tempo (tempo_id,cidade_id,id_semana,tempmin_tempo,tempmax_tempo,humidade_tempo,datahora_tempo,desc_tempo, icon_name) values (5,5,5,20.1,27.7,56,now(),'', '01d');
insert into tb_tempo (tempo_id,cidade_id,id_semana,tempmin_tempo,tempmax_tempo,humidade_tempo,datahora_tempo,desc_tempo, icon_name) values (6,6,6,20.4,25.5,24,now(),'', '01d');
insert into tb_tempo (tempo_id,cidade_id,id_semana,tempmin_tempo,tempmax_tempo,humidade_tempo,datahora_tempo,desc_tempo, icon_name) values (7,7,7,22.3,27.2,56,now(),'', '01d');



insert into usuario (id, login, senha) values (1, 'admin', 'admin')
