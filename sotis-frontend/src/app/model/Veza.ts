import { Cvor } from './Cvor'

export class Veza {
    vezaId!: number
    id!: string
    label!: string
    source!: Cvor
    target!: Cvor

    constructor(vezaId: number, id: string, label: string, source: Cvor, target: Cvor) {
        this.vezaId = vezaId;
        this.id = id;
        this.label = label;
        this.source = source;
        this.target = target;
    }
}