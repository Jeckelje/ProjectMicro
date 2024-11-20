-- Удалить таблицу, если она существует
DROP TABLE IF EXISTS projects;

-- Создать новую таблицу
CREATE TABLE projects (
                          id SERIAL PRIMARY KEY,
                          project_name VARCHAR(100) NOT NULL,
                          project_customer_name VARCHAR(100) NOT NULL,
                          start_date DATE NOT NULL,
                          planned_completion_date DATE NOT NULL,
                          actual_completion_date DATE,
                          project_manager_name VARCHAR(100) NOT NULL,
                          is_completed_successfully BOOLEAN
);

-- Вставить примеры данных
INSERT INTO projects (project_name, project_customer_name, start_date, planned_completion_date, actual_completion_date, project_manager_name, is_completed_successfully)
VALUES
    ('SkyLedger', 'Tech Solutions Inc.', '2023-10-28', '2025-01-10', '2024-12-24', 'J.R. Smith', true),
    ('GreenPulse', 'Future Vision', '2022-01-15', '2024-05-20', '2024-04-15', 'A.L. Johnson', true),
    ('HealthLink', 'Global Innovations', '2023-02-10', '2025-08-30', NULL, 'M.K. Brown', false),
    ('FoodVerse', 'Creative Minds', '2021-05-15', '2023-12-01', '2023-11-20', 'S.T. Davis', true),
    ('BuildSmart', 'NextGen Solutions', '2022-03-20', '2024-07-15', NULL, 'R.E. White', false),
    ('AutoPilot360', 'Skyline Systems', '2022-07-10', '2025-11-10', NULL, 'T.J. Williams', false),
    ('EduPathway', 'InnoTech Co.', '2023-04-05', '2025-09-01', '2025-08-10', 'H.L. Scott', true),
    ('TravelMate', 'Alpha Dynamics', '2020-11-11', '2023-05-25', '2023-05-10', 'D.W. Clark', true),
    ('SecureCloud', 'Quantum Leap', '2023-01-20', '2024-10-10', NULL, 'E.P. Harris', false),
    ('ArtifyHub', 'Blue Horizon', '2023-09-15', '2024-12-20', '2024-12-01', 'C.B. Adams', true);
