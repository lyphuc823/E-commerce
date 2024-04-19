USE laptopdb;

-- Insert mock data for categories
INSERT INTO `categories` (`category_name`) VALUES 
('Laptop'),
('TV & Audio'),
('Smartphone'),
('Camera'),
('Headphone'),
('Smartwatch'),
('Mobile & Tablets'),
('Accessories'),
('Chamcham'),
('Our Door Room');

-- Insert mock data for providers
INSERT INTO `providers` (`provider_name`, `contact_person`, `contact_email`, `contact_phone_number`, `address`, `is_active`) VALUES
('Provider1', 'Contact1', 'contact1@example.com', '123456789', 'Address1', 1),
('Provider2', 'Contact2', 'contact2@example.com', '987654321', 'Address2', 1),
('Provider3', 'Contact3', 'contact3@example.com', '111223344', 'Address3', 1),
('Provider4', 'Contact4', 'contact4@example.com', '555666777', 'Address4', 1),
('Provider5', 'Contact5', 'contact5@example.com', '999000111', 'Address5', 1);

-- Insert mock data for products
INSERT INTO `products` (`product_name`, `description`, `price`, `stock_quantity`, `category_id`, `provider_id`, `brand`, `overall_rating`) VALUES
('Laptop1', 'Description for Laptop1', 999.99, 50, 1, 1, 'Brand1', 4.5),
('Laptop2', 'Description for Laptop2', 1299.99, 30, 1, 2, 'Brand2', 4.2),
('TV1', 'Description for TV1', 799.99, 20, 2, 3, 'Brand3', 3.8),
('TV2', 'Description for TV2', 1499.99, 15, 2, 4, 'Brand4', 4.1),
('Smartphone1', 'Description for Smartphone1', 499.99, 40, 3, 1, 'Brand1', 4.7),
('Smartphone2', 'Description for Smartphone2', 699.99, 25, 3, 2, 'Brand2', 4.0),
('Camera1', 'Description for Camera1', 899.99, 15, 4, 3, 'Brand3', 4.2),
('Camera2', 'Description for Camera2', 1199.99, 10, 4, 4, 'Brand4', 3.9),
('Headphone1', 'Description for Headphone1', 99.99, 50, 5, 1, 'Brand1', 4.8),
('Headphone2', 'Description for Headphone2', 149.99, 30, 5, 2, 'Brand2', 4.3),
('Smartwatch1', 'Description for Smartwatch1', 199.99, 20, 6, 3, 'Brand3', 4.5),
('Smartwatch2', 'Description for Smartwatch2', 299.99, 15, 6, 4, 'Brand4', 4.1),
('Tablet1', 'Description for Tablet1', 299.99, 25, 7, 1, 'Brand1', 3.5),
('Tablet2', 'Description for Tablet2', 449.99, 20, 7, 2, 'Brand2', 3.9),
('Accessory1', 'Description for Accessory1', 19.99, 100, 8, 1, 'Brand1', 4.6),
('Accessory2', 'Description for Accessory2', 29.99, 80, 8, 2, 'Brand2', 4.4);

-- Insert mock data for specifications
INSERT INTO `specifications` (`product_id`, `spec_name`, `spec_value`) VALUES
(1, 'Processor', 'Intel i7'),
(1, 'RAM', '16GB'),
(1, 'Storage', '1TB SSD'),
(2, 'Processor', 'AMD Ryzen 5'),
(2, 'RAM', '8GB'),
(2, 'Storage', '512GB SSD'),
(3, 'Resolution', '1080p'),
(3, 'Screen Size', '55 inches'),
(4, 'Resolution', '4K'),
(4, 'Screen Size', '65 inches'),
(5, 'Processor', 'Snapdragon 865'),
(5, 'RAM', '8GB'),
(5, 'Storage', '256GB'),
(6, 'Processor', 'Apple A14 Bionic'),
(6, 'RAM', '4GB'),
(6, 'Storage', '128GB'),
(7, 'Resolution', '24MP'),
(7, 'Zoom', '10x optical'),
(8, 'Resolution', '20MP'),
(8, 'Zoom', '5x optical'),
(9, 'Type', 'Over-ear'),
(9, 'Wireless', 'Yes'),
(10, 'Type', 'In-ear'),
(10, 'Wireless', 'Yes'),
(11, 'Display Type', 'AMOLED'),
(11, 'Water Resistance', '50m'),
(12, 'Display Type', 'OLED'),
(12, 'Water Resistance', '30m'),
(13, 'Display Size', '10.2 inches'),
(13, 'Battery Life', 'Up to 10 hours'),
(14, 'Display Size', '8 inches'),
(14, 'Battery Life', 'Up to 8 hours'),
(15, 'Compatibility', 'Universal'),
(15, 'Color', 'Black'),
(16, 'Compatibility', 'iOS and Android'),
(16, 'Color', 'White');

-- Insert mock data for roles
INSERT INTO `roles` (`role_name`) VALUES
('Admin'),
('User');


-- Insert mock data for users
INSERT INTO `users` (`email`, `password`, `first_name`, `last_name`, `address`, `phone_number`, `role_id`, `registration_date`,`is_enabled`) VALUES
('admin@example.com', 'admin123', 'Admin', 'User', 'Admin Address', '123456789', 1, '2022-01-01',true),
('manager@example.com', 'user123', 'Manager', 'User', 'manager Address', '987654321', 2, '2022-01-02',true),
('staff@example.com', 'user123', 'Staff', 'User', 'Staff Address', '111223344', 2, '2022-01-03',true),
('user1@example.com', 'user123', 'Regular', 'User1', 'User1 Address', '987654321', 2, '2022-01-04',true),
('user2@example.com', 'user123', 'Regular', 'User2', 'User2 Address', '111223344', 2, '2022-01-05',true),
('user3@example.com', 'user123', 'Regular', 'User3', 'User3 Address', '987654321', 2, '2022-01-06',true),
('user4@example.com', 'user123', 'Regular', 'User4', 'User4 Address', '111223344', 2, '2022-01-07',true),
('user5@example.com', 'user123', 'Regular', 'User5', 'User5 Address', '987654321', 2, '2022-01-08',true),
('user6@example.com', 'user123', 'Regular', 'User6', 'User6 Address', '111223344', 2, '2022-01-09',true);

-- Insert mock data for menus
INSERT INTO `menus` (`menu_name`, `menu_pid`, `menu_path`) VALUES
('Dashboard', NULL, '/dashboard'),
('Products', NULL, '/products'),
('Categories', '/products', '/products/categories'),
('Providers', '/products', '/products/providers'),
('Users', NULL, '/users'),
('Roles', '/users', '/users/roles'),
('Menus', '/users', '/users/menus'),
('Orders', NULL, '/orders'),
('Purchase Orders', '/orders', '/orders/purchase-orders'),
('Comments & Ratings', '/products', '/products/comments-ratings'),
('Specifications', '/products', '/products/specifications'),
('Settings', NULL, '/settings'),
('Account', '/settings', '/settings/account'),
('Security', '/settings', '/settings/security'),
('Logout', NULL, '/logout');

-- Insert mock data for roles_menus
INSERT INTO `roles_menus` (`role_id`, `menu_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(2, 1),
(2, 2),
(2, 3),
(2, 4);
-- Insert mock data for purchase_orders_statuses
INSERT INTO `purchase_order_statuses` (`status_name`, `description`) VALUES
('Pending', 'Purchase order is pending'),
('Processing', 'Purchase order is being processed'),
('Shipped', 'Purchase order has been shipped'),
('Delivered', 'Purchase order has been delivered');

-- Insert mock data for order_statuses
INSERT INTO `order_statuses` (`status_name`, `description`) VALUES
('Pending', 'Order is pending'),
('Processing', 'Order is being processed'),
('Shipped', 'Order has been shipped'),
('Delivered', 'Order has been delivered');

-- Insert mock data for purchase_orders
INSERT INTO `purchase_orders` (`provider_id`, `order_date`, `shipping_address`, `purchase_order_status_id`, `payment_method`, `payment_status`, `total_amount`) VALUES
(1, '2022-01-01', 'Shipping Address 1', 1, 'Credit Card', 'Paid', 1500.00),
(2, '2022-01-02', 'Shipping Address 2', 2, 'PayPal', 'Pending', 2000.00),
(3, '2022-01-03', 'Shipping Address 3', 3, 'Bank Transfer', 'Paid', 1800.00);

-- Insert mock data for purchase_order_details
INSERT INTO `purchase_order_details` (`purchase_order_id`, `product_id`, `quantity`, `unit_price`, `subtotal`) VALUES
(1, 1, 5, 999.99, 4999.95),
(1, 2, 3, 1299.99, 3899.97),
(2, 3, 2, 799.99, 1599.98),
(2, 4, 1, 1499.99, 1499.99),
(3, 5, 4, 499.99, 1999.96),
(3, 6, 2, 699.99, 1399.98);

-- Insert mock data for order
INSERT INTO `orders` (`user_id`, `order_date`, `shipping_address`, `order_status_id`, `payment_method`, `payment_status`, `total_amount`) VALUES
(2, '2022-01-04', 'Shipping Address 4', 1, 'Credit Card', 'Paid', 1200.00),
(3, '2022-01-05', 'Shipping Address 5', 2, 'PayPal', 'Pending', 800.00),
(1, '2022-01-06', 'Shipping Address 6', 3, 'Bank Transfer', 'Paid', 1500.00);

-- Insert mock data for order_details
INSERT INTO `order_details` (`order_id`, `product_id`, `quantity`, `subtotal`, `discount`) VALUES
(1, 7, 1, 899.99, 0.00),
(1, 8, 2, 1199.99, 50.00),
(2, 9, 3, 99.99, 10.00),
(2, 10, 1, 149.99, 0.00),
(3, 11, 2, 199.99, 0.00),
(3, 12, 1, 299.99, 20.00);

-- Insert mock data for comments
INSERT INTO `comments` (`user_id`, `product_id`, `comment_text`, `rating`, `comment_date`) VALUES
(1, 1, 'Great laptop! Fast and reliable.', 5, '2022-01-07'),
(2, 1, 'Good value for the money.', 4, '2022-01-08'),
(3, 2, 'Love the design of this laptop.', 4, '2022-01-09'),
(4, 2, 'Decent performance, but a bit heavy.', 3, '2022-01-10'),
(5, 3, 'Excellent picture quality on this TV.', 5, '2022-01-11'),
(6, 3, 'Sound could be better, but overall satisfied.', 4, '2022-01-12'),
(7, 4, 'Impressive camera features!', 5, '2022-01-13'),
(8, 4, 'Good camera, but a bit pricey.', 4, '2022-01-14'),
(9, 5, 'Amazing sound quality!', 5, '2022-01-15'),
(1, 5, 'Comfortable to wear for long periods.', 4, '2022-01-16'),
(1, 6, 'Sleek design and smooth performance.', 5, '2022-01-17'),
(2, 6, 'Battery life could be better.', 4, '2022-01-18'),
(3, 7, 'High-resolution display and powerful processor.', 5, '2022-01-19'),
(4, 7, 'Great for photography enthusiasts.', 4, '2022-01-20'),
(5, 8, 'Good value for a budget tablet.', 3, '2022-01-21'),
(6, 8, 'Responsive touchscreen, but limited storage.', 3, '2022-01-22'),
(7, 9, 'Excellent build quality and comfortable to wear.', 5, '2022-01-23'),
(8, 9, 'Noise cancellation works well.', 4, '2022-01-24'),
(9, 10, 'Compact and lightweight earbuds.', 5, '2022-01-25'),
(2, 10, 'Wireless connection is stable.', 4, '2022-01-26');

-- Insert mock data for order_statuses
INSERT INTO `order_statuses` (`status_name`, `description`) VALUES
('Pending', 'Order is pending'),
('Processing', 'Order is being processed'),
('Shipped', 'Order has been shipped'),
('Delivered', 'Order has been delivered');

-- Insert mock data for purchase_order_statuses
INSERT INTO `purchase_order_statuses` (`status_name`, `description`) VALUES
('Pending', 'Purchase order is pending'),
('Processing', 'Purchase order is being processed'),
('Shipped', 'Purchase order has been shipped'),
('Delivered', 'Purchase order has been delivered');
