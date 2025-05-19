import axios from "axios";
import { useEffect, useState } from "react";

export default function Catalogue() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:3000/api/books")
      .then((res) => setBooks(res.data));
  }, []);

  return (
    <div className="container mt-4">
      <h2>Book Catalogue</h2>
      <ul className="list-group">
        {books.map((b) => (
          <li className="list-group-item" key={b.id}>
            {b.title} by {b.author} with {b.description} - Rupees {b.price}
          </li>
        ))}
      </ul>
    </div>
  );
}
