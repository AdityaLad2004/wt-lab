const express = require("express");
const mysql = require("mysql2");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());

const db = mysql.createConnection({
  host: "",
  user: "",
  password: "",
  database: "",
});

app.get("/api/books", (req, res) => {
  db.query("SELECT * FROM book", (err, result) => {
    if (err) return res.status(500).json({ error: "Error fetching" });
    return res.json(result);
  });
});

app.post("/api/books", (req, res) => {
  const { title, author, description, price } = req.body;
  db.query(
    "INSERT INTO book (title,author,description,price) VALUES (?,?,?,?)",
    [title, author, description, price],
    (err, results) => {
      if (err) return res.status(500).json({ error: "Error inserting book" });
      return res
        .status(201)
        .json({ message: "Book inserted Successfully", id: results.insertId });
    }
  );
});

app.listen(3000, () =>
  console.log("Server listening on http://localhost:3000")
);
