ALTER TABLE user_events DROP FOREIGN KEY FKaoq9ta3w34ph5j77xx2dgfao6, ADD CONSTRAINT FKaoq9ta3w34ph5j77xx2dgfao6 FOREIGN KEY (event_id) REFERENCES event(id) ON DELETE CASCADE


TRUNCATE TABLE event

insert into event(attendees_count, category, date_time, description, name, user_id)
values (100, 'GAME', '2024-12-16 13:00:00', 'realFootball', 'Toby', 1);