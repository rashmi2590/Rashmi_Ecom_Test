CREATE SCHEMA `product_db` ;


CREATE TABLE `product_db`.`product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(200) NULL,
  `price` DOUBLE NULL,
  `image_url` VARCHAR(250) NULL,
  PRIMARY KEY (`id`));
  

CREATE SCHEMA `order_db` ;

CREATE TABLE `order_db`.`orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(100) NOT NULL,
  `order_date` DATE NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `order_db`.`order_products` (
  `order_id` BIGINT NOT NULL,
  `products` BIGINT NOT NULL,
  INDEX `fk_order_id` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_products_1`
    FOREIGN KEY (`order_id`)
    REFERENCES `order_db`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

  
  INSERT INTO `product_db`.`product`
(
`name`,
`description`,
`price`,
`image_url`)
VALUES
(
"LG",
"TV",
1000,
"http://exmple.com");



