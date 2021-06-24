INSERT INTO asterisk.OPERATOR (EMAIL,PASSWORD,USERNAME) VALUES
	 ('rajkerpn@yahoo.com','$2a$10$QmnBgEtRP3EXDlp86xKQB.ABLV.WtB6n2cxu01Jezi3tWZRPMrwh2','rayker'),
	 ('emina@gmail.com','$2a$10$Z25ATsRDltFb4RO/aLPgZufxFyf61FTJBnM/FcEmeSsxXSWrfGN2S','emina'),
	 ('srecko@gmail.com','$2a$10$YY.H/XwSXQYH.aVAFtKUae7i0kcIKfvXvAZ6MFcFMSZrohaS2S4si','srecko'),
	 ('bojan@gmail.com','$2a$10$wQoe.EALQgE2nwEcq8fMPOxmL4qjvutMyjmw5GcpeYNq9huIGnoJK','bojan'),
	 ('user@gmail.com','$2a$10$uMXOFTDhdDfNrsngm0osp./Il2oKD1r0IYu0Ty2xovd0rtGYcizfG','korisnik1');INSERT INTO asterisk.OUTGOING_CALL_TEMPLATE (NAME,PREDEFINED_RESULTS,ACTIVE) VALUES
	 ('drugi templejt','#drugi odgovor#treci odgovor#',1),
	 ('treci templejt','#prvi odgovor#drugi odgovor#treci#',1),
	 ('cetvrti templejt','#Kuca#Posao#Reka#Beograd#Zvezda#Sesti#',1),
	 ('najnoviji templejt','#prvi#drugi#treci#cetvrti#',1),
	 ('Templejt broj 57','#Prvi#Drugi#Treci#Cetvrti#Peti#Sesti#',0),
	 ('sablon 31.5.2021','#prvi#drugi#treci#cetvrti#',0),
	 ('novi templejt','#drugi#treci#cetvrti#',0),
	 ('test','#first#second#',0),
	 ('123','#123#123#',0);INSERT INTO asterisk.ROLES (NAME) VALUES
	 ('ROLE_USER'),
	 ('ROLE_MODERATOR'),
	 ('ROLE_ADMIN'),
	 ('ROLE_AGENT');INSERT INTO asterisk.OPERATOR_ROLES (USER_ID,ROLE_ID) VALUES
	 (1,1),
	 (2,1),
	 (4,3),
	 (5,1),
	 (6,1);INSERT INTO asterisk.OUTGOING_CALL (CONTACT_NAME,CONTACT_PHONE,NAME,CREATION_DATE,OUTGOING_CALL_TEMPLATE_ID,NOTE) VALUES
	 ('mihajlo','0607666010','Lista 1','2021-05-22',2,'Napomena za listu 1'),
	 ('aleksa','0614522010','Lista 1','2021-05-22',2,'Napomena za listu 1'),
	 ('natalija','0607666010','Neplatise do 1.6','2021-05-22',3,'Neplatise do 1.6'),
	 ('borko','0614522010','Neplatise do 1.6','2021-05-22',3,'Neplatise do 1.6'),
	 ('jovan','0607666010','Ponuda za Wifi','2021-05-22',2,'Ponuda za Wifi'),
	 ('marko','0614522010','Ponuda za Wifi','2021-05-22',2,'Ponuda za Wifi'),
	 ('nenad','0607666010','Neplatise do 1.6','2021-05-25',3,'Dopuna neplatisa do 10.6.'),
	 ('emina','0614522010','Neplatise do 1.6','2021-05-25',3,'Dopuna neplatisa do 10.6.'),
	 ('nenad','0607666010','Ponuda optika od 1000/100.','2021-05-25',3,'Ponuda optika od 1000/100.'),
	 ('emina','0614522010','Ponuda optika od 1000/100.','2021-05-25',3,'Ponuda optika od 1000/100.');