let pokemon1Name = null;
let pokemon2Name = null;

export function setupCard(imgId, nameId, typeId, inputId, btnId, isSecond = false) {
    const img = document.getElementById(imgId);
    const name = document.getElementById(nameId);
    const type = document.getElementById(typeId);
    const input = document.getElementById(inputId);
    const btn = document.getElementById(btnId);

    btn.addEventListener("click", async () => {
        const id = input.value.trim();
        if (!id) {
            alert("Please enter a Pokémon ID");
            return;
        }
    // get token fron local storage
        const token = localStorage.getItem("token");
        if (!token) {
            alert("You must log in first");
            window.location.href = "index.html";
            return;
        }

        try {
            const response = await fetch(`https://wprogramming-diagnostic-test.onrender.com/api/pokemon/${id}`, {
                headers: {
                    "Authorization": "Bearer " + token
                }
            });

            if (!response.ok) throw new Error("Pokémon not found");

            const data = await response.json();

            img.src = data.sprite;
            name.textContent = data.name.toUpperCase();
            type.textContent = "Type: " + data.types.join(", ").toUpperCase();

            if (isSecond) {
                pokemon2Name = data.name;
            } else {
                pokemon1Name = data.name;
            }

            if (pokemon1Name && pokemon2Name) {
                console.log(`pokemon 1: ${pokemon1Name} vs pokemon 2: ${pokemon2Name}`);
            } else {
                console.log(`load: ${data.name}`);
            }
        } catch (error) {
            alert("That Pokémon does not exist yet :(");
        }
    });
}
