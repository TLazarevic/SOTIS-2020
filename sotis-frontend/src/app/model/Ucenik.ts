import { Predmet } from './predmet';
import { ProstorZnanja } from './ProstorZnanja';
import { Test } from './test';

export class Ucenik{
    id! : number;
    ime! : String;
    prezime! : String;
    test! : Test[];
    prostorZnanja! : ProstorZnanja[];
    predmet! : Predmet[];

}