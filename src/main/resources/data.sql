INSERT INTO box (name) VALUES
('box1'), ('sysadmin'), ('lego');

INSERT INTO thread (box_id, title, thread_type, body) VALUES
(2, 'Hello soapbox', 'TEXT', 'This is a test thread'),
(3, 'Hello soapbox 3', 'TEXT', 'This is a test thread'),
(2, 'Hello soapbox 2', 'TEXT', 'This is a test thread'),
(1, 'Hello soapbox 1', 'TEXT', 'This is a test thread')
;