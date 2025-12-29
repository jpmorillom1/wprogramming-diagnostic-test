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
        const token = localStorage.getItem("token");
        if (!token) {
            alert("You must log in first");
            window.location.href = "index.html";
            return;
        }

        try {
            const response = await fetch(`http://fullstack-alb-1823758252.us-east-1.elb.amazonaws.com:8080/api/pokemon/${id}`, {
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
            }
        } catch (error) {
            alert("That Pokémon does not exist yet :(");
        }
    });
}


export function setupPredict(btnId, resultId) {
    const btn = document.getElementById(btnId);
    const result = document.getElementById(resultId);

    btn.addEventListener("click", async () => {
        if (!pokemon1Name || !pokemon2Name) {
            alert("Please select both Pokémon first!");
            return;
        }

        try {
            const token = localStorage.getItem("token");


            const res = await fetch(`http://fullstack-alb-1823758252.us-east-1.elb.amazonaws.com:8080/api/pokemon/predict/${pokemon1Name}/${pokemon2Name}`, {
                method: "GET",
                headers: {
                    "Authorization": "Bearer " + token
                }
            });

            if (!res.ok) throw new Error("Error getting prediction");

            const data = await res.json();
            result.textContent = `Result: ${data.prediction}`;
        } catch (error) {
            result.textContent = "Error: Could not get prediction.";
        }
    });
}
