ALTER TABLE EMPLOYE DROP FOREIGN KEY fk_employe;
ALTER TABLE LIGUE DROP FOREIGN KEY fk_ligue;

ALTER TABLE EMPLOYE ADD CONSTRAINT fk_employe FOREIGN KEY (id_ligue) REFERENCES LIGUE(id_ligue);
ALTER TABLE LIGUE ADD CONSTRAINT fk_ligue FOREIGN KEY (id_employe) REFERENCES EMPLOYE(id_employe);