const express = require("express");
const router = express.Router();
const db = require("../db");

function calculate(units) {
  if (units <= 50) return units * 3.5;
  if (units <= 150) return 50 * 3.5 + (units - 50) * 4.0;
  if (units <= 250) return 50 * 3.5 + 100 * 4.0 + (units - 150) * 5.2;
  return 50 * 3.5 + 100 * 4.0 + 100 * 5.2 + (units - 250) * 6.5;
}

router.post("/consumer", (req, res) => {
  const { name, address } = req.body;
  db.query(
    "INSERT INTO Consumer (name,address) VALUES (?,?)",
    [name, address],
    (err, result) => {
      if (err) return res.status(500).send(err);
      res.send({ id: result.insertId, name, address });
    }
  );
});

router.post("/billing", (req, res) => {
  const { consumer_id, units } = req.body;
  const amount = calculate(units);
  db.query(
    "INSERT INTO Billing (consumer_id, units, amount) VALUES (?,?,?)",
    [consumer_id, units, amount],
    (err, result) => {
      if (err) return res.status(500).send(err);
      res.send({ id: result.insertId, consumer_id, units, amount });
    }
  );
});

router.get("/consumer", (_, res) => {
  db.query("SELECT * FROM Consumer", (err, rows) => {
    if (err) return res.status(500).send(err);
    res.send(rows);
  });
});

router.get("/billing", (req, res) => {
  const { consumer_id } = req.query;
  let query = "SELECT * FROM Billing ";
  const params = [];

  if (consumer_id) {
    query += "WHERE consumer_id = ?";
    params.push(consumer_id);
  }
  db.query(query, params, (err, rows) => {
    if (err) return res.status(500).send(err);
    res.send(rows);
  });
});

module.exports = router;
