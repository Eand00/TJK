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

    // Funzione per mostrare il popup della mano di prova
    var testHandBtn = document.getElementById("testHandBtn");
    var testHandPopup = document.getElementById("testHandPopup");
    var closeHandPopup = testHandPopup.querySelector(".close");
    var handContainer = document.getElementById("handContainer");

    // Funzione per scegliere 7 carte casuali
    function getRandomCards() {
        const allCards = document.querySelectorAll('.card-grid .card');
        const shuffledCards = Array.from(allCards).sort(() => 0.5 - Math.random());
        const selectedCards = shuffledCards.slice(0, 7); // Prendi 7 carte
        return selectedCards;
    }

    // Mostra le carte selezionate nel popup
    function showTestHand() {
        // Rimuovi carte precedenti
        handContainer.innerHTML = '';

        // Ottieni 7 carte casuali
        const randomCards = getRandomCards();

        // Aggiungi le carte al contenitore della mano
        randomCards.forEach(function(card) {
            var clonedCard = card.cloneNode(true); // Clona la carta
            handContainer.appendChild(clonedCard); // Aggiungi al popup
        });

        // Mostra il popup
        testHandPopup.style.display = "block";
    }

    // Chiudi il popup quando clicchi su "X"
    closeHandPopup.onclick = function() {
        testHandPopup.style.display = "none";
    }

    // Chiudi il popup quando clicchi fuori
    window.onclick = function(event) {
        if (event.target == testHandPopup) {
            testHandPopup.style.display = "none";
        }
    }

    // Aggiungi l'evento al bottone "Test Hand"
    testHandBtn.onclick = function() {
        showTestHand(); // Mostra la mano
    }
});