import { Cvor } from './Cvor';
import { Predmet } from './predmet';
import { Veza } from './Veza';

export class ProstorZnanja {
    id!: number;
    predmet!: Predmet;
    cvorovi: Cvor[]=[]
    veze: Veza[]=[]
    generisan!: boolean;

    constructor(cvorovi: Cvor[], veze: Veza[], predmet: Predmet, generisan: boolean) {
        this.veze = veze
        this.cvorovi = cvorovi
        this.predmet = predmet
        this.generisan = generisan
        this.id = 0
    }
}