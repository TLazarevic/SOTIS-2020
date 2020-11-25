import { Pitanje } from "./pitanje";

export class Test{

    id:number=0;
    pitanja: Pitanje[] = [];
    predmet: String="";

    constructor(predmet : String){
        this.predmet = predmet;
    }
}