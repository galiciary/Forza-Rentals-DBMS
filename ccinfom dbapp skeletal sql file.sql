-- 1. Create a car rental database
CREATE DATABASE IF NOT EXISTS DBCarRentals;

-- 2. Use the car rental database for creating tables
USE DBCarRentals;

-- 3. Create primary tables 

CREATE TABLE renter_record (
	renter_dl_number VARCHAR(20) UNIQUE NOT NULL, # PK
    renter_first_name VARCHAR(50) NOT NULL,
    renter_last_name VARCHAR(50) NOT NULL,
	renter_phone_number VARCHAR(11) UNIQUE NOT NULL,
	renter_email_address VARCHAR(100) UNIQUE NOT NULL,
    
    PRIMARY KEY (renter_dl_number)
);
    
CREATE TABLE car_record (
	car_plate_number VARCHAR(7) UNIQUE NOT NULL, # PK
    car_transmission ENUM('Manual', 'Automatic') NOT NULL,
	car_model VARCHAR(50) NOT NULL,
    car_brand VARCHAR(50) NOT NULL,
    car_year_manufactured YEAR NOT NULL,
    car_mileage INT NOT NULL,
    car_seat_number INT NOT NULL,
    car_status ENUM('Available', 'Rented', 'Under Maintenance') NOT NULL DEFAULT 'Available',
	car_branch_id VARCHAR(6) NOT NULL, # FK
    
    PRIMARY KEY (car_plate_number),
    FOREIGN KEY (car_branch_id) REFERENCES branch_record (branch_id)
);

CREATE TABLE branch_record (
	branch_id VARCHAR(6) UNIQUE NOT NULL,
    branch_name VARCHAR(50) UNIQUE NOT NULL,
    branch_email_address VARCHAR(100) UNIQUE NOT NULL,
    branch_location_id VARCHAR(10) NOT NULL,
    
    PRIMARY KEY (branch_id),
    FOREIGN KEY (branch_location_id) REFERENCES location_record (location_id)
);

CREATE TABLE staff_record (
	staff_id VARCHAR(6) UNIQUE NOT NULL, # PK
    staff_first_name VARCHAR(50) NOT NULL,
    staff_last_name VARCHAR(50) NOT NULL,
    staff_job_id VARCHAR(20) NOT NULL, # FK
    staff_branch_id VARCHAR(6) NOT NULL, # FK
    
    PRIMARY KEY (staff_id),
	FOREIGN KEY (staff_job_id) REFERENCES job_record (job_id),
    FOREIGN KEY (staff_branch_id) REFERENCES branch_record (branch_id)
);

CREATE TABLE job_record (
	job_id VARCHAR(20) UNIQUE NOT NULL, # PK
    job_title VARCHAR(100) UNIQUE NOT NULL,
    job_department_id VARCHAR(10) NOT NULL, # FK
    job_salary DECIMAL NOT NULL,
    
    PRIMARY KEY (job_id),
    FOREIGN KEY (job_department_id) REFERENCES department_record (department_id)
);

CREATE TABLE department_record (
	department_id VARCHAR(10) UNIQUE NOT NULL, # PK
    department_name VARCHAR(50) UNIQUE NOT NULL,
    
    PRIMARY KEY (department_id)
);

CREATE TABLE location_record (
	location_id VARCHAR(10) UNIQUE NOT NULL, # PK
    location_city VARCHAR(50) NOT NULL,
    location_province VARCHAR(50) UNIQUE NOT NULL,
    
    PRIMARY KEY (location_id)
);

-- 4. Create transactional tables
