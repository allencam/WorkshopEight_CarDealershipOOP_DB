DROP DATABASE IF EXISTS dealership_db;
CREATE DATABASE IF NOT EXISTS dealership_db;
USE dealership_db;

CREATE TABLE `dealership` (
    `dealership_id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `address` VARCHAR(50),
    `phone` VARCHAR(12),
    CONSTRAINT `pk_dealership` PRIMARY KEY (`dealership_id`)
);

CREATE TABLE `vehicles` (
    `vin`       VARCHAR(17) NOT NULL,
    `year`      INT,
    `make`      VARCHAR(255) NOT NULL,
    `model`     VARCHAR(255),
    `type`      VARCHAR(255),
    `color`     VARCHAR(255),
    `odometer`  INT,
    `price`     DECIMAL(8,2),
    `sold`      BOOLEAN,
    `dealership_id` INTEGER,

    CONSTRAINT `pk_vin` PRIMARY KEY (`vin`),
    FOREIGN KEY (dealership_id) REFERENCES dealership(dealership_id)
);

INSERT INTO `dealership` (`name`, `address`, `phone`) VALUES
('City Motors', '123 Main St', '1234567890'),
('Auto Haven', '456 Elm St', '0987654321'),
('Drive Away', '789 Oak St', '1122334455');

INSERT INTO `vehicles` (`vin`, `year`, `make`, `model`, `type`, `color`, `odometer`, `price`, `sold`, `dealership_id`) VALUES
('1HG5M826X3A123456', 2020, 'Toyota', 'Camry', 'Sedan', 'Blue', 15000, 24000.00, FALSE, 1),
('3FA6P0LU4KR123457', 2019, 'Honda', 'Civic', 'Sedan', 'Red', 20000, 20000.00, TRUE, 1),
('1HGCM82633A283954', 2018, 'Ford', 'Focus', 'Hatchback', 'White', 30000, 18000.00, FALSE, 1),
('2C3CDXCT7MH523960', 2021, 'Chevrolet', 'Malibu', 'Sedan', 'Black', 5000, 23000.00, TRUE, 1),
('3N1CN7AP7KL123458', 2020, 'Nissan', 'Altima', 'Sedan', 'Silver', 18000, 22000.00, FALSE, 1),
('5UXWX9C5XF0D12349', 2021, 'BMW', '3 Series', 'Coupe', 'Blue', 12000, 35000.00, FALSE, 2),
('WAUG8AF51JA059964', 2018, 'Audi', 'A4', 'Sedan', 'Red', 22000, 32000.00, TRUE, 2),
('WDDGF8AB2EA923457', 2020, 'Mercedes', 'C-Class', 'Sedan', 'Black', 10000, 40000.00, FALSE, 2),
('5NPE24AF3GH123459', 2019, 'Hyundai', 'Elantra', 'Sedan', 'White', 25000, 18000.00, TRUE, 2),
('KNAFX5A86F5192483', 2021, 'Kia', 'Optima', 'Sedan', 'Gray', 8000, 21000.00, FALSE, 2),
('5YJ3E1EB8KF123468', 2022, 'Tesla', 'Model 3', 'Electric', 'Red', 3000, 45000.00, TRUE, 3),
('JTDBL40E399X83745', 2020, 'Toyota', 'Corolla', 'Sedan', 'Blue', 15000, 18000.00, FALSE, 3),
('1HGCV1F35JA230942', 2021, 'Honda', 'Accord', 'Sedan', 'Black', 10000, 25000.00, TRUE, 3),
('JM1BPACL6K1371234', 2019, 'Mazda', '3', 'Hatchback', 'Silver', 20000, 20000.00, FALSE, 3),
('3VW267AJ6GM087413', 2020, 'Volkswagen', 'Jetta', 'Sedan', 'White', 18000, 19000.00, FALSE, 3),
('JF1GPAA65DH203764', 2021, 'Subaru', 'Impreza', 'Sedan', 'Gray', 14000, 23000.00, FALSE, 1),
('3GNAXUEV5LS582394', 2020, 'Chevrolet', 'Cruze', 'Sedan', 'Blue', 20000, 20000.00, TRUE, 1),
('1FA6P8CF0J5149234', 2019, 'Ford', 'Fusion', 'Sedan', 'Red', 25000, 21000.00, FALSE, 1),
('1N4AA6AP7KC123472', 2021, 'Nissan', 'Maxima', 'Sedan', 'Black', 7000, 27000.00, TRUE, 1),
('5NPE24AF3GH572834', 2020, 'Hyundai', 'Sonata', 'Sedan', 'Silver', 12000, 22000.00, FALSE, 1),
('5UXWX7C59G0D53485', 2021, 'BMW', 'X5', 'SUV', 'Gray', 15000, 45000.00, FALSE, 2),
('WA1LAAF72KD913846', 2020, 'Audi', 'Q5', 'SUV', 'Black', 18000, 43000.00, TRUE, 2),
('WDDSJ4EB9EN453678', 2020, 'Mercedes', 'GLA', 'SUV', 'Red', 10000, 39000.00, FALSE, 2),
('KNDPB3AC4H7012934', 2021, 'Kia', 'Sportage', 'SUV', 'Blue', 12000, 25000.00, TRUE, 2),
('JM3KFBCM5H0234728', 2021, 'Mazda', 'CX-5', 'SUV', 'White', 16000, 28000.00, FALSE, 2),
('3VWRF7AT4GM094852', 2020, 'Volkswagen', 'Tiguan', 'SUV', 'Silver', 20000, 27000.00, FALSE, 3),
('JTMZFREV3HD128745', 2021, 'Toyota', 'RAV4', 'SUV', 'Gray', 8000, 30000.00, TRUE, 3),
('5J6RW2H59KA123874', 2019, 'Honda', 'CR-V', 'SUV', 'Blue', 25000, 29000.00, FALSE, 3),
('1FMCU0G66JUB32495', 2021, 'Ford', 'Escape', 'SUV', 'Black', 10000, 25000.00, TRUE, 3),
('JN8AT2MV2KW120394', 2020, 'Nissan', 'Rogue', 'SUV', 'White', 12000, 26000.00, FALSE, 3),
('KL8CD6SA7JC152384', 2019, 'Chevrolet', 'Trax', 'SUV', 'Red', 20000, 20000.00, FALSE, 1),
('KM8K22AA7KU020347', 2020, 'Hyundai', 'Kona', 'SUV', 'Silver', 15000, 23000.00, TRUE, 1),
('5XYPGDA31KG020384', 2021, 'Kia', 'Sorento', 'SUV', 'Blue', 10000, 30000.00, FALSE, 1),
('JM1NDAB7G02013492', 2020, 'Mazda', 'MX-5', 'Convertible', 'Black', 7000, 31000.00, TRUE, 1),
('1VWAS7A3XFC110348', 2019, 'Volkswagen', 'Passat', 'Sedan', 'Gray', 22000, 20000.00, FALSE, 1),
('5YJSA1E23GF123847', 2021, 'Tesla', 'Model S', 'Electric', 'Red', 5000, 80000.00, FALSE, 2),
('WAUD4AF46GN052983', 2020, 'Audi', 'A6', 'Sedan', 'Blue', 15000, 55000.00, TRUE, 2),
('WBA5B3C52ED134852', 2019, 'BMW', '5 Series', 'Sedan', 'White', 20000, 45000.00, FALSE, 2),
('WDDZF4HB9KA123470', 2021, 'Mercedes', 'E-Class', 'Sedan', 'Silver', 12000, 60000.00, TRUE, 2),
('4S4BRCAC1K3457896', 2020, 'Subaru', 'Outback', 'SUV', 'Black', 14000, 34000.00, FALSE, 2),
('1G1FZ6S00L4112983', 2019, 'Chevrolet', 'Bolt', 'Electric', 'Red', 18000, 38000.00, FALSE, 3),
('KM8J23A48LU219485', 2021, 'Hyundai', 'Tucson', 'SUV', 'Blue', 10000, 32000.00, TRUE, 3),
('1N4AZ1CP9LC023485', 2020, 'Nissan', 'Leaf', 'Electric', 'White', 8000, 37000.00, FALSE, 3),
('1FA6P8TH2K5112489', 2021, 'Ford', 'Mustang', 'Coupe', 'Gray', 12000, 55000.00, TRUE, 3),
('5TDKZ3DC9KS120347', 2020, 'Toyota', 'Highlander', 'SUV', 'Silver', 15000, 45000.00, FALSE, 3),
('JM3TCBDY7K0312384', 2021, 'Mazda', 'CX-9', 'SUV', 'Blue', 10000, 47000.00, FALSE, 1),
('3VW117A93JM243569', 2019, 'Volkswagen', 'Golf', 'Hatchback', 'Black', 25000, 22000.00, TRUE, 1),
('WBA7E2C55HG123478', 2020, 'BMW', '7 Series', 'Sedan', 'Gray', 18000, 70000.00, FALSE, 1),
('WA1VF8GB8KD112845', 2021, 'Audi', 'Q7', 'SUV', 'Silver', 8000, 75000.00, TRUE, 1),
('WDDUG8GBXHA120394', 2020, 'Mercedes', 'S-Class', 'Sedan', 'White', 12000, 90000.00, FALSE, 1);
