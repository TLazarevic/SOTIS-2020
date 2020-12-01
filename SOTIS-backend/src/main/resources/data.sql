insert into nastavnik(id, ime, prezime) values (1,'Milan','Vidakovic');
insert into predmet(id, naziv) values (1, 'Web programiranje');
insert into predmet(id, naziv) values (2, 'Agentske tehnologije');
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,1);
insert into predmet_nastavnik(nastavnik_id, predmet_id) values (1,2);

insert into test(id, nastavnik_id, predmet_id) values (1,1,1);
insert into test(id, nastavnik_id, predmet_id) values (2,1,2);
insert into test(id, nastavnik_id, predmet_id) values (3,1,1);
insert into ucenik(id, ime, prezime) values (100, 'Tamara', 'Lazarevic');
insert into ucenik_predmet(ucenik_id, predmet_id) values (100,1);
insert into ucenik_predmet(ucenik_id, predmet_id) values (100,2);

insert into pitanje(id, tekst) values (1, 'tekstpitanja');
insert into odgovor(id, tekst, tacnost, pitanje_id) values (1, 'teksttt', true,1);
insert into pitanje(id, tekst) values (2, 'tekstpitanja2');
insert into odgovor(id, tekst, tacnost, pitanje_id) values (2, 'teksttt2', true,2);
insert into test_pitanje(test_id,pitanje_id) values(1,1);
insert into test_pitanje(test_id,pitanje_id) values(2,1);
insert into test_pitanje(test_id,pitanje_id) values(2,2);
insert into test_pitanje(test_id,pitanje_id) values(3,1);

insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 1, true);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 2, false);
insert into ucenik_test(ucenik_id,test_id, uradjen) values (100, 3, true);
