export class BMI {
    weight: number;
    size: number;
    bmi: number;
    ergebnis: number;

    constructor() {
        this.weight = 70;
        this.size = 180;
        this.bmi = 0;
        this.ergebnis = 0;
    }

    getWeight() : number {
        return this.weight;
    }

    getSize() : number {
        return this.size;
    }

    getBmi() : number {
        return this.bmi;
    }

    getErgebnis() : number {
        return this.ergebnis;
    }

    setWeight(weight: number) : void {
        this.weight = weight;
    }

    setSize(size: number) : void {
        this.size = size;
    }

    setBmi(bmi: number) : void {
        this.bmi = bmi;
    }

    setErgebnis(ergebnis: number) : void {
        this.ergebnis = ergebnis;
    }
}