<?php
$servidor = "localhost";
$usuario = "root";
$contraseña = "";
$base_de_datos = "MiWeb";

// Crear una conexión
$conexion = new mysqli($servidor, $usuario, $contraseña, $base_de_datos);

// Verificar la conexión
if ($conexion->connect_error) {
die("Error de conexión: " . $conexion->connect_error);
}
if ($_SERVER["REQUEST_METHOD"] == "POST") {
$nombre = $_POST["nombre"];
$email = $_POST["email"];
$edad = $_POST["edad"];
}

$consulta = "INSERT INTO Persona (Nombre, Email, Edad) VALUES ('$nombre', '$email', '$edad')";
if($conexion->query($consulta) === true){
    echo "Registro insertado con éxito";
}else{
    echo "Error al insertar el registro";
}

$conexion->close();
?>