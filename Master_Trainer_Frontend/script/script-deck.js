// Ensure the DOM is fully loaded before running the script
document.addEventListener("DOMContentLoaded", function() {
    // Get the form elements
    var formContainer = document.getElementById("loginForm");
    var btn = document.getElementById("loginBtn");
    var span = document.getElementsByClassName("close")[0];

    // When you click the login button, open the form
    btn.onclick = function() {
        formContainer.style.display = "block";
    }

    // When you click on the X, close the form
    span.onclick = function() {
        formContainer.style.display = "none";
    }

    // When you click outside the form, close it
    window.onclick = function(event) {
        if (event.target == formContainer) {
            formContainer.style.display = "none";
        }
    }
});