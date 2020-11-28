import { Nastavnik } from './Nastavnik';
import { Pitanje } from "./pitanje";
import { Predmet } from './predmet';

export class Test{

    id!:number;
    pitanje: Pitanje[] = [];
    predmet!: Predmet;
    nastavnik! : Nastavnik;

}