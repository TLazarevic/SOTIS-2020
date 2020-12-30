
insert into nastavnik(id, ime, prezime) values (1,'Milan','Vidakovic');
insert into predmet(id, naziv) values (1, 'Web programiranje');
insert into predmet(id, naziv) values (2, 'Agentske tehnologije');
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,1);
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,2);

insert into test(id, nastavnik_id, predmet_id) values (100,1,1);
insert into test(id, nastavnik_id, predmet_id) values (200,1,2);
insert into test(id, nastavnik_id, predmet_id) values (300,1,1);
insert into ucenik(id, ime, prezime) values (100, 'Tamara', 'Lazarevic');
insert into ucenik(id, ime, prezime) values (200, 'Dusan', 'Blanusa');
insert into ucenik(id, ime, prezime) values (300, 'Bla', 'Blabic');

insert into ucenik_predmet(ucenik_id, predmet_id) values (100,1);
insert into ucenik_predmet(ucenik_id, predmet_id) values (100,2);
insert into ucenik_predmet(ucenik_id, predmet_id) values (200,1);
insert into ucenik_predmet(ucenik_id, predmet_id) values (300,1);

insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 100, true);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 200, false);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 300, false);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (200, 100, true);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (300, 100, true);

insert into prostor_znanja(id, predmet_id, generisan) values (100,1, false);
insert into cvor(cvor_id, string_id, label, pz_id) values (100, 'mikrobi','mikrobi',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (200, 'gljive', 'gljive',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (300, 'sisari', 'sisari',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (400, 'd', 'd',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (500, 'e', 'e',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (600, 'f', 'f',100);
-- insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (100,'a','a', 100,300,100);
-- insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (200,'b','b', 100,400,100);
-- insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (300,'c','c', 200,500,100);
-- insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (400,'d','d', 300,600,100);
-- insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (500,'e','e', 400,600,100);
-- insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (600,'f','f', 500,600,100);

insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (100,'test','test', 400,500,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (200,'test2','test2', 200,100,100);
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

insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (800, false, 'tekst_odg1', 100, 1, 100);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (500, false, 'tekst_odg2', 100, 2, 100);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (600, true, 'lalalala', 200,  1, 100);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (700, true, 'lalalala', 200, 2, 100);

insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (900, true, 'tekst_odg1', 100, 1, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (990, true, 'tekst_odg2', 100, 2, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (980, true, 'lalalala', 200,  1, 200);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (970, true, 'lalalala', 200, 2, 200);

insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (960, true, 'tekst_odg1', 100, 1, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (950, true, 'tekst_odg2', 100, 2, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (940, true, 'lalalala', 200,  1, 300);
insert into odgovor(id, tacnost, tekst, pitanje_id, redni_br, ucenik_id) values (930, true, 'lalalala', 200, 2, 300);


insert into test_pitanje(test_id,pitanje_id) values(100,100);
insert into test_pitanje(test_id,pitanje_id) values(100,200);
insert into test_pitanje(test_id,pitanje_id) values(200,300);
insert into test_pitanje(test_id,pitanje_id) values(200,400);
insert into test_pitanje(test_id,pitanje_id) values(200,500);
insert into test_pitanje(test_id,pitanje_id) values(200,600);


