import React, { useState } from "react";
import axios from "axios";

function App() {
  const [form, setForm] = useState({
    name: "",
    roll_no: "",
    mse: [0, 0, 0, 0],
    ese: [0, 0, 0, 0],
  });

  const [result, setResult] = useState(null);

  const handleChange = (e, type, index = null) => {
    const value = e.target.value;
    if (type === "name" || type === "roll_no") {
      setForm({ ...form, [type]: value });
    } else {
      const updated = [...form[type]];
      updated[index] = parseInt(value) || 0;
      setForm({ ...form, [type]: updated });
    }s
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const res = await axios.post("http://localhost:3000/api/result", form);
    setResult(res.data.final);
  };

  return (
    <div className="container mt-4">
      <h3>VIT Semester Result</h3>
      <form onSubmit={handleSubmit}>
        <input
          className="form-control mb-2"
          placeholder="Name"
          onChange={(e) => handleChange(e, "name")}
        />
        <input
          className="form-control mb-2"
          placeholder="Roll No"
          onChange={(e) => handleChange(e, "roll_no")}
        />

        <h5>MSE (30%)</h5>
        {form.mse.map((_, i) => (
          <input
            key={i}
            className="form-control mb-2"
            placeholder={`Subject ${i + 1}`}
            onChange={(e) => handleChange(e, "mse", i)}
          />
        ))}

        <h5>ESE (70%)</h5>
        {form.ese.map((_, i) => (
          <input
            key={i}
            className="form-control mb-2"
            placeholder={`Subject ${i + 1}`}
            onChange={(e) => handleChange(e, "ese", i)}
          />
        ))}

        <button className="btn btn-primary mt-2">Submit</button>
      </form>

      {result && (
        <div className="mt-4">
          <h5>Final Marks</h5>
          <ul>
            {result.map((mark, i) => (
              <li key={i}>
                Subject {i + 1}: {mark}/100
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default App;
