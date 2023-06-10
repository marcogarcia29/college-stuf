<?php
if (!isset($_SESSION)) {
    session_start();
}
?>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            margin: 0;
            width:100%;
            height:100%;
            font-family:"Open Sans", sans-serif;
            font-size:14px;
            line-height:1.5em;
            color:#696f6f;
            background:#fff;
            -webkit-font-smoothing:antialiased;
        }
        h1, .h1, h2, .h2, h3, .h3, h4, .h4, h5, .h5, h6, .h6 {
	        line-height:1.5em;
	        color:#282828;
        }
        
        .container {
            display: flex;
            flex-direction: row;
            min-height: 100vh;
        }
        
        .sidebar {
            background-color: #398378;
            color: #fff;
            padding: 20px;
            display: flex;
            flex-direction: column;
        }
        
        .sidebar i {
            margin-bottom: 10px;
        }
        
        .content {
            flex: 1;
            padding: 20px;
        }
        
        @media (max-width: 768px) {
            .container {
                flex-direction: column;
            }
            
            .sidebar {
                width: 100%;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <i class="fas fa-home"></i> <!-- Ícone de casa -->
            <i class="fas fa-envelope"></i> <!-- Ícone de envelope -->
            <i class="fas fa-cog"></i> <!-- Ícone de engrenagem -->
            <!-- Mais ícones aqui -->
        </div>
        <div class="content">
            <h1>
                Bem-vindo ao seu painel, <?php echo $_SESSION['nome']; ?>
            </h1>
        </div>
    </div>
</body>
</html>
