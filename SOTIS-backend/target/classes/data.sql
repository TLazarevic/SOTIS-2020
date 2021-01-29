
insert into nastavnik(id, ime, prezime, lozinka, email) values (1,'Milan','Vidakovic', '12345678', 'vidak@gmail.com');
insert into predmet(id, naziv) values (1, 'Web programiranje');
insert into predmet(id, naziv) values (2, 'Agentske tehnologije');
insert into predmet(id, naziv) values (3, 'Objektno programiranje');
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,1);
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,2);
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,3);

insert into test(id, nastavnik_id, predmet_id) values (100,1,1);
insert into test(id, nastavnik_id, predmet_id) values (200,1,2);
insert into test(id, nastavnik_id, predmet_id) values (300,1,3);

insert into ucenik(id, ime, prezime, lozinka, email) values (100, 'Tamara', 'Lazarevic', '12345678', 'email@gmail.com');
insert into ucenik(id, ime, prezime, lozinka, email) values (200, 'Dusan', 'Blanusa', '12345678', 'email2@gmail.com');
insert into ucenik(id, ime, prezime, lozinka, email) values (300, 'Bla', 'Blabic','12345678', 'email3@gmail.com');

insert into ucenik_predmet(ucenik_id, predmet_id) values (100,1);
insert into ucenik_predmet(ucenik_id, predmet_id) values (100,2);
insert into ucenik_predmet(ucenik_id, predmet_id) values (200,1);
insert into ucenik_predmet(ucenik_id, predmet_id) values (300,1);

insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 100, false);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 200, false);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 300, false);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (200, 100, true);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (300, 100, true);

insert into prostor_znanja(id, predmet_id, generisan) values (100,1, false);
insert into cvor(cvor_id, string_id, label, pz_id) values (100, 'a','a',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (200, 'b', 'b',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (300, 'c', 'c',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (400, 'd', 'd',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (500, 'e', 'e',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (600, 'f', 'f',100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (100,'a','a', 100,300,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (200,'b','b', 100,400,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (300,'c','c', 200,500,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (400,'d','d', 300,600,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (500,'e','e', 400,600,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (600,'f','f', 500,600,100);

--insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (100,'test','test', 400,500,100);
--insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (200,'test2','test2', 200,100,100);
-- insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (200,'a c','a c', 100,300,100);

insert into pitanje(id, tekst, cvor_cvor_id, predmet_id) values (100,'p1','100',1);
insert into pitanje(id, tekst, cvor_cvor_id, predmet_id) values (200,'p2','200',1);
insert into pitanje(id, tekst, cvor_cvor_id, predmet_id) values (300,'p3','300',1);
insert into pitanje(id, tekst, cvor_cvor_id, predmet_id) values (400,'p4','400',1);
insert into pitanje(id, tekst, cvor_cvor_id, predmet_id) values (500,'p5','500',1);
insert into pitanje(id, tekst, cvor_cvor_id, predmet_id) values (600,'p6','600',1);

insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (100, true, 'tekst_odg', 100, 1, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (200, true, 'tekst_odg2', 100, 2,  null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (300, true, 'lalalala', 200, 1, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (400, true, 'lalalala', 200, 2, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (500, true, 'lalalala', 300, 1, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (600, true, 'lalalala', 300, 2, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (700, true, 'lalalala', 400, 1, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (800, true, 'lalalala', 400, 2, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (900, true, 'lalalala', 500, 1, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (1000, true, 'lalalala', 500, 2, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (1100, true, 'lalalala', 600, 1, null);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (1200, true, 'lalalala', 600, 2, null);

--insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (800, false, 'tekst_odg1', 100, 1, 100);
--insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (500, false, 'tekst_odg2', 100, 2, 100);
--insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (600, true, 'lalalala', 200,  1, 100);
--insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (700, true, 'lalalala', 200, 2, 100);

insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (901, true, 'tekst_odg1', 100, 1, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (902, true, 'tekst_odg2', 100, 2, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (903, true, 'lalalala', 200,  1, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (904, true, 'lalalala', 200, 2, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (905, true, 'lalalala', 300,  1, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (906, true, 'lalalala', 300, 2, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (907, true, 'lalalala', 400,  1, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (908, true, 'lalalala', 400, 2, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (909, true, 'lalalala', 500,  1, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (910, true, 'lalalala', 500, 2, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (911, true, 'lalalala', 600,  1, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (912, true, 'lalalala', 600, 2, 200);

insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (801, true, 'tekst_odg1', 100, 1, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (802, true, 'tekst_odg2', 100, 2, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (803, true, 'lalalala', 200,  1, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (804, true, 'lalalala', 200, 2, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (805, true, 'lalalala', 300,  1, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (806, true, 'lalalala', 300, 2, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (807, true, 'lalalala', 400,  1, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (808, true, 'lalalala', 400, 2, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (809, true, 'lalalala', 500,  1, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (810, true, 'lalalala', 500, 2, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (811, true, 'lalalala', 600,  1, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (812, true, 'lalalala', 600, 2, 300);

insert into test_pitanje(test_id,pitanje_id) values(100,100);
insert into test_pitanje(test_id,pitanje_id) values(100,200);
insert into test_pitanje(test_id,pitanje_id) values(100,300);
insert into test_pitanje(test_id,pitanje_id) values(100,400);
insert into test_pitanje(test_id,pitanje_id) values(100,500);
insert into test_pitanje(test_id,pitanje_id) values(100,600);

