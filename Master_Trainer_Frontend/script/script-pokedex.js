document.addEventListener("DOMContentLoaded", function() {
    // Get the elements of the login form
    var formContainer = document.getElementById("loginForm");
    var btn = document.getElementById("loginBtn");
    var span = document.getElementsByClassName("close")[0];

    // When you click the login button, open the form
    btn.onclick = function() {
        formContainer.style.display = "block";
    }

    // When you click the X, close the form
    if (span) {
        span.onclick = function() {
            formContainer.style.display = "none";
        }
    }

    // When you click outside the form, close it
    window.onclick = function(event) {
        if (event.target == formContainer) {
            formContainer.style.display = "none";
        }
    }

    // Manage the toggle of the heart icon for the cards
    var heartIcons = document.querySelectorAll('.heart-icon');
    heartIcons.forEach(function(icon) {
        icon.addEventListener('click', function() {
            this.classList.toggle('filled'); // Toggle the 'filled' class to change the heart icon
        });
    });

    // Function to toggle the visibility of the filter popup
    function toggleFilterPopup() {
        const filterPopup = document.getElementById('filter-popup');
        if (filterPopup.style.display === 'none' || filterPopup.style.display === '') {
            filterPopup.style.display = 'block'; // Show the popup
        } else {
            filterPopup.style.display = 'none'; // Hide the popup
        }
    }

    // Add an event to the filter button
    document.querySelector('.filter-btn').onclick = function() {
        toggleFilterPopup();
    }

    // Close the filter popup when clicking outside of it
    window.onclick = function(event) {
        const filterPopup = document.getElementById('filter-popup');
        if (event.target !== filterPopup && !filterPopup.contains(event.target) && event.target !== document.querySelector('.filter-btn')) {
            filterPopup.style.display = 'none'; // Hide the popup
        }
    }
});