-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.35-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sgdga
--

CREATE DATABASE IF NOT EXISTS sgdga;
USE sgdga;

--
-- Definition of table `acesso`
--

DROP TABLE IF EXISTS `acesso`;
CREATE TABLE `acesso` (
  `ace_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ace_login` varchar(10) NOT NULL,
  `ace_senha` varchar(15) NOT NULL,
  `ace_nivel` int(2) unsigned NOT NULL,
  PRIMARY KEY (`ace_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acesso`
--

/*!40000 ALTER TABLE `acesso` DISABLE KEYS */;
INSERT INTO `acesso` (`ace_id`,`ace_login`,`ace_senha`,`ace_nivel`) VALUES 
 (1,'admin','123',2),
 (2,'user','123',1);
/*!40000 ALTER TABLE `acesso` ENABLE KEYS */;


--
-- Definition of table `cad_cidade`
--

DROP TABLE IF EXISTS `cad_cidade`;
CREATE TABLE `cad_cidade` (
  `cid_id` int(11) NOT NULL AUTO_INCREMENT,
  `cid_nome` varchar(30) NOT NULL,
  `cid_uf` varchar(2) NOT NULL,
  PRIMARY KEY (`cid_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cad_cidade`
--

/*!40000 ALTER TABLE `cad_cidade` DISABLE KEYS */;
INSERT INTO `cad_cidade` (`cid_id`,`cid_nome`,`cid_uf`) VALUES 
 (4,'Ibaté','SP'),
 (5,'São Carlos','SP');
/*!40000 ALTER TABLE `cad_cidade` ENABLE KEYS */;


--
-- Definition of table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `cli_id` int(11) NOT NULL AUTO_INCREMENT,
  `cli_nome` varchar(20) NOT NULL,
  `cli_sobrenome` varchar(20) DEFAULT NULL,
  `cli_cpf_cnpj` varchar(18) NOT NULL,
  `cli_rua` varchar(30) DEFAULT NULL,
  `cli_numero` varchar(6) DEFAULT NULL,
  `cli_bairro` varchar(25) DEFAULT NULL,
  `cli_cidade` int(11) NOT NULL,
  `cli_cep` varchar(9) DEFAULT NULL,
  `cli_grupos` int(11) DEFAULT NULL,
  `cli_telefone_fixo` varchar(13) DEFAULT NULL,
  `cli_cel` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`cli_id`),
  KEY `cli_cidade` (`cli_cidade`),
  KEY `cli_grupos` (`cli_grupos`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`cli_cidade`) REFERENCES `cad_cidade` (`cid_id`),
  CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`cli_grupos`) REFERENCES `grupo` (`grup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`cli_id`,`cli_nome`,`cli_sobrenome`,`cli_cpf_cnpj`,`cli_rua`,`cli_numero`,`cli_bairro`,`cli_cidade`,`cli_cep`,`cli_grupos`,`cli_telefone_fixo`,`cli_cel`) VALUES 
 (2,'Amauri','Oliveira','655.383.717-19','qwe','213','jkhg',4,'14815-000',1,'(99)9999-9999','(99)99999-9999');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE `fornecedor` (
  `for_id` int(11) NOT NULL AUTO_INCREMENT,
  `for_nome` varchar(25) NOT NULL,
  `for_descricao` varchar(50) DEFAULT NULL,
  `for_cnpj` varchar(18) NOT NULL,
  `for_endereco` varchar(60) DEFAULT NULL,
  `for_cidade` int(11) NOT NULL,
  `for_cep` varchar(9) DEFAULT NULL,
  `for_email` varchar(25) DEFAULT NULL,
  `for_telefone` varchar(13) DEFAULT NULL,
  `for_site` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`for_id`),
  KEY `for_cidade` (`for_cidade`),
  CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`for_cidade`) REFERENCES `cad_cidade` (`cid_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fornecedor`
--

/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` (`for_id`,`for_nome`,`for_descricao`,`for_cnpj`,`for_endereco`,`for_cidade`,`for_cep`,`for_email`,`for_telefone`,`for_site`) VALUES 
 (3,'A','11111111111','57.611.000/0001-45','11111111111111',4,'11111-111','1111111','(11)1111-1111','asdf'),
 (4,'utra','444444444444','11.111.111/1111-11','4444444444444',4,'44444-444','fghh','(77)7777-7777','dd');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;


--
-- Definition of table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `func_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `func_nome` varchar(25) NOT NULL,
  `func_cpf` varchar(15) NOT NULL,
  `func_endereco` varchar(45) DEFAULT NULL,
  `func_data_admi` date DEFAULT NULL,
  `func_telefone_fixo` varchar(13) DEFAULT NULL,
  `func_celular` varchar(14) DEFAULT NULL,
  `func_funcao` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`func_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`func_id`,`func_nome`,`func_cpf`,`func_endereco`,`func_data_admi`,`func_telefone_fixo`,`func_celular`,`func_funcao`) VALUES 
 (1,'11111','012.345.678-90','11111111','1879-12-12','(11)1111-1111','(11)11111-1111','11111111');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


--
-- Definition of table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
CREATE TABLE `grupo` (
  `grup_id` int(11) NOT NULL AUTO_INCREMENT,
  `grup_nome` varchar(15) NOT NULL,
  `grup_desc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`grup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grupo`
--

/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` (`grup_id`,`grup_nome`,`grup_desc`) VALUES 
 (1,'Normal','Comum'),
 (2,'VIP','Desconto de 20%');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;


--
-- Definition of table `items_nota`
--

DROP TABLE IF EXISTS `items_nota`;
CREATE TABLE `items_nota` (
  `itm_Id` int(11) NOT NULL AUTO_INCREMENT,
  `itm_nota_fiscal` int(11) NOT NULL,
  `itm_produto` int(11) NOT NULL,
  `itm_qtd` int(11) NOT NULL,
  `itm_valor_und` double(15,2) NOT NULL DEFAULT '0.00',
  `itm_subtotal` double(15,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`itm_Id`),
  KEY `itm_nota_fiscal` (`itm_nota_fiscal`),
  KEY `itm_produto` (`itm_produto`),
  CONSTRAINT `items_nota_ibfk_1` FOREIGN KEY (`itm_nota_fiscal`) REFERENCES `nota` (`nota_id`),
  CONSTRAINT `items_nota_ibfk_2` FOREIGN KEY (`itm_produto`) REFERENCES `produtos` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items_nota`
--

/*!40000 ALTER TABLE `items_nota` DISABLE KEYS */;
INSERT INTO `items_nota` (`itm_Id`,`itm_nota_fiscal`,`itm_produto`,`itm_qtd`,`itm_valor_und`,`itm_subtotal`) VALUES 
 (1,7,3,2,125.00,250.00),
 (2,8,3,1,125.00,125.00),
 (3,9,3,7,125.00,875.00),
 (4,9,3,7,125.00,875.00),
 (5,9,3,7,125.00,875.00);
/*!40000 ALTER TABLE `items_nota` ENABLE KEYS */;


--
-- Definition of table `nota`
--

DROP TABLE IF EXISTS `nota`;
CREATE TABLE `nota` (
  `nota_id` int(11) NOT NULL AUTO_INCREMENT,
  `nota_hora` time NOT NULL,
  `nota_data` date NOT NULL,
  `nota_cliente` int(11) NOT NULL,
  `nota_tipo_pag` int(11) NOT NULL,
  `nota_vlr_total` double(12,2) NOT NULL DEFAULT '0.00',
  `nota_desconto` double(15,2) DEFAULT '0.00',
  `nota_final` double(15,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`nota_id`),
  KEY `nota_cliente` (`nota_cliente`),
  KEY `nota_tipo_pag` (`nota_tipo_pag`),
  CONSTRAINT `nota_ibfk_1` FOREIGN KEY (`nota_cliente`) REFERENCES `cliente` (`cli_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nota`
--

/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` (`nota_id`,`nota_hora`,`nota_data`,`nota_cliente`,`nota_tipo_pag`,`nota_vlr_total`,`nota_desconto`,`nota_final`) VALUES 
 (2,'18:45:14','2014-05-31',2,1,1.00,1.00,1.00),
 (3,'18:46:47','2014-05-31',2,1,44.00,44.00,44.00),
 (4,'18:59:57','2014-05-31',2,1,374.00,374.00,374.00),
 (5,'19:37:42','2014-05-31',2,1,125.00,125.00,125.00),
 (6,'19:38:50','2014-05-31',2,1,125.00,125.00,125.00),
 (7,'19:39:54','2014-05-31',2,1,250.00,250.00,250.00),
 (8,'19:50:35','2014-05-31',2,1,125.00,125.00,125.00),
 (9,'20:28:40','2014-05-31',2,1,2.62,1.00,2.62);
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;


--
-- Definition of table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
CREATE TABLE `produtos` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_nome` varchar(25) NOT NULL,
  `pro_fornecedor` int(11) NOT NULL,
  `pro_pr_custo` double(15,2) NOT NULL DEFAULT '0.00',
  `pro_pr_final` double(15,2) NOT NULL DEFAULT '0.00',
  `pro_estoque` int(11) NOT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `pro_fornecedor` (`pro_fornecedor`),
  CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`pro_fornecedor`) REFERENCES `fornecedor` (`for_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produtos`
--

/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` (`pro_id`,`pro_nome`,`pro_fornecedor`,`pro_pr_custo`,`pro_pr_final`,`pro_estoque`) VALUES 
 (3,'ASg',3,122.00,125.00,5);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;


--
-- Definition of table `tipo_pagamento`
--

DROP TABLE IF EXISTS `tipo_pagamento`;
CREATE TABLE `tipo_pagamento` (
  `pag_id` int(11) NOT NULL AUTO_INCREMENT,
  `pag_nome` varchar(30) NOT NULL,
  PRIMARY KEY (`pag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_pagamento`
--

/*!40000 ALTER TABLE `tipo_pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_pagamento` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
