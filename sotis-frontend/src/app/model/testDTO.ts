import { Nastavnik } from './Nastavnik';
import { Pitanje } from "./pitanje";
import { Predmet } from "./predmet";

export class TestDTO {

    id: number = 0;
    pitanje: Pitanje[] = [];
    predmet!: Predmet;
    nastavnik!: Nastavnik;
    uradjen! : boolean
}