// track the amount of ingredient fields
let ingredientCount = 1;

document.getElementById("addIngredient").addEventListener("click", function () {
    ingredientCount++; //increment count by 1, so we can keep count of number of ingredients

    const ingredientFields = document.getElementById("ingredientFields");

    const label = document.createElement("label");
    label.setAttribute("for", `ingredient${ingredientCount}`);
    label.textContent = `Ingredient ${ingredientCount}:`;

    const input = document.createElement("input");
    input.type = "text";
    input.id = `ingredient${ingredientCount}`;
    input.name = `ingredient${ingredientCount}`;
    input.required = true; //ensurees the ingredient filed is mandatory 

    ingredientFields.appendChild(label);
    ingredientFields.appendChild(input);
    ingredientFields.appendChild(document.createElement("br"));
    ingredientFields.appendChild(document.createElement("br"));
});

//add event listener
document.getElementById("searchForm").addEventListener("submit", function (event) {
    event.preventDefault(); //

    //collect ingredients
    const ingredients = [];
    for (let i = 1; i <= ingredientCount; i++) {
        const ingredientValue = document.getElementById(`ingredient${i}`).value.trim();
        if (ingredientValue) {
            ingredients.push(ingredientValue); //adds the contents of the ingredient field to an array
        }
    }

    console.log("Ingredients being sent:", ingredients); //i used this to test that the ingredients were being collected correctly (can be seen in the console)

    // Send a POST request to the backend API with the ingredients
    fetch("http://localhost:8080/api/search", {
        method: "POST",
        headers: {
            "Content-Type": "application/json", //specifies json format
        },
        body: JSON.stringify({ ingredients }) //sends the ingredient data
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
        //log and display errors
        console.error(error);
        alert("An error occurred while fetching recipes.");
    });
});