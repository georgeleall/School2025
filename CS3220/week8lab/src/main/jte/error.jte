@import gg.jte.Content

@param String errorMessage

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style>
        body, html {
            height: 100%;  /* Full height for the body and html elements */
            margin: 0;
            display: flex;
            justify-content: center;  /* Center horizontally */
            align-items: center;  /* Center vertically */
            text-align: center;
        }
        .container {
            text-align: center;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .btn {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Incorrect Email or Password</h2>
    <p>Please try again.</p>
    <p>${errorMessage}</p>
    <a href="/" class="btn btn-success">Go back to Login</a>
</div>

</body>
</html>
