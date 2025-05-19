<?php

include "db.php";

$result= mysqli_query($conn,"SELECT * FROM items");

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catalogue</title>
</head>
<body>
    <h2>Grocery items</h2>
    <ul>
        <?php while($row = mysqli_fetch_assoc($result)){?>
            <li><?php echo $row['name'];?> - Rupee<?php echo $row['price']?></li>
        <?php } ?>
    </ul>
</body>
</html>