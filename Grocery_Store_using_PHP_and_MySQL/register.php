<?php
include "db.php";

if($_SERVER['REQUEST_METHOD']=='POST'){
    $name = $_POST['name'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    $hashed = password_hash($password,PASSWORD_DEFAULT);

    $stmt = $conn->prepare("INSERT INTO consumer(name,email,password) VALUES (?,?,?)");
    $stmt-> bind_param("sss",$name,$email,$hashed);
    $stmt->execute();

    echo "Registered Successfully. <a href='login.html'>Login here</a>";
}

?>