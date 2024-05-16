"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var express_1 = require("express");
var morgan_1 = require("morgan");
var dotenv_1 = require("dotenv");
var signale_1 = require("signale");
var express_http_proxy_1 = require("express-http-proxy");
var app = (0, express_1.default)();
var signale = new signale_1.Signale();
dotenv_1.default.config();
app.use((0, morgan_1.default)('dev'));
var PORT = process.env.PORT || 3000;
var GATEWAY = process.env.SERVICE_NAME;
app.use('/api/v1/orders', (0, express_http_proxy_1.default)('http://localhost:3002'));
app.use('/api/v1/products', (0, express_http_proxy_1.default)('http://localhost:3001'));
// rutas de auth
app.listen(PORT, function () {
    signale.success("Servicio ".concat(GATEWAY, " corriendo en http://localhost:").concat(PORT));
});
