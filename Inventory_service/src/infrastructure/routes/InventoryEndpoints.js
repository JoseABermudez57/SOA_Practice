"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.setupInventoryEndpoints = void 0;
var Dependencies_1 = require("../Dependencies");
function setupInventoryEndpoints(app) {
    app.get("/health", function (req, res) {
        res.status(200).json({ status: 'OK' });
    });
    app.post("/", Dependencies_1.createInventoryController.execute.bind(Dependencies_1.createInventoryController));
    app.delete("/:uuid", Dependencies_1.deleteInventoryController.execute.bind(Dependencies_1.deleteInventoryController));
    app.get("/", Dependencies_1.listInventoryController.execute.bind(Dependencies_1.listInventoryController));
}
exports.setupInventoryEndpoints = setupInventoryEndpoints;
