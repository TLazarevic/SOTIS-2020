import { Predmet } from './predmet';
import { ProstorZnanja } from './ProstorZnanja';

export class Ucenik {
    id!: number;
    ime!: String;
    prezime!: String;
    prostorZnanja!: ProstorZnanja[];

    constructor(ime: string, prezime: string) {
        this.id = 0;
        this.ime = ime;
        this.prezime = prezime;
        this.prostorZnanja = []
    }

}