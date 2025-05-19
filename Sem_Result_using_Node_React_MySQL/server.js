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

app.post("/api/result", (req, res) => {
  const { name, roll_no, mse, ese } = req.body;

  db.query(
    "INSERT INTO students (name, roll_no) VALUES (?, ?)",
    [name, roll_no],
    (err, result) => {
      if (err) return res.status(500).send("Error inserting student");
      const student_id = result.insertId;

      db.query(
        "INSERT INTO mse (student_id, subject1, subject2, subject3, subject4) VALUES (?, ?, ?, ?, ?)",
        [student_id, mse[0], mse[1], mse[2], mse[3]],
        (err) => {
          if (err) return res.status(500).send("Error inserting MSE");

          db.query(
            "INSERT INTO ese (student_id, subject1, subject2, subject3, subject4) VALUES (?, ?, ?, ?, ?)",
            [student_id, ese[0], ese[1], ese[2], ese[3]],
            (err) => {
              if (err) return res.status(500).send("Error inserting ESE");

              const final = mse.map((m, i) =>
                (m * 0.3 + ese[i] * 0.7).toFixed(2)
              );
              res.json({ message: "Result calculated", final });
            }
          );
        }
      );
    }
  );
});

app.listen(3000, () => console.log("Server running on http://localhost:3000"));
