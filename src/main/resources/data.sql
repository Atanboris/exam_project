INSERT INTO properties(id, bathroom_amount, bedroom_amount, area_size, parking_spots, price,property_address, property_type,property_image)
values
    (1,2,3,40,8,120300,'Linien 20','APARTMENT','https://foyr.com/learn/wp-content/uploads/2019/03/Villa_Mistral-Singapore.jpg'),
    (2,2,3,40,8,120300,'Linien 20','APARTMENT','https://foyr.com/learn/wp-content/uploads/2019/03/Villa_Mistral-Singapore.jpg'),
    (3,2,3,40,8,120300,'Linien 20','APARTMENT','https://foyr.com/learn/wp-content/uploads/2019/03/Villa_Mistral-Singapore.jpg'),
    (4,2,3,40,8,120300,'Linien 20','APARTMENT','https://foyr.com/learn/wp-content/uploads/2019/03/Villa_Mistral-Singapore.jpg'),
    (5,2,3,40,8,120300,'Linien 20','APARTMENT','https://foyr.com/learn/wp-content/uploads/2019/03/Villa_Mistral-Singapore.jpg'),
    (6,2,3,40,8,120300,'Linien 20','APARTMENT','https://foyr.com/learn/wp-content/uploads/2019/03/Villa_Mistral-Singapore.jpg'),
    (7,2,3,40,8,120300,'Linien 20','APARTMENT','https://foyr.com/learn/wp-content/uploads/2019/03/Villa_Mistral-Singapore.jpg'),
    (8,2,3,40,8,120300,'Linien 20','APARTMENT','https://foyr.com/learn/wp-content/uploads/2019/03/Villa_Mistral-Singapore.jpg'),
    (9,2,3,50,8,120300,'Asphalt 30','PENTHOUSE','https://foyr.com/learn/wp-content/uploads/2019/03/Villa_Mistral-Singapore.jpg');

INSERT INTO users(id, email, name, password)
VALUES
    (1, 'drake@gmail.com', 'Sebora' , '$2a$10$S73sc..tFXm1mrrgVK2wVeiQmJiCyxxUA5a6hhr7I/UGKOuNP.Ita'),
    (2, 'admin@admin.com', 'Armin' , '$2a$10$S73sc..tFXm1mrrgVK2wVeiQmJiCyxxUA5a6hhr7I/UGKOuNP.Ita');


INSERT INTO roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users_roles(user_id, role_id)
VALUES
    (1,2),
    (2,1),
    (2,2);