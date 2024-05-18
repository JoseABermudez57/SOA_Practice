"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.InventoryResponse = void 0;
var InventoryResponse = /** @class */ (function () {
    function InventoryResponse(uuid, name, price, stock) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    return InventoryResponse;
}());
exports.InventoryResponse = InventoryResponse;
