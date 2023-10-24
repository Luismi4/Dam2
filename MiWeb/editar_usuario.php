<!DOCTYPE html>
<html>
<head>
    <title>Editar Usuario</title>
</head>
<body>
    <h2>Editar Usuario</h2>
    <?php
    if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET["ID"])) {
        

        $servidor = "localhost";
        $usuario = "root";
        $contraseña = "";
        $base_de_datos = "MiWeb";

        $conexion = new mysqli($servidor, $usuario, $contraseña, $base_de_datos);
        $id = $_GET['ID'];
        $consulta = "SELECT * FROM persona WHERE ID ='" .$id."'";
        $resultado = $conexion->query($consulta);
        if ($resultado->num_rows == 1) {
            $fila = $resultado->fetch_assoc();
            $nombre = $fila["Nombre"];
            $email = $fila["Email"];
            $edad = $fila["Edad"];
    
            
    
        } else {
            echo "Usuario no encontrado.";
        }
        echo '<form action="actualizar_usuario.php" method="post">';
            echo '<input type="hidden" name="id" value="' . $id . '">';
            echo '<label for="nombre">Nombre:</label>';
            echo '<input type="text" id="nombre" name="nombre" value="' . $nombre . '" required><br><br>';
            echo '<label for="email">Email:</label>';
            echo '<input type="text" id="email" name="email" value="' . $email . '" required><br><br>';
            echo '<label for="edad">Edad:</label>';
            echo '<input type="text" id="edad" name="edad" value="' . $edad . '" required><br><br>';
            echo '<input type="submit" value="Guardar Cambios">';
            echo '</form>';
        
    }

        ?>
</body>
</html>
