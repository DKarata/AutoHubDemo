-- admin user
INSERT INTO app_user (id, email, first_name, last_name, image_url, active, password)
VALUES ('c412b760-2892-4eaf-bb9c-a005d20dcd2a', 'admin@admin.com', 'Admin', 'Adminov', null, 1, '$2a$10$SWIztf0mHW22g246lc9IvOC9lNP/9riyJKUcAcjG7/qmDbCohkWZG');

-- roles
INSERT INTO app_user_roles (id, role)
VALUES ('4324c37d-e85f-4b91-aec4-d1e79502b550', 'ADMIN'),
       ('78f82419-041f-4f31-83ff-c03880d8cbf6', 'MODERATOR'),
       ('6f3b8056-7a39-43e3-948c-8ff6673ebe20', 'USER');

INSERT INTO app_user_app_user_roles(user_id, role_id)
VALUES ('c412b760-2892-4eaf-bb9c-a005d20dcd2a', '4324c37d-e85f-4b91-aec4-d1e79502b550'),
       ('c412b760-2892-4eaf-bb9c-a005d20dcd2a', '78f82419-041f-4f31-83ff-c03880d8cbf6'),
       ('c412b760-2892-4eaf-bb9c-a005d20dcd2a', '6f3b8056-7a39-43e3-948c-8ff6673ebe20');

-- some brands
INSERT INTO brand (id,  brand_name)
VALUES ('72317470-ed37-48ae-9973-d8ccdc35f756', 'Ford'),
       ('e03f2756-34d4-4690-ae1b-7613ad7aac07', 'Toyota'),
       ('1', 'Alfa Romeo'),
       ('2', 'Fiat');

-- some models
INSERT INTO model (id, category, end_year, image_url, model_name, start_year, brand_id)
VALUES ('404b5067-0f46-4705-af3e-03b39cecea06', 'CAR', 2020, 'https://upload.wikimedia.org/wikipedia/commons/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg', 'Focus', 1990, '72317470-ed37-48ae-9973-d8ccdc35f756'),
       ('95e55547-58af-4106-b948-d328aa18e7ce', 'CAR', 2010, 'https://upload.wikimedia.org/wikipedia/commons/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg', 'Fiesta', 1980, '72317470-ed37-48ae-9973-d8ccdc35f756'),
       ('04c9a180-7edb-4449-8ad4-f3d413e1b86d', 'CAR', 2020, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-dAL9ga3CKkrrt71fIT-Iznf5Y9W8TiCQFQy8NBW2Fg&s', 'Corolla', 1990, 'e03f2756-34d4-4690-ae1b-7613ad7aac07'),
       ('9f436e8c-e2c1-4002-b845-3218898af460', 'CAR', 2015, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-dAL9ga3CKkrrt71fIT-Iznf5Y9W8TiCQFQy8NBW2Fg&s', 'Yaris', 1995, 'e03f2756-34d4-4690-ae1b-7613ad7aac07'),
       ('1A159', 'CAR', 2012, 'https://storage.carspending.com/cache/vehicles/e4a602f1-75d8-4eff-9191-c2c6cb44fc4b/5ec633a6be6d6.jpg?w=1536&h=1536&fit=max&s=b610d4ff4639c2b26aa0251fe385779b', '159', 2004, '1'),
       ('1A147', 'CAR', 2010, 'https://images.ams.bg/images/galleries/105549/alfa-romeo-147-1460760957_big.jpg', '147', 2002, '1'),
       ('2FBo', 'CAR', 2012, 'https://www.auto-data.net/images/f91/Fiat-Bravo-II.jpg', 'Bravo', 2005, '2'),
       ('2FBa', 'CAR', 2002, 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Fiat_Brava_1.6_ELX_front.JPG/1200px-Fiat_Brava_1.6_ELX_front.JPG', 'Brava', 1997, '2');

-- offers
INSERT INTO offer (id,  description, engine, image_url, mileage, price, transmission, manufactured, model_id, user_id)
VALUES ('bc379d6d-0803-4cec-9c65-781266ef4865', 'Sample description 1', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('07b407c2-19b0-400f-bd9d-6cdad6522afb', 'Sample description 2', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('c3acd0ef-8ce4-4235-91ff-bfae728a9e69', 'Sample description 3', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('77e20d5e-236d-4837-9e8d-87d94eccaf07', 'Sample description 4', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'AUTOMATIC', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('8a4c918d-9a59-4bd4-9ab3-07258c7bb982', 'Sample description 5', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('972ef19c-541c-4f30-bb66-7aa01fd2ce9b', 'Sample description 6', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('a3129d4c-e01a-42db-87aa-1487fea2e6c8', 'Sample description 7', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('11e66199-1ffb-4486-9235-b3816b2a59a1', 'Sample description 8', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('30d99f80-b799-4723-b33e-09194e44c5e0', 'Sample description 9', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('e44297fa-e35f-4843-a594-2a91c9c1712d', 'Sample description 10', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('64a36015-ccee-4fc6-bf20-66d10ee6cd7c', 'Sample description 11', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('3068c316-6fe3-4e3b-8058-e9f0c41b97ca', 'Sample description 12', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a'),
       ('224cd8d9-6d14-4fc3-986f-44264c10ca39', 'Sample description 13', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/280px-2018_Ford_Focus_ST-Line_X_1.0.jpg', 1000, 1000, 'MANUAL', '2023-01-1', '404b5067-0f46-4705-af3e-03b39cecea06', 'c412b760-2892-4eaf-bb9c-a005d20dcd2a');
