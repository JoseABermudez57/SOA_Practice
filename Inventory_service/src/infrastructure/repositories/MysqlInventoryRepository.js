"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.MysqlInventoryRepository = void 0;
var mysqldb_1 = require("../../database/mysqldb");
var Inventory_1 = require("../../domain/model/Inventory");
var MysqlInventoryRepository = /** @class */ (function () {
    function MysqlInventoryRepository() {
    }
    MysqlInventoryRepository.prototype.decreaseStock = function (uuid, stock) {
        return __awaiter(this, void 0, void 0, function () {
            var product, sql, params, error_1;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        console.log(uuid, stock);
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 6, , 7]);
                        return [4 /*yield*/, this.findByUuid(uuid)];
                    case 2:
                        product = _a.sent();
                        console.log(product);
                        if (!product) return [3 /*break*/, 4];
                        console.log(product);
                        product.stock -= stock;
                        console.log(product);
                        sql = "UPDATE inventories SET stock = ? WHERE uuid = ?";
                        params = [product.stock, product.uuid];
                        return [4 /*yield*/, (0, mysqldb_1.query)(sql, params)];
                    case 3:
                        _a.sent();
                        return [2 /*return*/, product];
                    case 4:
                        console.log("nadota");
                        return [2 /*return*/, Promise.resolve(null)];
                    case 5: return [3 /*break*/, 7];
                    case 6:
                        error_1 = _a.sent();
                        console.log(error_1);
                        return [2 /*return*/, Promise.resolve(null)];
                    case 7: return [2 /*return*/];
                }
            });
        });
    };
    MysqlInventoryRepository.prototype.findByUuid = function (uuid) {
        return __awaiter(this, void 0, void 0, function () {
            var sql, params, result, inventory, error_2;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        sql = "SELECT * FROM inventories WHERE uuid = ?";
                        params = [uuid];
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 3, , 4]);
                        return [4 /*yield*/, (0, mysqldb_1.query)(sql, params)];
                    case 2:
                        result = (_a.sent())[0];
                        if (result.length > 0) {
                            inventory = new Inventory_1.Inventory(result[0].name, result[0].price, result[0].stock);
                            inventory.uuid = result[0].uuid;
                            return [2 /*return*/, inventory];
                        }
                        return [2 /*return*/, Promise.resolve(null)];
                    case 3:
                        error_2 = _a.sent();
                        console.log(error_2);
                        throw new Error('find by uuid error');
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    MysqlInventoryRepository.prototype.delete = function (uuid) {
        return __awaiter(this, void 0, void 0, function () {
            var sql, params, error_3;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        sql = "DELETE FROM inventories WHERE uuid = ?";
                        params = [uuid];
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 3, , 4]);
                        return [4 /*yield*/, (0, mysqldb_1.query)(sql, params)];
                    case 2:
                        _a.sent();
                        return [2 /*return*/, Promise.resolve()];
                    case 3:
                        error_3 = _a.sent();
                        throw new Error('Error deleting user');
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    MysqlInventoryRepository.prototype.list = function () {
        return __awaiter(this, void 0, void 0, function () {
            var sql, result, error_4;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        sql = "SELECT * FROM inventories";
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 3, , 4]);
                        return [4 /*yield*/, (0, mysqldb_1.query)(sql, [])];
                    case 2:
                        result = (_a.sent())[0];
                        if (result) {
                            return [2 /*return*/, result.map(function (element) {
                                    var inventory = new Inventory_1.Inventory(element.name, element.price, element.stock);
                                    inventory.uuid = element.uuid;
                                    return inventory;
                                })];
                        }
                        return [2 /*return*/, Promise.resolve(null)];
                    case 3:
                        error_4 = _a.sent();
                        return [2 /*return*/, null];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    MysqlInventoryRepository.prototype.create = function (inventory) {
        return __awaiter(this, void 0, void 0, function () {
            var sql, params, error_5;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        sql = "INSERT INTO inventories (uuid, name, price, stock) VALUES (?, ?, ?, ?)";
                        _a.label = 1;
                    case 1:
                        _a.trys.push([1, 3, , 4]);
                        params = [inventory.uuid, inventory.name, inventory.price, inventory.stock];
                        return [4 /*yield*/, (0, mysqldb_1.query)(sql, params)];
                    case 2:
                        _a.sent();
                        return [2 /*return*/, Promise.resolve(inventory)];
                    case 3:
                        error_5 = _a.sent();
                        console.log(error_5);
                        return [2 /*return*/, Promise.resolve(null)];
                    case 4: return [2 /*return*/];
                }
            });
        });
    };
    return MysqlInventoryRepository;
}());
exports.MysqlInventoryRepository = MysqlInventoryRepository;
