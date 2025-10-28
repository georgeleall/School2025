@template.loginlayout(
title = "Home",
content = @`

    <h1>Please sign in</h1>

    <form action="/login" method="post">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <br>
        <button type="submit" class="btn btn-success">Log In</button>
    </form>

`)