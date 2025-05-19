<?php
$mysqli = new mysqli("", "", "", "");

if ($mysqli->connect_error) {
  die("Connection failed: " . $mysqli->connect_error);
}

$name = $_POST['name'];
$roll = $_POST['roll_no'];

$mse = [$_POST['mse1'], $_POST['mse2'], $_POST['mse3'], $_POST['mse4']];
$ese = [$_POST['ese1'], $_POST['ese2'], $_POST['ese3'], $_POST['ese4']];

$stmt = $mysqli->prepare("INSERT INTO students (name, roll_no) VALUES (?, ?)");
$stmt->bind_param("ss", $name, $roll);
$stmt->execute();
$student_id = $stmt->insert_id;

$stmt = $mysqli->prepare("INSERT INTO mse (student_id, subject1, subject2, subject3, subject4) VALUES (?, ?, ?, ?, ?)");
$stmt->bind_param("iiiii", $student_id, $mse[0], $mse[1], $mse[2], $mse[3]);
$stmt->execute();

$stmt = $mysqli->prepare("INSERT INTO ese (student_id, subject1, subject2, subject3, subject4) VALUES (?, ?, ?, ?, ?)");
$stmt->bind_param("iiiii", $student_id, $ese[0], $ese[1], $ese[2], $ese[3]);
$stmt->execute();

echo "<h5>Final Marks (30% MSE + 70% ESE)</h5><ul>";
for ($i = 0; $i < 4; $i++) {
  $total = round($mse[$i] * 0.3 + $ese[$i] * 0.7, 2);
  echo "<li>Subject " . ($i + 1) . ": $total / 100</li>";
}
echo "</ul>";
?>
