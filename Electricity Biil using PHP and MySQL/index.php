<?php

$host = '';
$username = '';
$password = '';
$db = '';

$conn = mysqli_connect($host,$username,$password,$db);

if($_SERVER["REQUEST_METHOD"] == "POST"){
    $name = $_POST['name'];
    $address = $_POST['address'];
    $units = (int)$_POST['units'];

    $stmt = $conn->prepare("INSERT INTO consumer(name,address) VALUES(?,?)");
    $stmt -> bind_param("ss", $name,$address);
    $stmt->execute();
    $consumer_id = $stmt->insert_id;

    $amt = 0;
    $u = $units;
    if ($u <= 50) $amount = $u * 3.5;
    else if ($u <= 150) $amount = 50 * 3.5 + ($u - 50) * 4.0;
    else if ($u <= 250) $amount = 50 * 3.5 + 100 * 4.0 + ($u - 150) * 5.2;
    else $amount = 50 * 3.5 + 100 * 4.0 + 100 * 5.2 + ($u - 250) * 6.5;

    $stmt = $conn->prepare("INSERT INTO billing(consumer_id,units, amount) VALUES (?,?,?)");
    $stmt->bind_param("iid",$consumer_id,$u,$amount);
    $stmt->execute();
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electricity Bill Calculator</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/bootstrap.min.css">
</head>
<body class="p-4">
    <div class="container">
        <h3 class="text-center mb-4">Electricity Bill Calculator</h3>

        <form method="POST">
            <div class="mb-3">
                <input type="text" name="name" class="form-control" placeholder="Consumer Name" required>
            </div>
            <div class="mb-3">
                <input type="text" name="address" class="form-control" placeholder="Address" required>
            </div>
            <div class="mb-3">
                <input type="number" name="units" class="form-control" placeholder="Units Consumed" required>
            </div>
            <button type="submit" class="btn btn-primary">Generate Bill</button>
        </form>
        <?php
            if($_SERVER["REQUEST_METHOD"] == "POST"): ?>
                <div class="mt-4 p-3 border rounded">
                    <h5>Bill Generated:</h5>
                    <p><strong>Name:</strong> <?= htmlspecialchars($name) ?></p>
                    <p><strong>Address:</strong> <?= htmlspecialchars($address) ?></p>
                    <p><strong>Units Consumed:</strong> <?= $units ?></p>
                    <p><strong>Total Amount:</strong> ₹<?= number_format($amount, 2) ?></p>
                </div>
        <?php endif; ?>
    </div>    
</body>
</html>