<?php
session_start();
if(!ISSET($_SESSION['name'])){
    header("Location: login.html");
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>
    <h2>Welcome, <?php echo $_SESSION['name'];?></h2>
    <p><a href="catalogue.php">Go to Catalogue</a></p>
</body>
</html>