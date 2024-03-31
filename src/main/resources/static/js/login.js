document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
    const formData = new FormData(event.target); // Get form data
    const requestData = Object.fromEntries(formData); // Convert form data to JSON

    fetch("http://localhost:8080/users/login?"+new URLSearchParams({
        username:username,
        password:password
    }), {
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
            console.log(data);
        })
        .catch(error => {
            console.error("Fetch error:", error);
        });
});