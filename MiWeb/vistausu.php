<!DOCTYPE html>
<html>
<head>
    <title>Vista de Usuarios Registrados</title>
</head>
<body>
    <h2>Vista de Usuarios Registrados</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Edad</th>
            <th>Editar</th>
        </tr>
        <?php
        $servidor = "localhost";
        $usuario = "root";
        $contraseña = "";
        $base_de_datos = "MiWeb";

        $conexion = new mysqli($servidor, $usuario, $contraseña, $base_de_datos);
        $consulta = "SELECT * FROM persona";
        $resultado = $conexion->query($consulta);

        while ($fila = $resultado->fetch_assoc()) {
            echo "<tr>";
            echo "<td>" . $fila["ID"] . "</td>";
            echo "<td>" . $fila["Nombre"] . "</td>";
            echo "<td>" . $fila["Email"] . "</td>";
            echo "<td>" . $fila["Edad"] . "</td>";
            echo '<td><a href="editar_usuario.php?ID=' . $fila["ID"] . '">Editar</a></td>';
            echo "</tr>";
        }

        $conexion->close();
        ?>
    </table>
</body>
</html>