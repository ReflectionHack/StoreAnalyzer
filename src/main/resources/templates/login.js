document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
    const formData = new FormData(event.target); // Get form data
    const requestData = Object.fromEntries(formData); // Convert form data to JSON

    // Make fetch request
    fetch("your_server_endpoint", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(data => {
            // Handle successful response here
            console.log(data);
        })
        .catch(error => {
            // Handle errors here
            console.error("Fetch error:", error);
        });
});