import { Pitanje } from './pitanje'

export class CvorDTO {
    cvorId: number = 0
    id: string = ''
    label: string = ''
    pitanje: Pitanje = new Pitanje();
}