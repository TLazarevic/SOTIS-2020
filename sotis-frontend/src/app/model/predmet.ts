import { Nastavnik } from "./Nastavnik";
import { Ucenik } from './Ucenik';

export class Predmet {
    id!: number;
    naziv!: string;
    nastavnik!: Nastavnik[];
    ucenik!: Ucenik[];

}