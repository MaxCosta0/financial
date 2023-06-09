INSERT INTO customer(id, name, email, photo_token)
VALUES('694c9781-f7e8-44cc-b19a-80c4450f5303', 'Maxley', 'maxley.costa@mail.com.br', null),
      ('c7bd3b2b-3db9-4716-9952-d573ff0b5553', 'Marcia', 'marcia.soares@mail.com.br', null),
      ('83010a10-2b00-46cd-be64-ec2c0780f087', 'Alirio', 'alirio.costa@mail.com.br', null);

INSERT INTO expense(id, customer_id, amount, start_date, end_date, expense_type)
VALUES ('4704a10a-0905-4958-974c-bea757e70d1b', '694c9781-f7e8-44cc-b19a-80c4450f5303', 120, '2023-04-06', '2023-07-06', 'ENTERTAINMENT'),
       ('3250c33e-188f-4b6d-82f0-30db65d3f79f', '694c9781-f7e8-44cc-b19a-80c4450f5303', 10, '2023-04-06', null, 'FOOD'),
       ('f202c9f3-3055-4ca5-8f45-d3beaf5265e2', '694c9781-f7e8-44cc-b19a-80c4450f5303', 100, '2023-04-01', null, 'CLOTHING'),
       ('ad88982d-72d3-4efb-8805-c1b92f721d9f', 'c7bd3b2b-3db9-4716-9952-d573ff0b5553', 200, '2023-04-03', '2023-08-03', 'CLOTHING'),
       ('1abb4880-77dd-4dac-9a08-0cb44af0beb5', 'c7bd3b2b-3db9-4716-9952-d573ff0b5553', 20, '2023-04-03', null, 'FOOD'),
       ('d61dfa25-8b82-47b7-acdd-598ae8e2ec2c', '83010a10-2b00-46cd-be64-ec2c0780f087', 800, '2023-04-10', null, 'HOUSING'),
       ('500eb275-6ee0-4834-9ee2-9287cdcf7b30', '83010a10-2b00-46cd-be64-ec2c0780f087', 70, '2023-04-01', null, 'HEALTH');
