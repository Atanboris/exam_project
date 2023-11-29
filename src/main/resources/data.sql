INSERT INTO properties(id, bathroom_amount, bedroom_amount, area_size, floor, parking_spots, price,property_address, property_type)
values
    (1,2,3,40,5,8,120300,'Linien 20','APARTMENT'),
    (2,2,3,50,5,8,120300,'Asphalt 30','PENTHOUSE');

INSERT INTO users(id, email, name, password)
VALUES
    (1, 'derongo@abs.lol', 'Sebora' , '1234'),
    (2, 'sabolo@raks.bg', 'Armin' , '1234');

INSERT INTO roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users_roles(user_id, role_id)
VALUES
    (1,2),
    (2,1),
    (2,2);