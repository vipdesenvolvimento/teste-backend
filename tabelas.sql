CREATE TABLE `lead` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `sobrenome` varchar(150) NOT NULL,
  `data_nascimento` date NOT NULL,
  `telefone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `lead`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `lead`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
