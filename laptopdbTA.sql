-- Create database if not exists
CREATE DATABASE IF NOT EXISTS `laptopdb`;
USE `laptopdb`;
SET FOREIGN_KEY_CHECKS = 0;

-- Create Roles table
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
    `role_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `role_name` VARCHAR(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create Roles_Menus table
DROP TABLE IF EXISTS `roles_menus`;
CREATE TABLE `roles_menus` (
    `role_id` INT NOT NULL,
    `menu_id` INT NOT NULL,
    CONSTRAINT `fk_role_roles_menus` FOREIGN KEY (`role_id`) REFERENCES `roles`(`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_menu_roles_menus` FOREIGN KEY (`menu_id`) REFERENCES `menus`(`menu_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `pk_roles_menus` PRIMARY KEY (`role_id`, `menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create Users_Roles table
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
    `role_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    CONSTRAINT `fk_role_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles`(`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_user_users_roles` FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `pk_roles_users` PRIMARY KEY (`role_id`, `user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create Users table
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `user_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email` VARCHAR(255) DEFAULT NULL,
    `password` VARCHAR(255) DEFAULT NULL,
    `first_name` VARCHAR(255) DEFAULT NULL,
    `last_name` VARCHAR(255) DEFAULT NULL,
    `address` TEXT DEFAULT NULL,
    `phone_number` VARCHAR(20) DEFAULT NULL,
    `registration_date` DATE DEFAULT NULL,
    `is_enabled` boolean default false
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create Menus table
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
    `menu_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `menu_name` VARCHAR(255) DEFAULT NULL,
    `menu_pid` VARCHAR(255) DEFAULT NULL,
    `menu_path` VARCHAR(255) DEFAULT NULL
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;

-- Create Categories table
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
    `category_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `category_name` VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create Providers table
DROP TABLE IF EXISTS `providers`;
CREATE TABLE `providers` (
    `provider_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `provider_name` VARCHAR(255) DEFAULT NULL,
    `contact_person` VARCHAR(255) DEFAULT NULL,
    `contact_email` VARCHAR(255) DEFAULT NULL,
    `contact_phone_number` VARCHAR(20) DEFAULT NULL,
    `address` TEXT DEFAULT NULL,
    `is_active` BOOLEAN DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create Products table
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
    `product_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `product_name` VARCHAR(255) DEFAULT NULL,
    `description` TEXT DEFAULT NULL,
    `price` DECIMAL(10, 2) DEFAULT NULL,
    `stock_quantity` INT DEFAULT NULL,
    `category_id` INT DEFAULT NULL,
    `provider_id` INT DEFAULT NULL,
    `brand` VARCHAR(50) DEFAULT NULL,
    `overall_rating` DECIMAL(3, 2) DEFAULT NULL,
    CONSTRAINT `fk_category_products` FOREIGN KEY (`category_id`) REFERENCES `categories`(`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_provider_products` FOREIGN KEY (`provider_id`) REFERENCES `providers`(`provider_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create specifications table
DROP TABLE IF EXISTS `specifications`;
CREATE TABLE `specifications` (
    `spec_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `product_id` INT NOT NULL,
    `spec_name` varchar(50) default null,
    `spec_value` varchar(255) default null, 
    CONSTRAINT `fk_product_specifications` FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create CommentsAndRatings table
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
    `comment_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT DEFAULT NULL,
    `product_id` INT NOT NULL,
    `comment_text` TEXT DEFAULT NULL,
    `rating` INT NOT NULL,
    `comment_date` DATE DEFAULT NULL,
    CONSTRAINT `fk_user_comments` FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_product_comments` FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create ProductImages table
DROP TABLE IF EXISTS `product_images`;
CREATE TABLE `product_images` (
    `image_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `product_id` INT DEFAULT NULL,
    `image_url` VARCHAR(255) DEFAULT NULL,
    `is_primary` BOOLEAN DEFAULT NULL,
    CONSTRAINT `fk_product_product_images` FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create Orders table
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
    `order_id` INT NOT NULL auto_increment,
    `user_id` INT DEFAULT NULL,
    `order_date` DATE NOT NULL,
    `shipping_address` TEXT DEFAULT NULL,
    `order_status_id` INT DEFAULT NULL,
    `payment_method` VARCHAR(50) DEFAULT NULL,
    `payment_status` VARCHAR(50) DEFAULT NULL,
    `total_amount` DECIMAL(10, 2) DEFAULT NULL,
    CONSTRAINT `fk_user_orders` FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_order_status_orders` FOREIGN KEY (`order_status_id`) REFERENCES `order_statuses`(`order_status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `pk_order` PRIMARY KEY (`order_id`, `order_date`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create OrderDetails table
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
    `order_detail_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `order_id` INT DEFAULT NULL,
    `product_id` INT DEFAULT NULL,
    `quantity` INT DEFAULT NULL,
    `subtotal` DECIMAL(10, 2) DEFAULT NULL,
    `discount` DECIMAL(5, 2) DEFAULT NULL,
    CONSTRAINT `fk_order_order_details` FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_product_order_details` FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create PurchaseOrders table
DROP TABLE IF EXISTS `purchase_orders`;
CREATE TABLE `purchase_orders` (
    `purchase_order_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `provider_id` INT DEFAULT NULL,
    `order_date` DATE DEFAULT NULL,
    `shipping_address` TEXT DEFAULT NULL,
    `purchase_order_status_id` INT DEFAULT NULL,
    `payment_method` VARCHAR(50) DEFAULT NULL,
    `payment_status` VARCHAR(50) DEFAULT NULL,
    `total_amount` DECIMAL(10, 2) DEFAULT NULL,
    CONSTRAINT `fk_provider_purchase_orders` FOREIGN KEY (`provider_id`) REFERENCES `providers`(`provider_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_purchase_order_status_purchase_orders` FOREIGN KEY (`purchase_order_status_id`) REFERENCES `purchase_order_statuses`(`purchase_order_status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create PurchaseOrderDetails table
DROP TABLE IF EXISTS `purchase_order_details`;
CREATE TABLE `purchase_order_details` (
    `purchase_order_detail_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `purchase_order_id` INT DEFAULT NULL,
    `product_id` INT DEFAULT NULL,
    `quantity` INT DEFAULT NULL,
    `unit_price` DECIMAL(10, 2) DEFAULT NULL,
    `subtotal` DECIMAL(10, 2) DEFAULT NULL,
    CONSTRAINT `fk_purchase_order_purchase_order_details` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_orders`(`purchase_order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_product_purchase_order_details` FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create OrderStatuses table
DROP TABLE IF EXISTS `order_statuses`;
CREATE TABLE `order_statuses` (
    `order_status_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `status_name` VARCHAR(50) DEFAULT NULL,
    `description` TEXT DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Create PurchaseOrderStatuses table
DROP TABLE IF EXISTS `purchase_order_statuses`;
CREATE TABLE `purchase_order_statuses` (
    `purchase_order_status_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `status_name` VARCHAR(50) DEFAULT NULL,
    `description` TEXT DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
