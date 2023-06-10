<?php

    $hostname = 'localhost';
    $bancodedados = 'formulario-earthfund';
    $usuario = 'root';
    $senha = '';

    $mysqli = new mysqli($hostname, $usuario, $senha, $bancodedados);

    if($mysqli -> connect_errno)
    {
        echo "Erro";
    }


?>