export class CreateInventoryRequest{
    public name: string;
    public price: number;
    public stock: number;

    constructor(name: string, price: number, stock: number){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}2