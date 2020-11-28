import { Nastavnik } from './Nastavnik';
import { Odgovor } from './odgovor';
import { PitanjeDTO } from "./PitanjeDTO";
import { Predmet } from './predmet';

export class TestViewDTO{

    id!:number;
    pitanje: PitanjeDTO[] = [];

}