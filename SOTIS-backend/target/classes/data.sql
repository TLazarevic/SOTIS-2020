
insert into nastavnik(id, ime, prezime) values (1,'Milan','Vidakovic');
insert into predmet(id, naziv) values (1, 'Web programiranje');
insert into predmet(id, naziv) values (2, 'Agentske tehnologije');
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,1);
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,2);

insert into test(id, nastavnik_id, predmet_id) values (100,1,1);
insert into test(id, nastavnik_id, predmet_id) values (200,1,2);
insert into test(id, nastavnik_id, predmet_id) values (300,1,1);
insert into ucenik(id, ime, prezime) values (100, 'Tamara', 'Lazarevic');
insert into ucenik_predmet(ucenik_id, predmet_id) values (100,1);
insert into ucenik_predmet(ucenik_id, predmet_id) values (100,2);

insert into test_pitanje(test_id,pitanje_id) values(100,100);
insert into test_pitanje(test_id,pitanje_id) values(200,100);
insert into test_pitanje(test_id,pitanje_id) values(200,200);
insert into test_pitanje(test_id,pitanje_id) values(300,100);

insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 100, true);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 200, false);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 300, true);

insert into prostor_znanja(id, predmet_id) values (100,1);
insert into cvor(cvor_id, string_id, label, pz_id) values (100, 'a','a',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (200, 'b', 'b',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (400, 'c', 'c',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (500, 'd', 'd',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (600, 'e', 'e',100);
insert into cvor(cvor_id, string_id, label, pz_id) values (700, 'f', 'f',100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (100,'1','1', 100,400,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (200,'1','1', 100,500,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (300,'1','1', 200,600,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (400,'1','1', 400,700,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (500,'1','1', 500,700,100);
insert into veza(veza_id, string_id,  label, source_cvor_id, target_cvor_id, pz_id) values (600,'1','1', 600,700,100);

