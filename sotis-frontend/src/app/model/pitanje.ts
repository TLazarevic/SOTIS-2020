import { Odgovor } from './Odgovor'

export class Pitanje {

    id:number=0;
    tekst:String="";
    odgovori: Odgovor[] = [];
}