import { Odgovor } from './odgovor'

export class PitanjeDTO {

    id:number=0;
    tekst:String="";
    odgovori!: Odgovor[];
    predmetId: number=0;

}