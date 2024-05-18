const express = require('express');
const proxy = require('express-http-proxy')
const dotenv = require("dotenv")
const cors = require("cors");
const helmet = require("helmet");
const morgan = require("morgan");
const { Signale } = require("signale");

const app = express();
const signale = new Signale();

dotenv.config()

app.use(cors())
app.use(helmet())
app.use(morgan('dev'))
app.use(express.json());
app.disable("x-powered-by")

app.use('/api/v1/orders', proxy('http://localhost:3001'));
app.use('/api/v1/inventory', proxy('http://localhost:3002'));


const PORT = process.env.PORT || 3500;
app.listen(PORT, () => {
    signale.success(`Gateway is running on port ${PORT}`);
});