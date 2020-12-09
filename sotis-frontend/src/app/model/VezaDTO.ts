import { Veza } from './Veza'

export class VezaDTO {
    vezaId!: number
    id!: string
    label!: string
    source!: string
    target!: string

    constructor(veza: Veza) {
        this.vezaId = veza.vezaId;
        this.id = veza.id;
        this.label = veza.label
        this.source = veza.source.id
        this.target = veza.target.id
    }
}