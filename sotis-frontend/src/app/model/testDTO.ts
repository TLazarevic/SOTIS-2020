import { Pitanje } from "./pitanje";

export class TestDTO{

    id:number=0;
    pitanja: Pitanje[] = [];
    predmet: String="";

    constructor(predmet : String){
        this.predmet = predmet;
    }
}