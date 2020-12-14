import { Cvor } from './Cvor';
import { Odgovor } from './odgovor'

export class Pitanje {

    id:number=0;
    tekst:String="";
    odgovori!:Odgovor[];
    cvor: Cvor = new Cvor(-1, "","");

}