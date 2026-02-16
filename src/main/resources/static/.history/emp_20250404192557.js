function showemployee(){
    fetch("http://localhost:8080/employees")
    .then((response) => response.json())
    .then((employeedetails) => {
        const dataTable = document.getElementById("employeeDetails")

        employeedetails.forEach(employeedetails => {
            var row = `<tr>
            <td>${employeedetails.id}</td>
            <td>${employeedetails.name}</td>
            <td>${employeedetails.age}</td>
            <td>${employeedetails.gender}</td>
            <td>${employeedetails.employeeroll}</td>
            <td>${employeedetails.salary}</td>
          
            </tr>`;

            dataTable.innerHTML+=row;
        });
    })
    .catch(error => console.error('Error fetching electives:', error));
}

function showemployeetask(){
    fetch("http://localhost:8080/employees/task") 
    .then((response) => response.json()) 
    .then((employeetask) => {
        const dataTable = document.getElementById("employeetask")
            
        employeetask.forEach(employeetask => {
            var row = `<tr>
            
            <td>${employeetask.employeeId}</td>
            <td>${employeetask.taskname}</td>
            <td>${employeetask.taskmanager}</td>
            <td>${employeetask.deadline}</td>
            </tr>`;

            dataTable.innerHTML+=row;
            
        })
        .catch(error => console.error('Error fetching electives:', error));
    });
}




// function login() {
//     let username = document.getElementById("username").value;
//     let password = document.getElementById("password").value;

//     fetch("http://localhost:8080/employees/login", {
//         method: "POST",
//         headers: { "Content-Type": "application/x-www-form-urlencoded" },
//         body: `email=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`
//     })
//     .then(response => {
//         if (response.ok) {
//             alert("Login successful!");
//             window.location.href = "home.html"; // Redirect to home page
//         } else {
//             alert("Invalid username or password.");
//         }
//     })
//     .catch(error => console.error("Error:", error));
// }

