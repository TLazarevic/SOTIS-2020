import { Cvor } from './Cvor';
import { Predmet } from './predmet';
import { Veza } from './Veza';

export class ProstorZnanja {
    id!: number;
    predmet!: Predmet;
    cvorovi: Cvor[]=[]
    veze: Veza[]=[]

    constructor(cvorovi: Cvor[], veze: Veza[], predmet: Predmet) {
        this.veze = veze
        this.cvorovi = cvorovi
        this.predmet = predmet
        this.id = 0
    }
}