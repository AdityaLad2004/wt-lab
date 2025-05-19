<?php
include "db.php";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $title = $_POST['title'];
    $author = $_POST['author'];
    $description = $_POST['description'];
    $price = $_POST['price'];

    $stmt = $conn->prepare('INSERT INTO books (title, author, description, price) VALUES (?, ?, ?, ?)');
    $stmt->bind_param("sssi", $title, $author, $description, $price);
    $stmt->execute();
    header("Location: ".$_SERVER['PHP_SELF']);
    exit();
}

$result = $conn->query("SELECT * FROM books");
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Book Catalogue</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-4">
  <div class="container">
    <h3 class="mb-4">Online Book Store Catalogue</h3>

    <div class="row">
      <?php while($book = $result->fetch_assoc()): ?>
        <div class="col-md-4 mb-3">
          <div class="card h-100">
            <div class="card-body">
              <h5 class="card-title"><?= htmlspecialchars($book['title']) ?></h5>
              <h6 class="card-subtitle mb-2 text-muted"><?= htmlspecialchars($book['author']) ?></h6>
              <p class="card-text"><?= htmlspecialchars($book['description']) ?></p>
              <p><strong>₹<?= $book['price'] ?></strong></p>
            </div>
          </div>
        </div>
      <?php endwhile; ?>
    </div>

    <hr class="my-4">
    <h4>Add a New Book</h4>
    <form method="POST">
      <input type="text" name="title" class="form-control mb-2" placeholder="Book title" required>
      <input type="text" name="author" class="form-control mb-2" placeholder="Author" required>
      <input type="text" name="description" class="form-control mb-2" placeholder="Description" required>
      <input type="number" name="price" class="form-control mb-2" placeholder="Price in ₹" required>
      <button type="submit" class="btn btn-success">Add Book</button>
    </form>
  </div>
</body>
</html>
