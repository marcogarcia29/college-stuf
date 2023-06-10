<?php
    include('config.php');
    if (isset($_POST['email']) && isset($_POST['senha'])) {
        if(strlen($_POST['email']) == 0){
            echo "Preencha seu e-mail";
        } else if(strlen($_POST['senha']) == 0){
            echo "Preencha sua senha";
        } else {
            $email = $mysqli->real_escape_string($_POST['email']);
            $senha = $mysqli->real_escape_string($_POST['senha']);
            $sql_code = "SELECT * FROM usuarios WHERE email = '$email' AND senha = '$senha'";
            $sql_query = $mysqli->query($sql_code) or die("Falha na execução do código SQL: " . $mysqli->error);
            $quantidade = $sql_query->num_rows;
            if($quantidade == 1){
                $usuario = $sql_query->fetch_assoc();
                if(!isset($_SESSION)){
                    session_start();
                }                
                $_SESSION['id'] = $usuario['id'];
                $_SESSION['nome'] = $usuario['nome'];
                header("Location: myprojects.php");
            } else {
                echo "Falha ao logar! E-mail ou senha incorretos!";
            }
        }
    }
?>

<!doctype html>
<html>
    <head> 
        <title>Earthfund - Login</title>
        <!-- Stylesheet -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,600,600italic,700,700italic" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="assets/css/loginstyle.css" type="text/css">
    </head>
    <body>
        <div>
            <section>
                <img src="images/parallax/earthfund-logo.png" class="logo-login"alt="">
                <form action ="" method="POST">
                    <h3>Login</h3>
                    <input id="email" type="text" name="email" placeholder="E-mail">
                    <input id= "password" type="password" name="senha" placeholder="Senha">
                    <input type="submit" name="submit" value="Enviar">
                    <section class="register-lead">
                        <small>Não possui uma conta? </small><a href="register.php">Registre-se aqui!</a>
                    </section>
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