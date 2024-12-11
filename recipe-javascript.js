// Track the number of ingredient fields
let ingredientCount = 1;

document.getElementById("addIngredient").addEventListener("click", function () {
    ingredientCount++;

    const ingredientFields = document.getElementById("ingredientFields");

    const label = document.createElement("label");
    label.setAttribute("for", `ingredient${ingredientCount}`);
    label.textContent = `Ingredient ${ingredientCount}:`;

    const input = document.createElement("input");
    input.type = "text";
    input.id = `ingredient${ingredientCount}`;
    input.name = `ingredient${ingredientCount}`;
    input.required = true; // Add the required attribute

    ingredientFields.appendChild(label);
    ingredientFields.appendChild(input);
    ingredientFields.appendChild(document.createElement("br"));
    ingredientFields.appendChild(document.createElement("br"));
});

// Add an event listener to the form submission
document.getElementById("searchForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission behavior

    // Collect all ingredient values dynamically
    const ingredients = [];
    for (let i = 1; i <= ingredientCount; i++) {
        const ingredientValue = document.getElementById(`ingredient${i}`).value.trim();
        if (ingredientValue) {
            ingredients.push(ingredientValue);
        }
    }

    console.log("Ingredients being sent:", ingredients);

    // Send a POST request to the backend API with the ingredients
    fetch("http://localhost:8080/api/search", {
        method: "POST",
        headers: {
            "Content-Type": "application/json", // Specify JSON format
        },
        body: JSON.stringify({ ingredients }) // Send all ingredient data in the body
    })
    .then(response => {
        if (response.ok) {
            return response.json(); // Parse response as JSON
        } else if (response.status === 204) {
            // If no content, return an empty array
            return [];
        } else {
            throw new Error("Failed to fetch recipes."); // Handle errors
        }
    })
    .then(data => {
        // Get the HTML element to display the recipes
        const recipeList = document.getElementById("recipeList");
        recipeList.innerHTML = ""; // Clear previous results

        if (data.length === 0) {
            // If no recipes found
            recipeList.innerHTML = "<li>No recipes found.</li>";
        } else {
            // Display each recipe as a list item
            data.forEach(recipe => {
                const listItem = document.createElement("li");
                listItem.textContent = recipe;
                recipeList.appendChild(listItem);
            });
        }
    })
    .catch(error => {
        // Log and display errors
        console.error(error);
        alert("An error occurred while fetching recipes.");
    });
});