DROP TABLE IF EXISTS basic_Info;

CREATE TABLE basic_Info (
                              name VARCHAR(50) NOT NULL,
                              email VARCHAR(250) PRIMARY Key NOT NULL,
                              phone_number VARCHAR(250) NOT NULL,
                              clearance VARCHAR(250) DEFAULT NULL
);

INSERT INTO basic_Info (name, email, phone_number,clearance) VALUES
('Jack', 'Jack@drf.com', '0455-658-293','Baseline');DROP TABLE IF EXISTS billionaires;

CREATE TABLE cert_or_award (
                            email VARCHAR(50) PRIMARY Key NOT NULL,
                            description VARCHAR(250) NOT NULL
);

INSERT INTO cert_or_award (name, email, phone_number,clearance) VALUES
('Jack@drf.com', 'Udemy course: Spark');DROP TABLE IF EXISTS cert_or_award;


CREATE TABLE education (
                            email VARCHAR(250) PRIMARY Key NOT NULL,
                            institution_name VARCHAR(250) NOT NULL,
                            degree_type VARCHAR(250) NOT NULL,
                            grad_date VARCHAR(50) NOT NULL
);

INSERT INTO education (email, institution_name, degree_type,grad_date) VALUES
('Jack@drf.com', 'ANU', 'BA','2022');DROP TABLE IF EXISTS education;

CREATE TABLE jobs (
                           email VARCHAR(250) PRIMARY Key NOT NULL,
                           org_name VARCHAR(250) NOT NULL,
                           position VARCHAR(250) NOT NULL,
                           start_date VARCHAR(50) NOT NULL,
                           end_date VARCHAR(50) NOT NULL,
                           description VARCHAR(50) NOT NULL
);

INSERT INTO jobs (email, org_name, position,start_date,end_date,description) VALUES
('Jack@drf.com', 'DFR', 'Reception','12/04/2020', '24/06/2021','Admin Duties');DROP TABLE IF EXISTS jobs;

CREATE TABLE skills (
                           email VARCHAR(250) PRIMARY Key NOT NULL,
                           skill_name VARCHAR(250) NOT NULL,
                           skill_level Int NOT NULL
);

INSERT INTO skills (email, skill_name, skill_level) VALUES
('Jack@drf.com', 'Java', 6);DROP TABLE IF EXISTS skills;
