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
            <a class="navbar-brand" href="#">MyNotes</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <div class="navbar-nav">
                    <a class="nav-link" href="#">Notes</a>
                    <a class="nav-link" href="#">Files</a>
                    <a class="nav-link" href="#">Blogs</a>
<div class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" href="#" id="themeDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
        Theme
    </a>
    <ul class="dropdown-menu" aria-labelledby="themeDropdown">
        <li><a class="dropdown-item" href="#">Light</a></li>
        <li><a class="dropdown-item" href="#">Dark</a></li>
        <li><a class="dropdown-item" href="#">System</a></li>
    </ul>
</div>
                </div>
                <form class="d-flex ms-auto" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                </form>
                <button class="btn btn-success" type="submit">New Note</button>
            </div>
        </div>
    </nav>

    ${content}
</div>
<br>
<div class="container-xl px-3">
    <div class = "text-success"><a href="#">Notes</a> / CS 3220 Sample Midterm</div>
</div>
<br>
<div class="container-xl px-4">
    <p>In this exam you are going to create a web application
        that manages online polls. Your application must be implemented as
        a Spring Boot MVC application with JTE as described in class.</p>
</div>


<div class="container-xl px-4">
    <p>The main page of the application lists the existing polls. For example:</p>
</div>

<div class="container-xl px-5">
    <a href="#">Create Poll</a>
</div>
<br>

<div class="container-xl px-5">
    <table class="table table-bordered">
        <tbody>
        <tr>
            <td>What programming languages do you know?</td>
            <td><a href="#">Add Answer</a></td>
        </tr>
        <tr>
            <td>Who is the greatest basketball player of all time?</td>
            <td><a href="#">Add Answer</a></td>
        </tr>
        </tbody>
    </table>
</div>

<div id="Poll" class="container-xl px-4">
    <p>Clicking on a poll displays the poll. For example:</p>
</div>

<div class="container-xl px-5">
    <p>What programming languages do you know?</p>
</div>

<div class="container-xl px-5">
    <input type="checkbox" id="Java" name="Java" value="Java">
    <label for="Java">Java</label><br>
    <input type="checkbox" id="Python" name="Python" value="Python">
    <label for="Python">Python</label><br>
    <input type="checkbox" id="C/C++" name="C/C++" value="C/C++">
    <label for="C/C++">C/C++</label><br>
</div>
<br>
<div class="container-xl px-4">
    <p>Note that a poll consists of a question and a number of possible answers.
        A poll can be single-choice or multiple-choice. For a single-choice poll,
        the answers are displayed with radio buttons, while for a multiple-choice poll,
        the answers are displayed with checkboxes.</p>
</div>

<div class="container-xl px-4">
<p>A user may click on Add Answers to add more answers to a poll. For example:</p>
</div>

<div class="container-xl px-5">
    <a href="#Poll">Back to Polls</a>
</div>

<br>

<div class="container-xl px-5">
    <p>What programming languages do you know?</p>
</div>


<div class="container-xl px-5">
    <p>Java</p>
    <p>Python</p>
    <p>C/C++</p>
    <input type="text" id="inputText">
    <button onclick="addText()">Add</button>
</div>
<br>

<div class="container-xl px-4">
    <p>After a new answer is added, the user should be redirected back to the
        Add Answers page. Clicking on Back to Polls should take
        the user back to the main page.</p>
</div>

<div class="container-xl px-4">
    <p>When a user clicks on <em>Create Poll</em>, the application shows the following
        page where the user can create a new poll:</p>
</div>

<div class="container-xl px-5">
    <form action="#">
        <label for="Question">Question:</label>
        <input type="text" id="Question"><br><br>
        <input type="checkbox" id="Single-Choice" name="Single-Choice" value="Single-Choice">
        <label for="Single-Choice">Single-Choice</label><br><br>
        <input type="submit" value="Create">
    </form>
</div>

<br>

<div class="container-xl px-4">
    <p>Note that if the Single-Choice checkbox is checked,
        the poll will be a single-choice poll; otherwise it will
        be a multiple-choice poll. After a poll is created, the user
        should be directed to the Add Answers page to add answers to the poll.</p>
</div>

<hr>
<div class="container-xl px-4">
    <p>Grading</p>
</div>

<div class="container-xl px-4">
    <ul>
        <li>List Polls (20pt)</li>
        <li>Display Poll (20pt)</li>
        <li>Create Poll (30pt)</li>
        <li>Add Answers (30pt)</li>
    </ul>
</div>

</body>
<footer class="text-center text-muted mt-4">
    <p class="mb-1 lh-sm small">Copyright &copy; MyNotes 2025</p>
    <p class="mb-0 lh-sm small">
        Customer Service icon is created by
        <a href="https://www.flaticon.com/authors/freepik" class="text-secondary">Freepik</a> from
        <a href="https://www.flaticon.com/" class="text-secondary">Flaticon</a>
    </p>
</footer>
</html>