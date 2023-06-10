<?php

    if(isset($_POST['submit'])){
        //print_r($_POST['nome']);
       // print_r($_POST['email']);
     //  print_r($_POST['senha']);

     include_once('config.php');
     $nome = $_POST['nome'];
     $email = $_POST['email'];
     $senha = $_POST['senha'];
     $sexo = $_POST['sexo'];
     $data_nasc = $_POST['data_nasc'];

     $result = mysqli_query($mysqli, "INSERT INTO usuarios(nome,email,senha,sexo,data_nasc) VALUES('$nome','$email','$senha','$sexo','$data_nasc')");
    }
?>
<html>
    <head> 
        <meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>Earthfund - Register</title>
        <!-- Stylesheet -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,600,600italic,700,700italic" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="assets/css/loginstyle.css" type="text/css">
    </head>
    <body>
        <div>
            <section>
                <img src="images/parallax/earthfund-logo.png" class="logo-login"alt="">
                <form action="register.php" method="POST">
                    <h3>Registre-se</h3>
                    <input id="email" type="text" name="nome" placeholder="Nome Completo">
                    <input id="email" type="text" name="email" placeholder="Seu E-mail">
                    <input id= "password" type="password" name="senha" placeholder="Cria sua senha">
                    <h3>Gênero</h3>
                    <section class="sex-field">
                        <input type="radio" name="sexo" id="box-shadow" class="custom-radio">
                        <label for="box-shadow">Masculino</label>
                        <input type="radio" name="sexo" id="box-shadow" class="custom-radio">
                        <label for="box-shadow">Feminino</label>
                        <input type="radio" name="sexo" id="box-shadow" class="custom-radio">
                        <label for="box-shadow">Outros</label>
                    </section>
                    <label for="data_nascimento"><h3>Data de Nascimento</h3></label>
                    <input type="date" name="data_nasc" id="data_nascimento" required>

                    <input type="submit" name="submit" value="Registrar-se!">
                    
                </form>
            </section>
        </div>


        <script>
            var email = document.getElementById('email');
            var password = document.getElementById('password');

            email.addEventListener('focus',()=>{
                email.style.borderColor = "#398378";
            });
            email.addEventListener('blur',()=>{
                email.style.borderColor = "ccc";
            });

            password.addEventListener('focus',()=>{
                password.style.borderColor = "#398378";
            });
            password.addEventListener('blur',()=>{
                password.style.borderColor = "ccc";
            });

        </script>
    </body>

</html>