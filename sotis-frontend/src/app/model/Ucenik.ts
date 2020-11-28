import { Predmet } from './predmet';
import { ProstorZnanja } from './ProstorZnanja';

export class Ucenik{
    id! : number;
    ime! : String;
    prezime! : String;
    prostorZnanja! : ProstorZnanja[];
    predmet! : Predmet[];

}