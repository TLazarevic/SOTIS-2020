import { Odgovor } from './odgovor'
import { Cvor } from './Cvor';

export class PitanjeDTO {

    id:number=0;
    tekst:String="";
    odgovori!: Odgovor[];
    predmetId: number=0;
    cvor: Cvor = new Cvor(-1, "","");


}