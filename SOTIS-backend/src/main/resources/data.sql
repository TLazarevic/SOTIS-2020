insert into nastavnik(id, ime, prezime) values (1,'Milan','Vidakovic');
insert into predmet(id, naziv) values (1, 'Web programiranje');
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,1);

insert into test(id, nastavnik_id, predmet_id) values (1,1,1);
insert into ucenik(id, ime, prezime) values (1, 'Tamara', 'Lazarevic');
insert into ucenik_predmet(ucenik_id, predmet_id) values (1,1);
