"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Inventory = void 0;
var uuid_1 = require("uuid");
var Inventory = /** @class */ (function () {
    function Inventory(name, price, stock) {
        this.uuid = (0, uuid_1.v4)();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    return Inventory;
}());
exports.Inventory = Inventory;
