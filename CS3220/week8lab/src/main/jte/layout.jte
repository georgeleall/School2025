@import gg.jte.Content
@import java.lang.String

@param String title
@param Content content


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>

<div class="container-xl px-3">

    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-xl">
            <!-- Brand/Logo -->
            <a class="navbar-brand" href="#">
                <img src="/images/customer-support.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
                MyTickets
            </a>

            <!-- Hamburger Button (for small views) -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Collapsible Menu -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <div class="navbar-nav">
                    <a class="nav-link" href="#">Tickets</a>
                    <a class="nav-link" href="#">Users</a>
                    <a class="nav-link" href="/">Logout</a>
                </div>
            </div>
        </div>
    </nav>

    ${content}
</div>

</body>
<footer class="text-center text-muted mt-4">
    <p class="mb-1 lh-sm small">Copyright &copy; MyTickets 2025</p>
    <p class="mb-0 lh-sm small">
        Customer Service icon is created by
        <a href="https://www.flaticon.com/authors/freepik" class="text-secondary">Freepik</a> from
        <a href="https://www.flaticon.com/" class="text-secondary">Flaticon</a>
    </p>
</footer>
</html>