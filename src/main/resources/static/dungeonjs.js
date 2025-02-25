document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("generateButton").addEventListener("click", generateDungeon);
});

async function generateDungeon() {
    let seed = document.getElementById("seed").value || 42; // Default seed if empty
    try {
        let response = await fetch(`http://localhost:8080/dungeon/generate?seed=${seed}`, {
            method: "POST"
        });

        if (!response.ok) {
            throw new Error("Failed to generate dungeon");
        }

        let dungeon = await response.json();
        document.getElementById("dungeonLayout").textContent = JSON.stringify(dungeon, null, 2);
    } catch (error) {
        console.error("Error fetching dungeon data:", error);
        document.getElementById("dungeonLayout").textContent = "Error loading dungeon.";
    }
}
