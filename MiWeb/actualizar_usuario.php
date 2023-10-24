<!DOCTYPE html>
<html>
<head>
    <title>Actualiza Usuario</title>
</head>
<body>
    <h2>Actualiza Usuario</h2>
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $id = $_POST["id"];
    $nombre = $_POST["nombre"];
    $email = $_POST["email"];
    $edad = $_POST["edad"];

    $servidor = "localhost";
    $usuario = "root";
    $contraseña = "";
    $base_de_datos = "MiWeb";

    $conexion = new mysqli($servidor, $usuario, $contraseña, $base_de_datos);
    $consulta = "UPDATE persona SET Nombre = '$nombre', Email = '$email', Edad = $edad WHERE ID = $id";
    $resultado = $conexion->query($consulta);

    if ($resultado) {
        echo "Los cambios se han guardado exitosamente.";
    } else {
        echo "Error al guardar los cambios.";
    }

    $conexion->close();
    
}
?>
<a href="index.html"><button>Volver a la Página Principal</button></a>
</body>
</html>