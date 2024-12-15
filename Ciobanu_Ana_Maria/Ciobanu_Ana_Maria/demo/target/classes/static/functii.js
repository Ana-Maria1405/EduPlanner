const adaugaButton = document.getElementById('adaugaButton');
const sectiuneAdauga = document.getElementById('sectiuneAdauga');
const toggleSidebar = document.getElementById('toggleSidebar');
const toggleIcon = document.getElementById('toggleIcon');
const leftSidebar = document.querySelector('.sidebar');
const contentWrapper = document.querySelector('.content-wrapper');

// Creăm un buton pentru afișarea barei laterale când aceasta este ascunsă
const showSidebarButton = document.createElement('button');
showSidebarButton.classList.add('btn', 'btn-light', 'toggle-btn');
showSidebarButton.style.position = 'absolute';
showSidebarButton.style.top = '50%';
showSidebarButton.style.left = '0';
showSidebarButton.style.transform = 'translateY(-50%)';
showSidebarButton.style.zIndex = '10';
showSidebarButton.innerHTML = '&rarr;'; // Săgeată spre dreapta
showSidebarButton.style.display = 'none'; // Ascundem acest buton inițial

// Adaugăm butonul la DOM
document.body.appendChild(showSidebarButton);

// Eveniment pentru afișarea/ascunderea secțiunii de adăugare sarcină
adaugaButton.addEventListener('click', function () {
    sectiuneAdauga.classList.toggle('d-none');
});

// Eveniment pentru ascunderea barei laterale
toggleSidebar.addEventListener('click', function () {
    leftSidebar.classList.toggle('d-none'); // Ascunde bara laterală
    leftSidebar.classList.toggle('sidebar-hidden'); // Adaugă sau elimină clasa sidebar-hidden

    // Când sidebar-ul este ascuns, nu modificăm lățimea content-wrapper, pentru că e deja controlată de CSS
    if (leftSidebar.classList.contains('d-none')) {
        toggleIcon.innerHTML = '&rarr;'; // Săgeată spre dreapta
        showSidebarButton.style.display = 'block'; // Afișăm butonul pentru a readuce bara laterală
    } else {
        toggleIcon.innerHTML = '&larr;'; // Săgeată spre stânga
        showSidebarButton.style.display = 'none'; // Ascundem butonul de readucere
    }
});

// Eveniment pentru afișarea barei laterale
showSidebarButton.addEventListener('click', function () {
    leftSidebar.classList.remove('d-none'); // Afișăm bara laterală
    toggleIcon.innerHTML = '&larr;'; // Săgeată spre stânga
    showSidebarButton.style.display = 'none'; // Ascundem butonul de readucere
});

// Funcție pentru încărcarea sarcinilor dintr-un API
async function loadSarcini() {
    try {
        // Obține datele din API (presupunând că endpoint-ul este '/api/sarcini')
        const response = await fetch('/api/sarcini');

        // Verifică dacă răspunsul este OK (status 200)
        if (!response.ok) {
            console.error('Eroare la preluarea datelor.');
            return;
        }

        // Preia datele în format JSON
        const sarcini = await response.json();

        // Selectează tbody-ul tabelului în care vom insera datele
        const tbody = document.querySelector('#sarciniTable tbody');

        // Golește tabelul înainte de a adăuga noile date
        tbody.innerHTML = '';

        // Adaugă fiecare sarcină în tabel
        sarcini.forEach(sarcina => {
            // Creează un rând pentru fiecare sarcină
            const tr = document.createElement('tr');

            // Adaugă celulele corespunzătoare fiecărui câmp din sarcină
            tr.innerHTML = `
                <td>${sarcina.titlu}</td>
                <td>${sarcina.descriere}</td>
                <td>${sarcina.dataSpecifica}</td>
                <td>${sarcina.oraSpecifica}</td>
				<td>${sarcina.gratitudine}</td> 
				<td>${sarcina.imbunatatiri}</td> 
            `;

            // Adaugă rândul în tabel
            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error('A apărut o eroare la prelucrarea datelor:', error);
    }
}

// Încarcă sarcinile la încărcarea paginii
window.onload = loadSarcini;
