"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.BaseResponse = void 0;
var BaseResponse = /** @class */ (function () {
    function BaseResponse(data, message, success, statusCode) {
        this.data = data;
        this.message = message;
        this.success = success;
        this.statusCode = statusCode;
    }
    return BaseResponse;
}());
exports.BaseResponse = BaseResponse;
