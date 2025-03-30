-- Adresy
insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400'),
            (1, 'ul. Kwiatowa 12', 'lok. 5', 'Warszawa', '00-001'),
            (2, 'ul. Długa 22', NULL, 'Kraków', '31-123'),
            (3, 'ul. Średnia 33', 'm. 12', 'Poznań', '60-432'),
            (4, 'ul. Ogrodowa 18', NULL, 'Wrocław', '53-400'),
            (5, 'ul. Jasna 5', 'pok. 101', 'Gdańsk', '80-001');

-- Pacjenci
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
            VALUES
            (1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@example.com', 'P001', '1985-05-10', 1),
            (2, 'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', 'P002', '1990-09-15', 2),
            (3, 'Piotr', 'Wójcik', '456123789', 'piotr.wojcik@example.com', 'P003', '1978-03-22', 3);

-- Lekarze
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            VALUES
            (1, 'Marek', 'Zieliński', '555111222', 'marek.z@example.com', 'D001', 'SURGEON', 4),
            (2, 'Agnieszka', 'Lewandowska', '555222333', 'agnieszka.l@example.com', 'D002', 'DERMATOLOGIST', 5),
            (3, 'Robert', 'Witkowski', '555333444', 'robert.w@example.com', 'D003', 'SURGEON', 1),
            (4, 'Olga', 'Białek', '555444555', 'olga.b@example.com', 'D004', 'GP', 2),
            (5, 'Ewa', 'Kaczmarek', '555555666', 'ewa.k@example.com', 'D005', 'OCULIST', 3);

-- Leczenie
INSERT INTO medical_treatment (id, description, type)
            VALUES
            (1, 'USG jamy brzusznej', 'USG'),
            (2, 'EKG spoczynkowe', 'EKG'),
            (3, 'RTG klatki piersiowej', 'RTG'),
            (4, 'EKG wysiłkowe', 'EKG'),
            (5, 'RTG kręgosłupa', 'RTG');

-- Wizyty
INSERT INTO visit (id, description, time, patient_id, doctor_id, treatment_id)
            VALUES
            (1, 'Wizyta kontrolna – USG', '2025-03-29T10:00:00', 1, 1, 1),
            (2, 'Pierwsza konsultacja – EKG', '2025-04-01T09:00:00', 2, 1, 2),
            (3, 'Zabieg okulistyczny', '2025-04-02T13:00:00', 2, 5, 3),
            (4, 'EKG wysiłkowe po zawale', '2025-04-03T15:30:00', 3, 4, 4),
            (5, 'RTG kręgosłupa – bóle lędźwiowe', '2025-04-05T11:15:00', 1, 3, 5);