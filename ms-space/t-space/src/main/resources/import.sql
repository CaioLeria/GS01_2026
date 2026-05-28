INSERT INTO tb_viagem (destino, empresa, descricao, capacidade_maxima) VALUES ('Lua', 'SpaceX', 'Experiencia orbital ao redor da Lua', 8);

INSERT INTO tb_viagem (destino, empresa, descricao, capacidade_maxima) VALUES ('Orbita Terrestre', 'Blue Origin', 'Vista panoramica da Terra', 12);

INSERT INTO tb_viagem (destino, empresa, descricao, capacidade_maxima) VALUES ('Marte', 'NASA Tourism', 'Missao experimental para Marte', 6);

INSERT INTO tb_viagem (destino, empresa, descricao, capacidade_maxima) VALUES ('Estacao Espacial', 'Virgin Galactic', 'Visita a estacao espacial', 10);


INSERT INTO tb_passageiro (nome, data_nascimento, passaporte, data_cadastro, nacionalidade) VALUES ('Bruno Hideki', DATE '2004-06-10', 'BR12345', DATE '2026-05-01', 'Brasileiro');

INSERT INTO tb_passageiro (nome, data_nascimento, passaporte, data_cadastro, nacionalidade) VALUES ('Ana Costa', DATE '1996-03-22', 'PT56789', DATE '2026-05-03', 'Portuguesa');

INSERT INTO tb_passageiro (nome, data_nascimento, passaporte, data_cadastro, nacionalidade) VALUES ('John Smith', DATE '1985-11-14', 'US99887', DATE '2026-05-05', 'Americano');

INSERT INTO tb_passageiro (nome, data_nascimento, passaporte, data_cadastro, nacionalidade) VALUES ('Yuki Tanaka', DATE '1998-08-30', 'JP44556', DATE '2026-05-06', 'Japonesa');


INSERT INTO tb_viagem_passageiro (data_partida, preco, duracao_dias, status_viagem, viagem_id, passageiro_id) VALUES (DATE '2027-01-10', 850000.00, 7, 'AGENDADA', 1, 1);

INSERT INTO tb_viagem_passageiro (data_partida, preco, duracao_dias, status_viagem, viagem_id, passageiro_id) VALUES (DATE '2027-03-15', 450000.00, 3, 'AGENDADA', 2, 2);

INSERT INTO tb_viagem_passageiro (data_partida, preco, duracao_dias, status_viagem, viagem_id, passageiro_id) VALUES (DATE '2027-06-20', 2500000.00, 30, 'EM_ANDAMENTO', 3, 3);

INSERT INTO tb_viagem_passageiro (data_partida, preco, duracao_dias, status_viagem, viagem_id, passageiro_id) VALUES (DATE '2027-08-05', 650000.00, 5, 'CONCLUIDA', 4, 4);
