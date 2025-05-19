const bodyParser = require("body-parser");
const express = require("express");
const cors = require("cors");

const app = express();

app.use(cors());
app.use(express.json());

const billingRoutes = require("./routes/billing");
app.use("/api", billingRoutes);

app.listen(3000, () => console.log("Server running on http://localhost:3000"));

app.get("/ping", (req, res) => {
  res.send("pong");
});
